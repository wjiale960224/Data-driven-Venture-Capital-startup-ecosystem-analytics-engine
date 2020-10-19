package com.xxxx.entity.themeinfo;

public class ThemeInfomation {
    String theme;
    int company_No;
    Double total_investment_amount;
    Double overall_investment;
    int total_company_No;

    public ThemeInfomation(String theme, int company_No, Double total_investment_amount, Double overall_investment, int total_company_No) {
        this.theme = theme;
        this.company_No = company_No;
        this.total_investment_amount = total_investment_amount;
        this.overall_investment = overall_investment;
        this.total_company_No = total_company_No;
    }
}
