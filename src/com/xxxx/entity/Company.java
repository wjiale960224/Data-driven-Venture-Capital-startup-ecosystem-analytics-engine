package com.xxxx.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Company {
    // Field name must match the attribute name in database, otherwise DAO cannot create instance correctly.
    Integer cid;
    String c_name;
    Theme theme;
    Integer year_founded;
    Date runway_end_date;
    Integer runway_month;
    List<Double> raised_to_date;
    Integer employee_no;
    List<Double> revenue;

    public Company() {
    }

    public Company(String company_name, Theme theme) {
        this.cid = CompanyID.get_id();
        this.c_name = company_name;
        this.theme = theme;
        this.raised_to_date = new ArrayList<>();
        this.revenue = new ArrayList<>();
        // update Portfolio composition
        if (!Portfolio.portfolio.contains(company_name)) {
            Portfolio.portfolio.add(company_name);
        }
    }

    public int getCid() {
        return cid;
    }

    public String getCompany_name() {
        return c_name;
    }

    public void setCompany_name(String company_name) {
        this.c_name = company_name;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public int getYear_founded() {
        return year_founded;
    }

    public void setYear_founded(int year_founded) {
        this.year_founded = year_founded;
    }

    public Date getRunway_end_date() {
        return runway_end_date;
    }

    public void setRunway_end_date(Date runway_end_date) {
        this.runway_end_date = runway_end_date;
    }

    public int getRunway_month() {
        return runway_month;
    }

    public void setRunway_month(int runway_month) {
        this.runway_month = runway_month;
    }

    public List<Double> getRaised_to_date() {
        return raised_to_date;
    }

    public void addRaised_to_date(double raised_to_date) {
        this.raised_to_date.add(raised_to_date);
    }

    public int getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(int employee_no) {
        this.employee_no = employee_no;
    }

    public List<Double> getRevenue() {
        return revenue;
    }

    public void addRevenue(double revenue) {
        this.revenue.add(revenue);
    }

    // may be called manually, or automatically after certain event
    public void delete(String company_name) {
        Portfolio.portfolio.remove(company_name);
        // TODO What need to be updated when a company is removed from the portfolio?
    }
}
