package com.backend.jwt;

import com.backend.constants.Constants;
import com.backend.entity.UserMaster;
import com.backend.entity.authentication.LastLoginToken;
import com.backend.repository.UserMasterRepository;
import com.backend.service.UserMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger LOG = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    @Resource
    private JwtTokenProvider jwtTokenProvider;

    @Resource
    private UserMasterService userMasterService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = null;
            if (StringUtils.hasText(request.getHeader("Authorization"))) {
                jwt = request.getHeader("Authorization").substring(7);
            }
            if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)) {
                String userName = jwtTokenProvider.getUserNameFromJWT(jwt);
                if (jwtTokenProvider.checkExpireTime(userName, jwt)) {
                    UserMaster userMaster = userMasterService.loadUserByUserName(userName);
                    {
                        if (userMaster != null) {
                            jwtTokenProvider.setMap(userName, LastLoginToken.builder().token(jwt).build());

                            UsernamePasswordAuthenticationToken authentication =
                                    new UsernamePasswordAuthenticationToken(userMaster, userMaster);
                            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            LOG.error("Failed on set user authentication");
        } filterChain.doFilter(request, response);
    }
}