package com.jumia.util;

public enum Country {
    CAMEROON("237", "Cameroon"),
    ETHIOPIA("251", "Ethiopia");

    private String code;
    private String name;

    Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
}