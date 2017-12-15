/*
 * Copyright (c) 2013-2017, suimi
 */
package com.suimi.curator.annotation;

import java.lang.annotation.*;

import com.suimi.curator.exception.NotLeadershipException;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AppLeader {

    /**
     * if <code>true</code>, will quiet skip and return null, else throw @see {@link NotLeadershipException}
     */
    boolean quite() default true;
}
