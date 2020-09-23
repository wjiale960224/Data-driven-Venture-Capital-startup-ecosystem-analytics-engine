package com.xxxx.entity;

import java.util.List;

/**
 * @author Zihang
 * @date 2020/9/14
 */

public class Return {
    // Field name must match the attribute name in database, otherwise DAO cannot create instance correctly.
    Company company;
    List<Double> IRR;
    List<Double> TVPI;
    Double fund_return_100;
    Double fund_return_250;

    public Return() {
    }

    public Return(Company company) {
        this.company = company;
    }


    public Company getCompany() {
        return company;
    }

    public List<Double> getIRR() {
        return IRR;
    }

    public void addIRR(double IRR) {
        this.IRR.add(IRR);
    }

    public List<Double> getTVPI() {
        return TVPI;
    }

    public void addTVPI(double TVPI) {
        this.TVPI.add(TVPI);
    }

    public double getFund_return_100() {
        return fund_return_100;
    }

    public void setFund_return_100(double fund_return_100) {
        this.fund_return_100 = fund_return_100;
    }

    public double getFund_return_250() {
        return fund_return_250;
    }

    public void setFund_return_250(double fund_return_250) {
        this.fund_return_250 = fund_return_250;
    }
}
