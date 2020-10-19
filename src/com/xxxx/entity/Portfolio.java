package com.xxxx.entity;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    public static List<String> portfolio = new ArrayList<>(); // record company names

    public static List<Integer> portfolio1 = new ArrayList<>(); // record company names

    public static List<String> getPortfolio() {
        return portfolio;
    }

    public static List<Integer> getPortfolio1() {
        return portfolio1;
    }
}
