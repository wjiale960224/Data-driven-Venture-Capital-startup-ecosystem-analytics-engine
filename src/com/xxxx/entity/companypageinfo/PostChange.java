package com.xxxx.entity.companypageinfo;


import java.util.LinkedHashMap;

public class PostChange {
    public String Company_Name;
    public LinkedHashMap<String,Double> lhm;

    public PostChange(String Company_Name, LinkedHashMap<String, Double> lhm) {
        this.Company_Name = Company_Name;
        this.lhm = lhm;
    }
}
