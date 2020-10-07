package com.xxxx.entity;

import java.util.Date;
import java.util.List;

public class DealForm {
    Integer deal_id;
    String c_name; // to get company_id
    String deal_date;
    Double deal_size;
    String deal_status;
    String series;
    Double mseq_invest_amt;
    Double post_value;
    String invest_vehicle;
    String co_investor;
    Double fund_percent; // auto-generated
    Double own_percent; // manually input

    public DealForm(String c_name, String deal_date, Double deal_size, String deal_status, String series, Double mseq_invest_amt, Double post_value, String invest_vehicle, String co_investor, Double fund_percent, Double own_percent) {
        this.c_name = c_name;
        this.deal_date = deal_date;
        this.deal_size = deal_size;
        this.deal_status = deal_status;
        this.series = series;
        this.mseq_invest_amt = mseq_invest_amt;
        this.post_value = post_value;
        this.invest_vehicle = invest_vehicle;
        this.co_investor = co_investor;
        this.fund_percent = fund_percent;
        this.own_percent = own_percent;
    }

    public Deal toDealFrom(){
        Deal dl = new Deal();
        if (this.deal_status.toLowerCase().contains("completed"))
            dl.setDeal_status(DealStatus.Completed);
        if (this.deal_status.toLowerCase().contains("in_progress"))
            dl.setDeal_status(DealStatus.In_Progress);
        if (this.deal_status.toLowerCase().contains("fail"))
            dl.setDeal_status(DealStatus.Failed);
        if (this.series.toLowerCase().contains("a"))
            dl.setSeries(Series.Series_A);
        if (this.series.toLowerCase().contains("b"))
            dl.setSeries(Series.Series_B);
        if (this.series.toLowerCase().contains("c"))
            dl.setSeries(Series.Series_C);
        if (this.series.toLowerCase().contains("d"))
            dl.setSeries(Series.Series_D);

/*        dl.setDeal_date(this.deal_date);
        dl.setDeal_size(this.deal_size);
        dl.setFund_percentage(this.fund_percent);
        dl.setMSEQ_invest_amount(this.mseq_invest_amt);
        dl.setOwn_percentage(this.own_percent);
        dl.setVehicle(this.invest_vehicle);
        dl.setCo_investor(this.co_investor);*/
        return dl;
    }
}
