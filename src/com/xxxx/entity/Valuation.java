package com.xxxx.entity;

import java.time.LocalDate;

/**
 * @author Zihang
 * @date 2020/9/14
 */

public class Valuation {
    // Field name must match the attribute name in database, otherwise DAO cannot create instance correctly.
    Integer val_id;
    Integer cid;
    String c_name;
    LocalDate update_date;
    Double post_value;
    String valuation_change_reason;
    Double mseq_investment_cur_val;
    Double own_percent;

    public Valuation() {
    }

    public Valuation(Integer cid, String c_name, LocalDate update_date, Double post_value, String val_change_reason, Double mseq_investment_cur_val, Double own_percent) {
        this.val_id = ValuationID.get_id();
        this.c_name = c_name;
        this.cid = cid;
        this.update_date = update_date;
        this.post_value = post_value;
        this.valuation_change_reason = val_change_reason;
        this.mseq_investment_cur_val = mseq_investment_cur_val;
        this.own_percent = own_percent;
    }

    public Integer getVal_id() {
        return val_id;
    }

    public void setVal_id() {
        this.val_id = CompanyID.get_id();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setCid() {
        this.cid = CompanyID.get_id();
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public LocalDate getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDate update_date) {
        this.update_date = update_date;
    }

    public Double getPost_value() {
        return post_value;
    }

    public void setPost_value(Double post_value) {
        this.post_value = post_value;
    }

    public String getValuation_change_reason() {
        return valuation_change_reason;
    }

    public void setValuation_change_reason(String valuation_change_reason) {
        this.valuation_change_reason = valuation_change_reason;
    }

    public Double getMseq_investment_cur_val() {
        return mseq_investment_cur_val;
    }

    public void setMseq_investment_cur_val(Double mseq_investment_cur_val) {
        this.mseq_investment_cur_val = mseq_investment_cur_val;
    }

    public Double getOwn_percent() {
        return own_percent;
    }

    public void setOwn_percent(Double own_percent) {
        this.own_percent = own_percent;
    }
}
