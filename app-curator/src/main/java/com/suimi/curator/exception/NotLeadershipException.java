/*
 * Copyright (c) 2013-2017, suimi
 */
package com.suimi.curator.exception;

/**
 * @author suimi
 * @date 2017-12-01
 */
public class NotLeadershipException extends Exception {

    public NotLeadershipException() {
    }

    public NotLeadershipException(String message) {
        super(message);
    }

    public NotLeadershipException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLeadershipException(Throwable cause) {
        super(cause);
    }

    public NotLeadershipException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
