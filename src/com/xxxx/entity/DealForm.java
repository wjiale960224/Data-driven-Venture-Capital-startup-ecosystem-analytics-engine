package com.xxxx.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public DealForm(String company_Name, String deal_Date, Double deal_Size, String series, Double MSEQ_Invest_amount, Double post_Valuation, String invest_Vehicle, String co_Investor, Double fund_Percent, Double own_Percent) {
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
    }

    public Deal toDeal() throws ParseException {
        Deal dl = new Deal();

        // set deal_id and cid in DealService
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(this.Deal_Date);
        dl.setC_name(this.Company_Name);
        dl.setDeal_date(date);
        dl.setDeal_size(this.Deal_Size);
        /*switch (this.Deal_Status.toLowerCase()) {
            case "completed":
                dl.setDeal_status(DealStatus.Completed);
                break;
            case "in_progress":
                dl.setDeal_status(DealStatus.In_Progress);
                break;
            case "fail":
                dl.setDeal_status(DealStatus.Failed);
                break;
        }*/
        switch (this.Series.toLowerCase()){
            case "series_a":
                dl.setSeries(com.xxxx.entity.Series.Series_A);
                break;
            case "series_b":
                dl.setSeries(com.xxxx.entity.Series.Series_B);
                break;
            case "series_c":
                dl.setSeries(com.xxxx.entity.Series.Series_C);
                break;
            case "series_seed":
                dl.setSeries(com.xxxx.entity.Series.Seed);
                break;
            case "series_pre_seed":
                dl.setSeries(com.xxxx.entity.Series.Pre_seed);
        }
        dl.setMSEQ_invest_amount(this.MSEQ_Invest_amount);
        dl.setPost_value(this.Post_Valuation);
        if (this.Invest_Vehicle == null){
            dl.setVehicle(null);
        } else {
            if (this.Invest_Vehicle.toLowerCase().contains("equit"))
                dl.setVehicle(Vehicle.Equities);
            if (this.Invest_Vehicle.toLowerCase().contains("note"))
                dl.setVehicle(Vehicle.Notes);
        }
        dl.setCo_investor(this.Co_Investor);
        dl.setFund_percentage(this.Fund_Percent);
        dl.setOwn_percentage(this.Own_Percent);

        return dl;
    }
}
