package com.xxxx.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fei
 * @date 2020/9/11 11:19
 */
// The class to store companies, used in JSON convert to Java class process.
public class DealList {
    public List<Deal> arrayList;

    public DealList() {
        arrayList = new ArrayList<>();
    }

    public DealList(ArrayList<Deal> arrayList) {
        this.arrayList = arrayList;
    }
}
