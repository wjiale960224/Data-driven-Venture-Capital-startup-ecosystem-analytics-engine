package com.xxxx.entity.companypageinfo;


import java.util.LinkedHashMap;

public class PostChange {
    public String name;
    public LinkedHashMap<String,Double> lhm;

    public PostChange(String name, LinkedHashMap<String, Double> lhm) {
        this.name = name;
        this.lhm = lhm;
    }
}
