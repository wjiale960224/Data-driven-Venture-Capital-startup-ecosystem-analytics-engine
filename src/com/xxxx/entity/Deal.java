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
    // Field name must match the attribute name in database, otherwise DAO cannot create instance correctly.
    Integer deal_id;
    String c_name; // to get company_id
    Date deal_date;
    Double deal_size;
    DealStatus deal_status;
    Series series;
    Double mseq_invest_amt;
    Float post_value;
    Vehicle invest_vehicle;
    List<String> co_investor;
    Double fund_percent; // auto-generated
    Double own_percent; // manually input

    public Deal() {
    }

    public Deal(String c_name, Date deal_date, Double deal_size, Series series, Double MSEQ_invest_amount) {
        this.deal_id = DealID.get_id();
        this.deal_date = deal_date;
        this.deal_size = deal_size;
        this.deal_status = DealStatus.Completed; // default status is Completed
        this.series = series;
        this.mseq_invest_amt = MSEQ_invest_amount;
        this.c_name = c_name;
    }


    public Integer getDid() {
        return deal_id;
    }

    public Company getCompany() {
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        return userdao.queryCompanyByName(c_name);
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Date getDeal_date() {
        return deal_date;
    }

    public Double getDeal_size() {
        return deal_size;
    }

    public DealStatus getDeal_status() {
        return deal_status;
    }

    public Series getSeries() {
        return series;
    }

    public Double getMSEQ_invest_amount() {
        return mseq_invest_amt;
    }

    public Vehicle getVehicle() {
        return invest_vehicle;
    }

    public List<String> getCo_investor() {
        return co_investor;
    }

    public Double getFund_percentage() {
        return fund_percent;
    }

    public Double getOwn_percentage() {
        return own_percent;
    }

    public void setDeal_date(Date deal_date) {
        this.deal_date = deal_date;
    }

    public void setDeal_size(Double deal_size) {
        this.deal_size = deal_size;
    }

    public void setDeal_status(DealStatus deal_status) {
        this.deal_status = deal_status;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public void setMSEQ_invest_amount(Double MSEQ_invest_amount) {
        this.mseq_invest_amt = MSEQ_invest_amount;
    }

    public void setVehicle(Vehicle vehicle) {
        this.invest_vehicle = vehicle;
    }

    public void setCo_investor(List<String> co_investor){this.co_investor = co_investor;}

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
    protected void setFund_percentage(Double fund_percentage) {
        this.fund_percent = fund_percentage;
    }

    public void setOwn_percentage(Double own_percentage) {
        this.own_percent = own_percentage;
    }
}
