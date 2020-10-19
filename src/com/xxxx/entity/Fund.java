package com.xxxx.entity;

// TODO implement this table in database
public class Fund {
    String fund_name; // primary key
    Double fund_size;
    Double drawn_capital;
    Double management_fee;

    public Fund(String fund_name, Double fund_size) {
        this.fund_name = fund_name;
        this.fund_size = fund_size;
    }

    public String getFund_name() {
        return fund_name;
    }

    public void setFund_name(String fund_name) {
        this.fund_name = fund_name;
    }

    public Double getFund_size() {
        return fund_size;
    }

    public void setFund_size(Double fund_size) {
        this.fund_size = fund_size;
    }

    public Double getDrawn_capital() {
        return drawn_capital;
    }

    public void setDrawn_capital(Double drawn_capital) {
        this.drawn_capital = drawn_capital;
    }

    public Double getManagement_fee() {
        return management_fee;
    }

    public void setManagement_fee(Double management_fee) {
        this.management_fee = management_fee;
    }
}
