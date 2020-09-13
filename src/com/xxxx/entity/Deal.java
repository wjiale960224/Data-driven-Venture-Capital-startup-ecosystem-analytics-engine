package com.xxxx.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Fei
 * @date 2020/9/11 11:12
 * @author Zihang
 * @date 2020/9/14
 */

public class Deal {
    final UUID did;
    final Company company; // to get company_id
    Date deal_date;
    double deal_size;
    DealStatus deal_status;
    Series series;
    double MSEQ_invest_amount;
    Vehicle vehicle;
    List<String> co_investor;
    double fund_percentage; // auto-generated, no setter
    double own_percentage; // auto-generated, no setter

    public Deal(Company company, Date deal_date, double deal_size, Series series, double MSEQ_invest_amount) {
        this.did = UUID.randomUUID();
        this.company = company;
        this.deal_date = deal_date;
        this.deal_size = deal_size;
        this.deal_status = DealStatus.Completed; // default status is Completed
        this.series = series;
        this.MSEQ_invest_amount = MSEQ_invest_amount;
    }

    public UUID getDid() {
        return did;
    }

    public Company getCompany() {
        return company;
    }

    public Date getDeal_date() {
        return deal_date;
    }

    public double getDeal_size() {
        return deal_size;
    }

    public DealStatus getDeal_status() {
        return deal_status;
    }

    public Series getSeries() {
        return series;
    }

    public double getMSEQ_invest_amount() {
        return MSEQ_invest_amount;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<String> getCo_investor() {
        return co_investor;
    }

    public double getFund_percentage() {
        return fund_percentage;
    }

    public double getOwn_percentage() {
        return own_percentage;
    }

    public void setDeal_date(Date deal_date) {
        this.deal_date = deal_date;
    }

    public void setDeal_size(double deal_size) {
        this.deal_size = deal_size;
    }

    public void setDeal_status(DealStatus deal_status) {
        this.deal_status = deal_status;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public void setMSEQ_invest_amount(double MSEQ_invest_amount) {
        this.MSEQ_invest_amount = MSEQ_invest_amount;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void addCo_investor(String co_investor) {
        this.co_investor.add(co_investor);
    }

    public void removeCo_investor(String co_investor) {
        this.co_investor.remove(co_investor);
    }
}
