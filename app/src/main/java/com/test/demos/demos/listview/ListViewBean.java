package com.test.demos.demos.listview;

public class ListViewBean  {
    private String name;
    private String value;
    private String date;
    private String desc;

    public ListViewBean(String name, String value, String date, String desc){
        this.name = name;
        this.value = value;
        this.date = date;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
