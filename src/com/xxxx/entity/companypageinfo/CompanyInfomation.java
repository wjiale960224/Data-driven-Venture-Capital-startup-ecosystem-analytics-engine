package com.xxxx.entity.companypageinfo;

public class CompanyInfomation {
    String company_name;
    String theme;
    Double total_mseq_invest;
    int deal_no;
    Double current_valuation;
    int runaway_month;
    String stage;
    Double return_fund;
    Double own;
    int employee_no;
    Double revenue;

    public CompanyInfomation(String company_name, String theme, Double total_mseq_invest, int deal_no, Double current_valuation, int runaway_month, String stage, Double return_fund, Double own, int employee_no, Double revenue) {
        this.company_name = company_name;
        this.theme = theme;
        this.total_mseq_invest = total_mseq_invest;
        this.deal_no = deal_no;
        this.current_valuation = current_valuation;
        this.runaway_month = runaway_month;
        this.stage = stage;
        this.return_fund = return_fund;
        this.own = own;
        this.employee_no = employee_no;
        this.revenue = revenue;
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

    public Double getTotal_mseq_invest() {
        return total_mseq_invest;
    }

    public void setTotal_mseq_invest(Double total_mseq_invest) {
        this.total_mseq_invest = total_mseq_invest;
    }

    public int getDeal_no() {
        return deal_no;
    }

    public void setDeal_no(int deal_no) {
        this.deal_no = deal_no;
    }

    public Double getCurrent_valuation() {
        return current_valuation;
    }

    public void setCurrent_valuation(Double current_valuation) {
        this.current_valuation = current_valuation;
    }

    public int getRunaway_month() {
        return runaway_month;
    }

    public void setRunaway_month(int runaway_month) {
        this.runaway_month = runaway_month;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Double getReturn_fund() {
        return return_fund;
    }

    public void setReturn_fund(Double return_fund) {
        this.return_fund = return_fund;
    }

    public Double getOwn() {
        return own;
    }

    public void setOwn(Double own) {
        this.own = own;
    }

    public int getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(int employee_no) {
        this.employee_no = employee_no;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }
}
