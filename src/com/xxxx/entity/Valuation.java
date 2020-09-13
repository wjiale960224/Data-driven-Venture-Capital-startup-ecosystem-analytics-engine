package com.xxxx.entity;

import java.util.List;

/**
 * @author Zihang
 * @date 2020/9/14
 */

public class Valuation {
    Company company;
    List<Double> pre_values;
    List<Double> post_values;
    List<String> val_change_reason;
    List<Double> MSEQ_invest_current_val;

    public Valuation(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public List<Double> getPre_values() {
        return pre_values;
    }

    public void addPre_values(double pre_values) {
        this.pre_values.add(pre_values);
    }

    public List<Double> getPost_values() {
        return post_values;
    }

    public void addPost_values(double post_values) {
        this.post_values.add(post_values);
    }

    public List<String> getVal_change_reason() {
        return val_change_reason;
    }

    public void addVal_change_reason(String val_change_reason) {
        this.val_change_reason.add(val_change_reason);
    }

    public List<Double> getMSEQ_invest_current_val() {
        return MSEQ_invest_current_val;
    }

    public void addMSEQ_invest_current_val(double MSEQ_invest_current_val) {
        this.MSEQ_invest_current_val.add(MSEQ_invest_current_val);
    }
}
