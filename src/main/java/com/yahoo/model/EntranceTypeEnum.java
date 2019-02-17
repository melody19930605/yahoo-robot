package com.yahoo.model;

public enum EntranceTypeEnum {
    DIRECT("DIRECT"),
    NPC("NPC");
    private String type;

    public String getType() {
        return type;
    }

    EntranceTypeEnum(String type){
        this.type = type;
    }
}
