/*
 * Copyright (c) 2013-2017, suimi
 */
package com.suimi.curator.leader;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.suimi.curator.annotation.AppLeader;
import com.suimi.curator.exception.NotLeadershipException;

/**
 * @author suimi
 * @date 2017-12-01
 */
@Aspect
@Component
public class AppLeaderAspect {

    @Autowired
    private ApplicationLeader leader;

    @Pointcut("@annotation(com.suimi.curator.annotation.AppLeader)")
    public void leaderAspect() {
    }

    @Around("leaderAspect() && @annotation(appLeader)")
    public Object aroundMethod(ProceedingJoinPoint pjp, AppLeader appLeader) throws Throwable {
        if (leader.isLeader()) {
            return pjp.proceed();
        }
        if (appLeader.quite()) {
            return null;
        }
        throw new NotLeadershipException(
                pjp.getTarget().getClass().getSimpleName() + "#" + pjp.getSignature().getName());
    }
}
