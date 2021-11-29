package com.jumia.validator;

import com.jumia.exceptions.InvalidIpAddressException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GatewayValidator {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void validateIpAddress(String ipAddress) {
        String pattern = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        if (!ipAddress.matches(pattern)) {
            throw new InvalidIpAddressException("Bad ip address format");
        }
    }
}