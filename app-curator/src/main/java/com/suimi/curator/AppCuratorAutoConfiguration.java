/*
 * Copyright (c) 2013-2017, suimi
 */
package com.suimi.curator;

import org.springframework.cloud.zookeeper.ConditionalOnZookeeperEnabled;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author suimi
 * @date 2017-12-01
 */
@Configuration
@ConditionalOnZookeeperEnabled
public class AppCuratorAutoConfiguration {

}
