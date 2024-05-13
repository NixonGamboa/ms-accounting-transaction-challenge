package com.gamboatech.domain.commons;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorCodes errorCode;
    private final Object body;

    public BusinessException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.body = null;
    }

    public BusinessException(String message, ErrorCodes errorCode, Object body) {
        super(message);
        this.errorCode = errorCode;
        this.body = body;
    }
}
