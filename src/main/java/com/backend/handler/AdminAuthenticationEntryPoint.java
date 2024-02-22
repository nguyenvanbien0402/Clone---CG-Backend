package com.backend.handler;


import com.backend.enums.ApiStatus;
import com.backend.response.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AdminAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(BaseResponse.builder().code(ApiStatus.UNAUTHORIZED.getCode()).build()));
    }
}
