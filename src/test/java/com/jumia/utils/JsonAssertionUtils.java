package com.jumia.utils;

import com.jumia.response.ErrorType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class JsonAssertionUtils {

    public static ResultMatcher jsonErrorResponse(ErrorType errorType) {
        int code = Integer.parseInt((errorType.getCode() + "000").substring(0, 3));
        return ResultMatcher.matchAll(
                status().is(code),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$.success", equalTo(false)),
                jsonPath("$.message", not(emptyOrNullString())),
                jsonPath("$.code", equalTo(errorType.getCode())),
                jsonPath("$.status", equalTo(errorType.getStatus()))
        );
    }
}