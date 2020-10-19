package com.xxxx.entity.overview;

public class MainpageData {
    String company_name;
    String theme;
    Double fund;

    public MainpageData(String company_name, String theme, Double fund) {
        this.company_name = company_name;
        this.theme = theme;
        this.fund = fund;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }
}
