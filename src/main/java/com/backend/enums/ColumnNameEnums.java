package com.backend.enums;

public enum ColumnNameEnums {

    USER_NAME("User Name", "アカウント"),
    FULL_NAME("Full Name", "名前"),
    NAME("Name", "名前"),
    PASSWORD("Password", "パスワード"),
    CONFIRM_PASSWORD("Confirm Password", "パスワード再入力"),
    CURRENT_PASSWORD("Current Password", "現在のパスワード"),
    NEW_PASSWORD("New Password", "新しいパスワード"),

    ROLE("Role", "役割"),
    // Project Type Mst
    PROJECT_TYPE_NAME("Project Type Name", "案件種類"),
    // Setting Type Mst
    SETTING_TYPE("Setting Type", "設定種類"),
    // Registration Type Mst
    REGISTRATION_TYPE_NAME("Registration Type Name", "名前"),
    EQUITY("Equity", "持分"),
    EQUITY_CODE("Equity Code", "持分 + コード用場所"),
    LOCATION_ID("Location Id", "場所"),
    POST_CODE("Post Code", "Post Code"),
    REAL_ESTATE_DISPLAY_KEY("Real Estate Display Key", "(場所 + 階数)"),
    RETURN_LP("Return Lp", "返送LP"),
    DELIVERY_CODE("Delivery Code", "発送number"),

    UPGRADE_FROM("Upgrade From", "原契約番号"),

    PROJECT_NO("Project No", "Project No"),
    TRANSFER_NUM_1("Transfer Num1", "移転受番1"),
    L_SETTING_NUM_1("L Setting Num1", "L設定受番1"),
    PIPE_TRANSFER_NUM_1("Pipe Transfer Num1", "管設定受番1"),
    TRANSFER_NUM_2("Transfer Num2", "移転受番2"),
    L_SETTING_NUM_2("L Setting Num2", "L設定受番2"),
    PIPE_TRANSFER_NUM_2("Pipe Transfer Num2", "管設定受番2"),
    TRANSFER_NUM_3("Transfer Num3", "移転受番3"),
    L_SETTING_NUM_3("L Setting Num3", "L設定受番3"),
    PIPE_TRANSFER_NUM_3("Pipe Transfer Num3", "管設定受番3"),
    TRANSFER_NUM_4("Transfer Num4", "移転受番4"),
    L_SETTING_NUM_4("L Setting Num4", "L設定受番4"),
    PIPE_TRANSFER_NUM_4("Pipe Transfer Num4", "管設定受番4"),
    CANCEL_NUM_1("Cancel Num1", "抹消受番1"),
    CANCEL_NUM_2("Cancel Num2", "抹消受番2"),
    CANCEL_NUM_3("Cancel Num3", "抹消受番3"),
    CANCEL_NUM_4("Cancel Num4", "抹消受番4"),
    ZIP_CODE("Zip Code", "Postal Code"),
    ADDRESS_EN("Address En", "Address 1"),
    PHONE_2("Second Tel", "Phone 2"),
    PHONE_3("Third Tel", "Phone 3"),
    CUSTOMER_NAME_EN("Customer Name En", "名前(英)"),
    CUSTOMER_NAME_JP("Customer Name Jp", "名前(日)"),
    REMARKS("Remarks", "備考"),
    FINANCE_TYPE("Finance Type Id", "ローン有無"),
    LOCATION("Location Id", "場所"),
    ADDRESS("Address", "住所"),
    PROJECT_TYPE("Project Type Id", "案件種類"),
    CONTRACT_TYPE("Contract Type Id", "Contract Type"),
    REQUEST_DATE("Request Date", "依頼日"),
    WORDS("Words", "口数"),
    ACQUIRED_EQUITY_1("Acquired Equity 1", "取得持分1"),
    ACQUIRED_EQUITY_2("Acquired Equity 2", "取得持分2"),
    ACQUIRED_EQUITY_3("Acquired Equity 3", "取得持分3"),
    ACQUIRED_EQUITY_4("Acquired Equity 4", "取得持分4"),
    EST_DELIVERY_DATE("Est Delivery Date", "クロージング日"),
    PURCHASE_FLOOR_1("Purchase Floor 1", "購入階1"),
    PURCHASE_FLOOR_2("Purchase Floor 2", "購入階2"),
    PURCHASE_FLOOR_3("Purchase Floor 3", "購入階3"),
    PURCHASE_FLOOR_4("Purchase Floor 4", "購入階4"),
    REPRESENTATIVE_NAME("Representative Name", "法人代表名"),
    LOAN_LIMIT("Loan Limit", "ローン極度額"),
    MORTGAGE_TYPE("Mortgage Type", "抵当権種類"),
    PREPARE_FORM_PIC("Prepare Form Pic", "申請書作成担当者"),
    PREPARE_FORM_DATE("Prepare Form Date", "申請書作成日"),
    PRIMARY_CHECK_FORM_PIC("Primary Check Form Pic", "申請書作成一次チェック担当者"),
    PRIMARY_CHECK_FORM_DATE("Primary Check Form Date", "一次チェック対応日");

    ColumnNameEnums(String value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * The value.
     */
    private final String value;

    /**
     * The text.
     */
    private final String text;

    public String getValue() {
        return this.value;
    }

    public String getText() {
        return this.text;
    }

    public static ColumnNameEnums valueOfs(String value) {
        for (ColumnNameEnums columnNameEnums : ColumnNameEnums.values()) {
            if (columnNameEnums.getValue().equalsIgnoreCase(value)) {
                return columnNameEnums;
            }
        }
        return null;
    }
}
