package com.jumia.utils;

import org.springframework.test.web.servlet.request.RequestPostProcessor;

public class RequestUtils {

    /**
     * Add the parameter to the request only if the provided value is not null
     *
     * @param name  parameter name
     * @param value parameter value
     * @return
     */
    public static RequestPostProcessor optionalParam(String name, String value) {
        return (request -> {
            if (value != null)
                request.addParameter(name, value);
            return request;
        });
    }

    public static RequestPostProcessor pagination(String pageNo, String pageSize) {
        return applyAll(
                optionalParam("pageNo", pageNo),
                optionalParam("pageSize", pageSize)
        );
    }

    private static RequestPostProcessor applyAll(RequestPostProcessor... requestPostProcessors) {
        return (request -> {
            for (RequestPostProcessor requestPostProcessor : requestPostProcessors)
                request = requestPostProcessor.postProcessRequest(request);
            return request;
        });
    }
}