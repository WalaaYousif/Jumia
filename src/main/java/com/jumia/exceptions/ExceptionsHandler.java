package com.jumia.exceptions;

import com.jumia.response.ApiResponse;
import com.jumia.response.ErrorResponse;
import com.jumia.response.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionsHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApiResponse handleException(ErrorType errorType, Exception ex, WebRequest request) {
        logger.error("{}, Request: {}", errorType.getMessage() + ": " + ex.getMessage(), request.getDescription(false));
        return new ErrorResponse(errorType);
    }

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<ApiResponse> handleUnauthorizedException(ApplicationException ex, WebRequest request) {
        ResponseStatus annotation = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if (annotation != null) {
            httpStatus = annotation.code();
        }
        return new ResponseEntity<>(handleException(ex.getErrorType(), ex, request), httpStatus);
    }
}
