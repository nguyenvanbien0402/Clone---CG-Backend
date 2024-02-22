package com.backend.exceptions;

import com.backend.enums.AdminAuthError;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.parameters.P;

public class AdminAuthenException extends AuthenticationException {

    // tạo một exception , vào tạo contructor cho nó, với adminerror là cause
    private AdminAuthError adminAuthError;
    public AdminAuthenException(String msg, AdminAuthError adminAuthError) {
        super(msg);
        this.adminAuthError = adminAuthError;
    }

    public AdminAuthError getAdminAuthError(){return this.adminAuthError;}
}
