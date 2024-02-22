package com.backend.jwt;


import com.backend.entity.authentication.LastLoginToken;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import java.util.Date;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    @Value("${authentication.secret.key}")
    private String jwtSecretKey;

    @Value("${authentication.session.timeout}")
    private Integer jwtTokenExpireTime;
    // method Tao token
    // check expire time
    // checktokend
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);
    private Map<String, LastLoginToken> map = new HashMap<>();
    public String generateToken (String userName) {
        return Jwts.builder()
                .setSubject(String.valueOf(userName))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .setExpiration(new Date(System.currentTimeMillis() + jwtTokenExpireTime)).compact();
    }

    public boolean checkExpireTime (String userName, String jwt){
        LastLoginToken lastLoginToken = map.get(userName);
        if(!StringUtils.hasText(jwt) && !jwt.equalsIgnoreCase(lastLoginToken.getToken())){
            return false;
        }
        Date exprireDate = DateUtils.addHours(lastLoginToken.getLastLoginDate(),jwtTokenExpireTime);
        Date currentDate = new Date(System.currentTimeMillis());
        if (exprireDate.after(currentDate)){
            return true;
        }
        return false;

    }

    public void setMap(String userName, LastLoginToken lastLoginToken){
        this.map.put(userName, lastLoginToken);
    }

    public String getUserNameFromJWT(String token) {
        Claims claims =Jwts.parser()
                .setSigningKey(jwtSecretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken (String token){
        try {
            Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token);
                    return true;
        }catch (MalformedJwtException ex) {
            LOGGER.warn("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            LOGGER.warn("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            LOGGER.warn("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            LOGGER.warn("JWT claims string is empty.");
        }
        return false;
    }
}
