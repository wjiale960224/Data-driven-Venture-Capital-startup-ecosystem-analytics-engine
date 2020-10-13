package com.xxxx.entity.themeinfo;

public class CompanyTotalInvestment {
    String company_name;
    Double total_investment;
    String theme;

    public CompanyTotalInvestment(String company_name, Double total_investment, String theme) {
        this.company_name = company_name;
        this.total_investment = total_investment;
        this.theme = theme;
    }
}
