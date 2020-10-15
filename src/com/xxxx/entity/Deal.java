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
    String c_name;
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
    String fund_name; // TODO database need to update

    public Deal() {
    }

    public Integer getCid() {
        return cid;
    }

    public Integer getDeal_id() {
        return deal_id;
    }

    public void setDeal_id() {
        this.deal_id = DealID.get_id();
    }

    public void setDeal_id(Integer deal_id) {this.deal_id = deal_id;}

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
        return deal_size == null? null:deal_size;
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
        return own_percent == null? null:own_percent;
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

    public String getFund_name() {
        return fund_name;
    }

    public void setFund_name(String fund_name) {
        this.fund_name = fund_name;
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

//    @Override
    public boolean equals(Deal B){
        boolean cName = this.c_name.equals(B.c_name);
        boolean dealDate = this.deal_date.equals(B.deal_date);
        boolean deaSize = this.deal_size.equals(B.deal_size);
        boolean dealStatus = this.deal_status.equals(B.deal_status);
        boolean dealSeries = this.CompareString(this.series,B.series);

        boolean mseq = this.mseq_invest_amt.equals(B.mseq_invest_amt) ;
        boolean postV = this.post_value.equals(B.post_value);
        boolean investV;
        if (this.invest_vehicle == null && B.invest_vehicle == null){
            investV = true;
        }else if (this.invest_vehicle.equals(B.invest_vehicle)){
            investV = true;
        }else {
            investV = false;
        }

        boolean coInv = this.CompareString(this.co_investor,B.co_investor);
        boolean fundPct = this.fund_percent.equals(B.fund_percent);
        boolean ownPct = this.CompareString(this.own_percent, B.own_percent);

        return cName & dealDate & deaSize & dealStatus & dealSeries & mseq & postV & investV & coInv & fundPct & ownPct;
    }

    public boolean CompareString(Object a, Object b){
        if (a == null && b == null){
            return true;
        }else if (a == null || b ==null){
            return false;
        }
        else return a.equals(b);
    }
}
