package com.xxxx.entity.overview;

public class Capital {
    Double total_fund;
    Double management_fee;
    Double total_capital_raised;

    public Capital(Double total_fund, Double management_fee, Double total_capital_raised) {
        this.total_fund = total_fund;
        this.management_fee = management_fee;
        this.total_capital_raised = total_capital_raised;
    }

    public Double getTotal_fund() {
        return total_fund;
    }

    public void setTotal_fund(Double total_fund) {
        this.total_fund = total_fund;
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
