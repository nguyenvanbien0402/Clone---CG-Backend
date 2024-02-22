package com.backend.controller;


import com.backend.constants.Constants;
import com.backend.entity.UserMaster;
import com.backend.entity.authentication.LastLoginToken;
import com.backend.jwt.JwtTokenProvider;
import com.backend.repository.UserMasterRepository;
import com.backend.request.LoginRequest;
import com.backend.response.BaseResponse;
import com.backend.response.auth.LoginResponse;
import com.backend.service.UserMasterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserMasterRepository userMasterRepository;
    @Resource
    private JwtTokenProvider jwtTokenProvider;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()
        ));
        String token = jwtTokenProvider.generateToken(loginRequest.getUsername());
        UserMaster userMaster =
                userMasterRepository.findUserByUsernameandIsActive(loginRequest.getUsername(), Constants.ACTIVE);
        LoginResponse loginResponse = LoginResponse.builder()
                .token(token)
                .userMaster(userMaster)
                .build();
        jwtTokenProvider.setMap(loginRequest.getUsername(), LastLoginToken.builder().token(token).build());
        return new ResponseEntity<>(BaseResponse.builder().data(loginResponse).build(), HttpStatus.OK);
    }


}
