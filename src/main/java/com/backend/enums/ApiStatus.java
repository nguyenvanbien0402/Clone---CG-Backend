package com.backend.enums;

public enum ApiStatus {

    SUCCESS("ASC200","Success"),

    INPUT_ERROR("01", "Data invalid"),
    RESOURCE_NOT_FOUND("02", "Resource not found"),
    UNKNOWN("03", "System error"),
    BAD_CREDENTIALS("04", "Error username or password"),
    BAD_REQUEST("05", "Bad request"),
    UNAUTHORIZED("06", "unauthorized"),
    ACCESS_DENIED("07", "Access denied");
    private String code;
    private String message;

    ApiStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
