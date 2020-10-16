package com.xxxx.entity.themeinfo;

import java.util.Date;

public class CompanyInfo {
    String company_name;
    String theme;
    String deal_no;
    String investment_data;
    Double cost;
    Double own;
    Double current_valuation;
    String investment_multiple;
    Double irr;
    Double post_valuation;

    public CompanyInfo() {
    }

    public CompanyInfo(String company_name, String theme, String deal_no, String investment_data, Double cost, Double own, Double current_valuation, String investment_multiple, Double irr, Double post_valuation) {
        this.company_name = company_name;
        this.theme = theme;
        this.deal_no = deal_no;
        this.investment_data = investment_data;
        this.cost = cost;
        this.own = own;
        this.current_valuation = current_valuation;
        this.investment_multiple = investment_multiple;
        this.irr = irr;
        this.post_valuation = post_valuation;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setDeal_no(String deal_no) {
        this.deal_no = deal_no;
    }

    public void setInvestment_data(String investment_data) {
        this.investment_data = investment_data;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setOwn(Double own) {
        this.own = own;
    }

    public void setCurrent_valuation(Double current_valuation) {
        this.current_valuation = current_valuation;
    }

    public void setInvestment_multiple(String investment_multiple) {
        this.investment_multiple = investment_multiple;
    }

    public void setIrr(Double irr) {
        this.irr = irr;
    }

    public void setPost_valuation(Double post_valuation) {
        this.post_valuation = post_valuation;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getTheme() {
        return theme;
    }

    public String getDeal_no() {
        return deal_no;
    }

    public String getInvestment_data() {
        return investment_data;
    }

    public Double getCost() {
        return cost;
    }

    public Double getOwn() {
        return own;
    }

    public Double getCurrent_valuation() {
        return current_valuation;
    }

    public String getInvestment_multiple() {
        return investment_multiple;
    }

    public Double getIrr() {
        return irr;
    }

    public Double getPost_valuation() {
        return post_valuation;
    }
}
