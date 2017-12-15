/*
 * Copyright (c) 2013-2017, suimi
 */
package com.suimi.test.service;

import org.springframework.stereotype.Service;

import com.suimi.curator.annotation.AppLeader;

/**
 * @author suimi
 * @date 2017-12-01
 */
@Service
public class TestService {

    @AppLeader
    public String test(String value) {
        return value;
    }

    @AppLeader(quite = false)
    public String testException(String value) {
        return value;
    }
}
