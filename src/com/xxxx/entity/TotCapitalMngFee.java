package com.xxxx.entity;


public class TotCapitalMngFee {
    Integer total_capital;
    Integer management_fee;

    public TotCapitalMngFee(Integer total_capital, Integer management_fee) {
        this.total_capital = total_capital;
        this.management_fee = management_fee;
    }

    public Integer getTotal_capital() {
        return total_capital;
    }

    public void setTotal_capital(Integer total_capital) {
        this.total_capital = total_capital;
    }

    public Integer getManagement_fee() {
        return management_fee;
    }

    public void setManagement_fee(Integer management_fee) {
        this.management_fee = management_fee;
    }
}
