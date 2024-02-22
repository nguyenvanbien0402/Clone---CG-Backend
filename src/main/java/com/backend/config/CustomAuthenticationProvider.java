package com.backend.config;

import com.backend.constants.Constants;
import com.backend.entity.UserMaster;
import com.backend.enums.AdminAuthError;
import com.backend.exceptions.AdminAuthenException;
import com.backend.repository.UserMasterRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserMasterRepository userMasterRepository;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        if(!StringUtils.hasText(userName) || !StringUtils.hasText(password)){
            throw new  AdminAuthenException("Input Error", AdminAuthError.BLANK_INPUT);
        }
        UserMaster userMaster = userMasterRepository.findUserByUsernameandIsActive(userName, Constants.ACTIVE);
        if(ObjectUtils.isEmpty(userMaster)){
            throw new AdminAuthenException("User Name is incorrect", AdminAuthError.BAD_CREDENTIALS);
        }
        if (!passwordEncoder.matches(password, userMaster.getPassword())){
            throw new AdminAuthenException("Password is incorrect", AdminAuthError.BAD_CREDENTIALS);
        }
        return new UsernamePasswordAuthenticationToken(userName,password);
    }

    @Override
    public boolean supports( Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
