package com.xxxx.entity;

import com.xxxx.dao.Userdao;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * @author Zihang
 * @date 2020/9/14
 */

public class Valuation {
    // Field name must match the attribute name in database, otherwise DAO cannot create instance correctly.
    Integer val_id;
    Integer cid;
    Date update_date;
    Double present_value;
    String val_change_reason;
    Double mseq_investment_cur_val;
    Double own_percent;

    public Valuation() {
    }

    public Valuation(Integer cid, Date update_date, Double present_value, String val_change_reason, Double mseq_investment_cur_val, Double own_percent) {
        this.val_id = ValuationID.get_id();
        this.cid = cid;
        this.update_date = update_date;
        this.present_value = present_value;
        this.val_change_reason = val_change_reason;
        this.mseq_investment_cur_val = mseq_investment_cur_val;
        this.own_percent = own_percent;
    }

    public Integer getVal_id() {
        return val_id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Double getPresent_value() {
        return present_value;
    }

    public void setPresent_value(Double present_value) {
        this.present_value = present_value;
    }

    public String getVal_change_reason() {
        return val_change_reason;
    }

    public void setVal_change_reason(String val_change_reason) {
        this.val_change_reason = val_change_reason;
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
