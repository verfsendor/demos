package com.test.demos.demos.okhttp;

public enum MyEnum {
    START_1("start_1"),
    START_2("start_2"),
    START_3("start_3"),
    START_4("start_4");

    private String name;

    MyEnum(String x){
        this.name  = x;
    }

    public static MyEnum getStr(String name){
        if(name.equals(START_1.name)){
            return START_1;
        }
        if(name.equals(START_2.name)){
            return START_1;
        }
        if(name.equals(START_3.name)){
            return START_1;
        }
        if(name.equals(START_4.name)){
            return START_1;
        }
        return START_1;
    }
}
