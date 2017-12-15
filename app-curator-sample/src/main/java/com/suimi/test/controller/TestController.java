/*
 * Copyright (c) 2013-2017, suimi
 */
package com.suimi.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suimi.test.service.TestService;

/**
 * @author suimi
 * @date 2017-12-01
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test")
    public String test(String value) {
        return testService.test(value);
    }

    @GetMapping("testException")
    public String testException(String value) {
        return testService.testException(value);
    }
}
