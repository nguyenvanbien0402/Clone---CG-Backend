package com.backend.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ValidateError implements Serializable, Comparable<ValidateError> {


    private String errorCode;

    private String fieldName;

    private Object ruleOfValue;

    private Object validatedValue;
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getRuleOfValue() {
        return ruleOfValue;
    }

    public void setRuleOfValue(Object ruleOfValue) {
        this.ruleOfValue = ruleOfValue;
    }

    public Object getValidatedValue() {
        return validatedValue;
    }

    public void setValidatedValue(Object validatedValue) {
        this.validatedValue = validatedValue;
    }


    @Override
    public int compareTo(ValidateError o) {
        return 0;
    }
}
