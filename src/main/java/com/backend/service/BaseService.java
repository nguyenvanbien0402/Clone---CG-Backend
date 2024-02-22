package com.backend.service;

import com.backend.constants.Constants;
import com.backend.enums.ColumnNameEnums;
import com.backend.helper.StringHelper;
import com.backend.helper.ValidateError;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public  abstract  class BaseService {

    @Resource
    private MessageSource messageSource;

    public String getMessage (String key, Object ...objects) {
            return messageSource.getMessage(key,objects, LocaleContextHolder.getLocale());
    }


    public List<ValidateError>  buildMessageErrorValidate(BindingResult bindingResult){
        List<ValidateError> validateErrors = new ArrayList<>();
        bindingResult.getAllErrors().forEach(validateError->{
        ValidateError validateError1 = new ValidateError();
        String message = messageSource.getMessage(validateError, LocaleContextHolder.getLocale());
            String fieldName = "";
            try {
                fieldName = ((FieldError) validateError).getField();
            } catch (Exception e) {
                LoggerFactory.getLogger(BaseService.class).info(e.getMessage());
            }
            String upperFieldName =
                    StringHelper.capitalizeFirstLetter(fieldName).replaceAll("(?!^)([A-Z])", " $1");
            ColumnNameEnums column = ColumnNameEnums.valueOfs(upperFieldName);
            if (column != null) {
                upperFieldName = column.getText();
            }
            validateError1.setErrorCode(
                    upperFieldName.concat(Constants.SPACE).concat(message));
            validateError1.setFieldName(fieldName);
            validateErrors.add(validateError1);
        });
        return validateErrors;
    }
}
