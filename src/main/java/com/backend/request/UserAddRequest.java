package com.backend.request;

import com.backend.validation.Required;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddRequest {


    @Required
    @Length(max = 255)
    private String userName;

    @Required
    @Length(max = 255)
    private String fullName;

    @Required
    @Length(max = 255)
    private String password;

    @Required
    @Length(max = 255)
    private String confirmPassword;

    @Required
    @DecimalMax("9")
    private Integer role;
}
