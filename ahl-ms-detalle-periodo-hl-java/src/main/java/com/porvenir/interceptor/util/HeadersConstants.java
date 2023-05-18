package com.porvenir.interceptor.util;

public class HeadersConstants {
    private HeadersConstants() {
        throw new IllegalStateException("Utility class");
    }
    //Required
    public static final String X_RQUID = "X-RqUID";
    public static final String X_CHANNEL = "X-Channel";
    public static final String X_COMPANY_ID = "X-CompanyId";
    public static final String X_GOV_ISSUE_IDENT_TYPE = "X-GovIssueIdentType";
    public static final String X_IDENT_SERIAL_NUM = "X-IdentSerialNum";
    public static final String X_IP_ADDR = "X-IPAddr";
    //No required
    public static final String X_NEXT_DT = "X-NextDt";
    public static final String X_SESS_KEY = "X-SessKey";
    public static final String X_LANGUAJE = "X-Languaje";
    public static final String X_VERSION = "X-Version";
    public static final String X_KEY_ACCT_ID = "X-KeyAcctId";
    public static final String X_CUST_LOGIN_ID = "X-CustLoginId";
    public static final String X_NAME = "X-Name";
    //
    public static final String X_FORWARDED_FOR = "X-FORWARDED-FOR";
}