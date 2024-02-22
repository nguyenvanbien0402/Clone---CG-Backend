package com.backend.validation;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<Required, Object> {
    @Override
    public void initialize(Required constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(o instanceof String){
            return StringUtils.hasText(o.toString());
        }
        return !ObjectUtils.isEmpty(o);
    }
}
