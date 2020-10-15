package com.xxxx.entity.companypageinfo;


import java.util.LinkedHashMap;

public class DealSize {
    public String Company_Name;
    public LinkedHashMap<String,Double> lhm;

    public DealSize(String company_Name, LinkedHashMap<String, Double> lhm) {
        Company_Name = company_Name;
        this.lhm = lhm;
    }

    public DealSize() {
    }
}
