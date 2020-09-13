package com.xxxx.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Fei
 * @date 2020/9/10 17:27
 * @author Zihang
 * @date 2020/9/14
 */
public class Company {
    int cid;
    String company_name;
    Theme theme;
    int year_founded;
    Date runway_end_date;
    int runway_month;
    List<Double> raised_to_date;
    int employee_no;
    List<Double> revenue;

    public Company() {
    }

    public Company(String company_name, Theme theme) {
        this.cid = CompanyID.get_id();
        this.company_name = company_name;
        this.theme = theme;
        this.raised_to_date = new ArrayList<>();
        this.revenue = new ArrayList<>();
    }

    public int getCid() {
        return cid;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
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
}
