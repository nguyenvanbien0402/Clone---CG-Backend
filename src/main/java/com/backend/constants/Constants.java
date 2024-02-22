package com.backend.constants;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;


public class Constants {

    public static final Integer ACTIVE = 1;
    public static final Integer INACTIVE = 2;

    public static final String EMPTY = "";
    public static final String NULL = "NULL";
    public static final String UNDERSCORE = "_";
    public static final String DOT = ".";
    public static final String SPACE = " ";
    public static final String SLASH = "/";
    public static final String BRACKETS = ")";
    public static final String REQUEST_ERROR = "Request error";
    public static final String JP_EXISTED = "有";
    public static final String JP_NONE = "無";
    public static final String COMMA_SEPARATED_HUNDREDS = "#,###";
    public static final String GA = "が";
    public static final String ERROR = "Error";



    public static final String FILE_JP = "資料";
    public static final String NAME_SCREEN_USER = "USER LIST";
    public static final String NAME_SCREEN_CONTRACT_TYPE = "CONTRACT TYPE LIST";
    public static final String NAME_SCREEN_FINANCE_TYPE = "FINANCE TYPE LIST";
    public static final String NAME_SCREEN_LOCATION = "LOCATION LIST";
    public static final String NAME_SCREEN_PROJECT_TYPE = "PROJECT TYPE LIST";
    public static final String NAME_SCREEN_SECURITY_RIGHTS = "SECURITY RIGHTS LIST";
    public static final String NAME_SCREEN_UPGRADE_CONTRACT_TYPE = "UPGRADE CONTRACT TYPE LIST";
    public static final String NAME_SCREEN_KEY = "KEY LIST";
    public static final String NAME_SCREEN_EQUITY = "EQUITY LIST";
    public static final String NAME_SCREEN_POST_CODE = "POST CODE LIST";
    public static final String NAME_SCREEN_DOCUMENT = "案件一覧";
    public static final String NAME_SCREEN_RECORD_SCHEDULE_APP_TO_HGV = "登記申請予定報告一覧";
    public static final String NAME_SCREEN_RECORD_REG_APP = "登記申請記録";
    public static final String NAME_SCREEN_RECORD_CALL_LOG = "架電記録";
    public static final String NAME_SCREEN_RECORD_DELIVERY = "オーナー宛捺印書類発送記録";
    public static final String NAME_SCREEN_RECORD_DOC_STAMPED = "捺印書類受取記録";
    public static final String NAME_SCREEN_RECORD_REG_COMPLETE = "納品記録";
    public static final String NAME_SCREEN_WAITING_COMPLETION = "融資完済状況確認";


    public static final String PATH_HGV_R01= "/data/template/hgv/template_M07_R01.xlsx";
    public static final String PATH_HGV_R02= "/data/template/hgv/template_M07_R02.xlsx";

    public static final String PATH_RECORD_REG_APP_R01= "/data/template/record-reg-app/template_M0809_R01.xlsx";
    public static final String PATH_RECORD_REG_APP_R02= "/data/template/record-reg-app/template_M0809_R02.xlsx";
    public static final String PATH_RECORD_REG_APP_R03= "/data/template/record-reg-app/template_M0809_R03.xlsx";
    public static final String PATH_RECORD_REG_APP_R04= "/data/template/record-reg-app/template_M0809_R04.xlsx";
    public static final String PATH_RECORD_REG_APP_R05= "/data/template/record-reg-app/template_M0809_R05.xlsx";

    public static final String PATH_RECORD_DELIVERY_R01= "/data/template/record-delivery/template_M05_R01.xlsx";

    public static final String PATH_DOCUMENT_R01= "/data/template/document/template_M01_download0.xlsx";


}
