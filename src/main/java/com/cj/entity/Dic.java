package com.cj.entity;

public class Dic {
    private String dicType;
    private String dicCode;
    private String dicName;
    private Integer dicWeight;

    public Dic() {
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    @Override
    public String toString() {
        return "Dic{" +
                "dicType='" + dicType + '\'' +
                ", dicCode='" + dicCode + '\'' +
                ", dicName='" + dicName + '\'' +
                ", dicWeight=" + dicWeight +
                '}';
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public Integer getDicWeight() {
        return dicWeight;
    }

    public void setDicWeight(Integer dicWeight) {
        this.dicWeight = dicWeight;
    }
}
