package com.yahoo.model;

public enum MyNPCEnum {
    //东海湾傲来车夫
    DHW_AL_CF("DHW_AL_CF");


    private String name;

    public String getName() {
        return name;
    }

    MyNPCEnum(String name){
        this.name = name;
    }
}
