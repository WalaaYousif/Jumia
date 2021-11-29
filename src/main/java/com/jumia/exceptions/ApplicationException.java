package com.jumia.exceptions;

import com.jumia.response.ErrorType;

public class ApplicationException extends RuntimeException {

    private final ErrorType errorType;

    public ApplicationException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}