package com.yahoo.model;

public enum MyCityEnum {
    DF("DF"),
    SLD("SLD"),
    CAC("CAC"),
    JY("JY"),
    JNYW("JNYW"),
    DHW("DHW"),
    AL("AL"),
    LG("LG"),
    SJG("SJG"),
    CF_GJ("CF_GJ"),
    DHW_XB("DHW_XB"),
    DTGJ_DTJW("DTGJ_DTJW"),
    DTJW("DHW_XB"),
    DTGJ("DTGJ"),
    DTJW_CSJW_TD("DTJW_CSJW_TD"),
    DTGF("DTGF"),
    CYJF("CYJF"),
    CFBJ("CFBJ"),
    CSJW("CSJW"),
    CSC("CSC"),
    TG("TG"),
    PTS("PTS"),
    QQF("QQF"),
    STL("STL"),
    LDD("LDD"),
    WZG("WZG"),
    SWD("SWD"),
    YWD("YWD"),
    EDW("EDW"),
    CYJ("CYJ"),
    HGS("HGS"),
    BJLZ("BJLZ"),
    FCS("FCS"),
    MWZ("MWZ"),
    MWJ("MWJ"),
    HSS("HSS"),
    CJG("CJG"),
    CYD("CYD"),
    MWD("MWD"),
    LXBD("LXBD"),
    NEC("NEC"),
    PSL("PSL"),
    PSD("PSD")
    ;
    private String city;

    public String getCity() {
        return city;
    }

    MyCityEnum(String city){
        this.city = city;
    }
}
