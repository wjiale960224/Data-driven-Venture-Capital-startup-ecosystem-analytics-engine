package com.xxxx.entity;


public class TotCapitalMngFee {
    Double total_capital;
    Double management_fee;
    Double total_capital_raised;

    public TotCapitalMngFee(Double total_capital, Double management_fee, Double total_capital_raised) {
        this.total_capital = total_capital;
        this.management_fee = management_fee;
        this.total_capital_raised = total_capital_raised;
    }

    public Double getTotal_capital() {
        return total_capital;
    }

    public void setTotal_capital(Double total_capital) {
        this.total_capital = total_capital;
    }

    public Double getManagement_fee() {
        return management_fee;
    }

    public void setManagement_fee(Double management_fee) {
        this.management_fee = management_fee;
    }

    public Double getTotal_capital_raised() {
        return total_capital_raised;
    }

    public void setTotal_capital_raised(Double total_capital_raised) {
        this.total_capital_raised = total_capital_raised;
    }


}
