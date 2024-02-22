package com.backend.helper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.annotation.Resource;
import javax.validation.*;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ValidatorUltil {


    @Resource
    private LocalValidatorFactoryBean validator;

    public BindingResult validateAndDetectError(Object bean, Class... clazz) {
        if (bean == null) {
            return null;
        }
        BindingResult errors = new BeanPropertyBindingResult(bean, bean.getClass().getName());
        validator.validate(bean, errors, clazz);
        return errors;
    }
}
