package com.backend.url;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * The type Url access decision manager.
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> collection) {
        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new AccessDeniedException("Access denied!");
        }
        for (ConfigAttribute ca : collection) {
            String needRole = ca.getAttribute();
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("Access denied!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    /**
     * Supports boolean.
     *
     * @param aClass the a class
     * @return the boolean
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
