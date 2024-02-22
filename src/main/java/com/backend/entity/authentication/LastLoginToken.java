package com.backend.entity.authentication;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LastLoginToken {

    private String token;
    @Builder.Default
    private Date lastLoginDate = new Date();
}
