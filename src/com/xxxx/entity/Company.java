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
    String runway_start_date;
    String runway_end_date;
    Integer runway_month;
    Double raised_to_date;
    Integer employee_no;
    Double revenue;

    public Company() {
    }

    public Company(String company_name, Theme theme) {
        this.cid = CompanyID.get_id();
        this.c_name = company_name;
        this.theme = theme;
        this.raised_to_date = 0.00;
        this.revenue = 0.00;
        // update Portfolio composition
        if (!Portfolio.portfolio.contains(company_name)) {
            Portfolio.portfolio.add(company_name);
        }
    }

    public Company(Integer cid, String c_name, Theme theme, Integer year_founded, String runway_start_date, String runway_end_date,
                   Double raised_to_date, Integer employee_no, Double revenue) {
        this.cid = cid;
        this.c_name = c_name;
        this.theme = theme;
        this.year_founded = year_founded;
        this.runway_start_date = runway_start_date;
        this.runway_end_date = runway_end_date;
        this.raised_to_date = raised_to_date;
        this.employee_no = employee_no;
        this.revenue = revenue;
        // update Portfolio composition
        if (!Portfolio.portfolio.contains(c_name)) {
            Portfolio.portfolio.add(c_name);
        }
    }



    public int getCid() {
        return cid;
    }

    public void setCid() {
        this.cid = CompanyID.get_id();
    }

    public void setCid(int ID) {
        this.cid = ID;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
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

    public String getRunway_start_date() {
        return runway_start_date;
    }

    public void setRunway_start_date(String runway_start_date) {
        this.runway_start_date = runway_start_date;
    }

    public String getRunway_end_date() {
        return runway_end_date;
    }

    public void setRunway_end_date(String runway_end_date) {
        this.runway_end_date = runway_end_date;
    }

    public int getRunway_month() {
        return runway_month;
    }

    public void setRunway_month(int runway_month) {
        this.runway_month = runway_month;
    }

    public double getRaised_to_date() {
        return raised_to_date;
    }

    public void setRaised_to_date(double raised_to_date) {
        this.raised_to_date = raised_to_date;
    }

    public int getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(int employee_no) {
        this.employee_no = employee_no;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    // may be called manually, or automatically after certain event
    public void delete(String company_name) {
        Portfolio.portfolio.remove(company_name);
        // TODO What need to be updated when a company is removed from the portfolio?
    }
}
