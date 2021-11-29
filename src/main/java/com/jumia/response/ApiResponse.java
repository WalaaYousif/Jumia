package com.jumia.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiResponse {

    private int code;

    private String status;

    private String message;

    private boolean success;

    public ApiResponse(int code, String status, String message, boolean success) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
