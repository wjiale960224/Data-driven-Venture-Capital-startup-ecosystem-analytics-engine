package com.xxxx.entity;

import com.xxxx.dao.Userdao;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.*;


public class Deal {
    // Field name must match the attribute name in database, otherwise DAO cannot create instance correctly.
    Integer deal_id;
    Integer cid;
    String c_name; // to get company_id
    Date deal_date;
    Double deal_size;
    DealStatus deal_status;
    Series series;
    Double mseq_invest_amt;
    Double post_value;
    Vehicle invest_vehicle;
    String co_investor;
    Double fund_percent; // auto-generated
    Double own_percent; // manually input

    public Deal() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getDeal_date_toString() {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        return ft.format(this.getDeal_date());
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

    public String getSeries_toString(){
        if (this.getSeries() == null){
            return null;
        }else {
            return this.getSeries().toString();
        }
    }

    public Double getMSEQ_invest_amount() {
        return mseq_invest_amt;
    }

    public Vehicle getVehicle() {
        return invest_vehicle;
    }

    public String getVehicle_toString() {
        if (this.getVehicle() == null){
            return null;
        }else {
            return invest_vehicle.toString();
        }
    }


    public Double getFund_percentage() {
        return fund_percent;
    }

    public Double getOwn_percentage() {
        return own_percent;
    }

    public Double getOwn_percentage_toString() {
        if (this.getOwn_percentage() == null){
            return null;
        }else {
            return this.getOwn_percentage();
        }
    }

    public void setCo_investor(String co_investor) {
        this.co_investor = co_investor;
    }

    public String getCo_investor() {
        return co_investor;
    }

    public void setDeal_date(Date deal_date) {
        this.deal_date = deal_date;
    }

    public void setDeal_size(Double deal_size) {
        this.deal_size = deal_size;
    }

    public Double getPost_value() {
        return post_value;
    }

    public void setPost_value(Double post_value) {
        this.post_value = post_value;
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

    /*public void addCo_investor(String co_investor) {
        this.co_investor.add(co_investor);
    }

    public void removeCo_investor(String co_investor) {
        this.co_investor.remove(co_investor);
    }

    public void resetCo_investor(String co_investor) {
        this.co_investor.clear();
    }*/

    // should only be called by service level
    protected void setFund_percentage(Double fund_percentage) {
        this.fund_percent = fund_percentage;
    }

    public void setOwn_percentage(Double own_percentage) {
        this.own_percent = own_percentage;
    }
}
