package com.policy.expert.exceptions;

public class ParamException extends RuntimeException {

    public ParamException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
