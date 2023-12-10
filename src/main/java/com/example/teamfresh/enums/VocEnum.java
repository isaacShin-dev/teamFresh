package com.example.teamfresh.enums;
// 1: 고객사 귀책, 2: 운송사 귀책
public enum VocEnum {
    VOC_TYPE_1("C", "CUSTOMER"),
    VOC_TYPE_2("D", "DELIVERY");


    private final String key;
    private final String value;

    VocEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        for (VocEnum vocEnum : VocEnum.values()) {
            if (vocEnum.key.equals(key)) {
                return vocEnum.value;
            }
        }
        return null;
    }
}
