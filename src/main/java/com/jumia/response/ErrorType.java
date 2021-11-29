package com.jumia.response;

public enum ErrorType {

    // 406 Not Acceptable
    INVALID_IP_ADDRESS(ErrorCodes.INVALID_IP_ADDRESS, "INVALID_IP_ADDRESS", "Bad ip address format");
    private final int code;
    private final String status;
    private final String message;

    ErrorType(int code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
    }