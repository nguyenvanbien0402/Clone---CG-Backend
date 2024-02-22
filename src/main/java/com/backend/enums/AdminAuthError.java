package com.backend.enums;

public enum AdminAuthError implements Enums{

    BLANK_INPUT("BLANK_INPUT","Input error"),
    BAD_CREDENTIALS("BAD_CREDENTIALS", "Username is incorrect");

    private final String value;
    private final String text;
    AdminAuthError(String value, String text) {
        this.value = value;
        this.text = text;
    }
    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getText() {
        return this.text;
    }
// kiểm tra xem một giá trị có tồn tại trong enum hay không
    @Override
    public boolean valueOfs(String value) {
        for (AdminAuthError adminAuthError : AdminAuthError.values()) {
            if (adminAuthError.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
