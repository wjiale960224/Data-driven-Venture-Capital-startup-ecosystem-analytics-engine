package com.xxxx.entity;

import com.xxxx.dao.Userdao;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

/**
 * @author Zihang
 * @date 2020/9/14
 */

public class Deal {
    Integer deal_id;
    String company_name; // to get company_id
    Date deal_date;
    double deal_size;
    DealStatus deal_status;
    Series series;
    double mseq_invest_amount;
    Vehicle vehicle;
    List<String> co_investor;
    double fund_percent; // auto-generated
    double own_percent; // manually input

    public Deal() {
    }

    public Deal(Date deal_date, double deal_size, Series series, double MSEQ_invest_amount) {
        this.deal_id = DealID.get_id();
        this.deal_date = deal_date;
        this.deal_size = deal_size;
        this.deal_status = DealStatus.Completed; // default status is Completed
        this.series = series;
        this.mseq_invest_amount = MSEQ_invest_amount;
    }


    public int getDid() {
        return deal_id;
    }

    public Company getCompany() {
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        return userdao.queryCompanyByName(company_name);
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
        return mseq_invest_amount;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<String> getCo_investor() {
        return co_investor;
    }

    public double getFund_percentage() {
        return fund_percent;
    }

    public double getOwn_percentage() {
        return own_percent;
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
        this.mseq_invest_amount = MSEQ_invest_amount;
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

    public void resetCo_investor(String co_investor) {
        this.co_investor.clear();
    }

    // should only be called by service level
    protected void setFund_percentage(double fund_percentage) {
        this.fund_percent = fund_percentage;
    }

    public void setOwn_percentage(double own_percentage) {
        this.own_percent = own_percentage;
    }
}
