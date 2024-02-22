package com.backend.url;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class UrlFilterInvocationSecurityMetadataSource.
 */
@Component
public class UrlFilterInvocationSecurityMetadataSource
    implements FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if (isEquals(requestUrl, "/swagger-ui-custom.html,", "/api/logout", "/api/login")
            || isPrefix(requestUrl,"/api/File/error","/api/File/template")) {
            return Collections.emptyList();
        }
        Collection<? extends GrantedAuthority> roles =
            SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        List<String> roleNames = roles.stream()
            .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return SecurityConfig.createList(roleNames.toArray(new String[roleNames.size()]));
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return Collections.emptyList();
    }

    /**
     * Supports boolean.
     *
     * @param aClass the a class
     * @return the boolean
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }

    /**
     * Checks if is equals.
     *
     * @param requestUrl  the request url
     * @param patternUrls the pattern urls
     * @return true, if is equals
     */
    private boolean isEquals(String requestUrl, String... patternUrls) {
        for (String patternUrl : patternUrls) {
            if (patternUrl.equalsIgnoreCase(requestUrl)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if is prefix.
     *
     * @param requestUrl  the request url
     * @param patternUrls the pattern urls
     * @return true, if is prefix
     */
    private boolean isPrefix(String requestUrl, String... patternUrls) {
        for (String patternUrl : patternUrls) {
            if (requestUrl.startsWith(patternUrl)) {
                return true;
            }
        }
        return false;
    }
}
