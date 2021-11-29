package com.jumia.exceptions;

import com.jumia.response.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidIpAddressException extends ApplicationException {
    public InvalidIpAddressException(String message) {
        super(message, ErrorType.INVALID_IP_ADDRESS);
    }
}