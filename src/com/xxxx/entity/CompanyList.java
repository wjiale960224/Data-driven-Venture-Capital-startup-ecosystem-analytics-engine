package com.xxxx.entity;

import java.util.ArrayList;
import java.util.List;


// The class to store companies, used in JSON convert to Java class process.
public class CompanyList {
    public List<Company> arrayList;

    public CompanyList() {
        arrayList = new ArrayList<>();
    }

    public CompanyList(ArrayList<Company> arrayList) {
        this.arrayList = arrayList;

    }
}
