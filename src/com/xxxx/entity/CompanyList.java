package com.xxxx.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fei
 * @date 2020/9/10 23:02
 */
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
