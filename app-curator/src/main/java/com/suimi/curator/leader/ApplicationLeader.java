/*
 * Copyright (c) 2013-2017, suimi
 */
package com.suimi.curator.leader;

import java.util.concurrent.CountDownLatch;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author suimi
 * @date 2017-12-01
 */
@Component
@Slf4j
public class ApplicationLeader {

    @Value("/${spring.application.name:app-${random.value}}")
    private String appName;

    @Autowired
    private CuratorFramework client;

    private LeaderSelector leaderSelector;

    private String leaderPath = "/leader";

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @PostConstruct
    public void init() {
        log.info("init learder selector");
        leaderSelector = new LeaderSelector(client, appName + leaderPath, new LeaderSelectorListenerAdapter() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
                log.info("take leadership");
                countDownLatch.await();
            }
        });
        leaderSelector.autoRequeue();
        leaderSelector.start();
    }

    public boolean isLeader() {
        return leaderSelector.hasLeadership();
    }

    public void release() {
        countDownLatch.countDown();
        if (log.isDebugEnabled()) {
            log.debug("released leadership");
        }
    }

    public void close() {
        leaderSelector.close();
        if (log.isDebugEnabled()) {
            log.debug("closed leader selector");
        }
    }

    public void destory() {
        if (leaderSelector != null) {
            leaderSelector.close();
            log.info("closed learder selector");
        }
    }
}
