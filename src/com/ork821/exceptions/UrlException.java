package com.ork821.exceptions;

public class UrlException extends Exception {
    private UrlErrorCodes errorCode;

    public UrlException(UrlErrorCodes errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public UrlErrorCodes getErrorCode() {
        return this.errorCode;
    }
}


