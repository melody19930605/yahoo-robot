package com.yahoo.model;

public enum MyCityEnum {
    CAC("CAC"),
    JY("JY"),
    JNYW("JNYW"),
    DHW("DHW"),
    AL("AL"),
    LG("LG"),
    SJG("SJG"),
    CF_GJ("CF_GJ"),
    DTGJ("DTGJ"),
    DTJW("DTJW"),
    DTGF("DTGF"),
    CSJW("CSJW"),
    CSC("CSC"),
    TG("TG"),
    PTS("PTS"),
    QQF("QQF"),
    STL("STL"),
    WZG("WZG"),
    DDW("DDW"),
    EDW("EDW"),
    SDW("SDW"),
    CYJ("CYJ"),
    HGS("HGS"),
    BJLZ("BJLZ"),
    FCS("FCS"),
    MWZ("MWZ"),
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
