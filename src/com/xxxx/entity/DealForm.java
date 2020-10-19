package com.xxxx.entity;

import java.text.ParseException;
import java.time.LocalDate;

public class DealForm {
    // Field name must match the form column name on webpage. checked
    String Company_Name;
    String Deal_Date;
    Double Deal_Size;
    String Series;
    Double MSEQ_Invest_amount;
    Double Post_Valuation;
    String Invest_Vehicle;
    String Co_Investor;
    Double Fund_Percent;
    Double Own_Percent;
    LocalDate update_date;

    public DealForm(String company_Name) {
        Company_Name = company_Name;
    }

    public DealForm(String company_Name, String deal_Date, Double deal_Size, String series, Double MSEQ_Invest_amount, Double post_Valuation, String invest_Vehicle, String co_Investor, Double fund_Percent, Double own_Percent, LocalDate update_date) {
        Company_Name = company_Name;
        Deal_Date = deal_Date;
        Deal_Size = deal_Size;
        Series = series;
        this.MSEQ_Invest_amount = MSEQ_Invest_amount;
        Post_Valuation = post_Valuation;
        Invest_Vehicle = invest_Vehicle;
        Co_Investor = co_Investor;
        Fund_Percent = fund_Percent;
        Own_Percent = own_Percent;
        this.update_date = update_date;

    }

    public Deal toDeal() {
        Deal dl = new Deal();

        dl.setC_name(this.Company_Name==null ? null : this.Company_Name);
        //dl.setDeal_date(LocalDate.parse(this.Deal_Date)==null ? null : LocalDate.parse(this.Deal_Date));
        dl.setDeal_date(this.Deal_Date==null ? null : this.Deal_Date);
        dl.setDeal_size(this.Deal_Size==null ? null : this.Deal_Size);
        if (this.Series == null) {
            dl.setSeries(null);
        } else if (this.Series.contains("P")) {
            dl.setSeries(com.xxxx.entity.Series.Pre_seed);
        } else if (this.Series.contains("A")) {
            dl.setSeries(com.xxxx.entity.Series.Series_A);
        } else if (this.Series.contains("B")) {
            dl.setSeries(com.xxxx.entity.Series.Series_B);
        } else if (this.Series.contains("C")) {
            dl.setSeries(com.xxxx.entity.Series.Series_C);
        } else {
            dl.setSeries(com.xxxx.entity.Series.Seed);
        }
        dl.setMSEQ_invest_amount(this.MSEQ_Invest_amount==null ? null : this.MSEQ_Invest_amount);
        dl.setPost_value(this.Post_Valuation==null ? null : this.Post_Valuation);
        if (this.Invest_Vehicle == null){
            dl.setVehicle(null);
        } else {
            if (this.Invest_Vehicle.toLowerCase().contains("equit"))
                dl.setVehicle(Vehicle.Equities);
            if (this.Invest_Vehicle.toLowerCase().contains("note"))
                dl.setVehicle(Vehicle.Notes);
        }
        dl.setCo_investor(this.Co_Investor==null ? null : this.Co_Investor);
        dl.setFund_percentage(this.Fund_Percent==null ? null : this.Fund_Percent);
        dl.setOwn_percentage(this.Own_Percent==null ? null : this.Own_Percent);
        dl.setUpdate_date(LocalDate.now());

        return dl;
    }
}
