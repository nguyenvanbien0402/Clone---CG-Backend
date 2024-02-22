package com.backend.handler;

import com.backend.enums.ApiStatus;
import com.backend.response.BaseResponse;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

@RestControllerAdvice
public class CustomExHandler {
    @Resource
    private MessageSource messageSource;

    @ExceptionHandler({AuthenticationException.class, AuthorizationServiceException.class})
    public ResponseEntity<?> handleAuthentication(AuthenticationException e) {
        return ResponseEntity.ok(BaseResponse.builder().code(ApiStatus.ACCESS_DENIED.getCode())
                .message(e.getMessage()).build());
    }
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<?> handleNotSuportMethod(HttpRequestMethodNotSupportedException e){
        return ResponseEntity.ok(BaseResponse.builder().code(ApiStatus.ACCESS_DENIED.getCode())
                .message(e.getMessage()).build());
    }

}
