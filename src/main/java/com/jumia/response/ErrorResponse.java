package com.jumia.response;

public class ErrorResponse extends ApiResponse {

    public ErrorResponse(ErrorType error) {
        super(error.getCode(), error.getStatus(), error.getMessage(), false);
    }
}