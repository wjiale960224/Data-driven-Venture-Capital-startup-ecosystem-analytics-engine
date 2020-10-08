package com.xxxx.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class DealForm {
    String Company_Name;
    String Deal_Date;
    Double Deal_Size;
    String Deal_Status;
    String Series;
    Double MSEQ_Invest_amount;
    Double Post_Valuation;
    String Invest_Vehicle;
    String Co_Investor;
    Double Fund_Percent;
    Double Own_Percent;

    public DealForm(String company_Name, String deal_Date, Double deal_Size, String deal_Status, String series, Double MSEQ_Invest_amount, Double post_Valuation, String invest_Vehicle, String co_Investor, Double fund_Percent, Double own_Percent) {
        Company_Name = company_Name;
        Deal_Date = deal_Date;
        Deal_Size = deal_Size;
        Deal_Status = deal_Status;
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
        switch (this.Deal_Status.toLowerCase()){
            case "completed":
                dl.setDeal_status(DealStatus.Completed);
                break;
            case "in_progress":
                dl.setDeal_status(DealStatus.In_Progress);
                break;
            case "fail":
                dl.setDeal_status(DealStatus.Failed);
                break;
        }

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
            case "series_d":
                dl.setSeries(com.xxxx.entity.Series.Series_D);
                break;
        }

        Integer deal_id;
        Integer cid;
        String c_name; // to get company_id
        String co_investor;

//        dl.setDeal_date(this.Deal_Date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(this.Deal_Date);
        dl.setDeal_date(date);
        dl.setDeal_size(this.Deal_Size);
        dl.setFund_percentage(this.Fund_Percent);
        dl.setMSEQ_invest_amount(this.MSEQ_Invest_amount);
        dl.setOwn_percentage(this.Own_Percent);
        dl.setPost_value(this.Post_Valuation);
        dl.setCo_investor(this.Co_Investor);
        if (this.Invest_Vehicle == null){
            dl.setVehicle(null);
        }else {
            if (this.Invest_Vehicle.toLowerCase().contains("equities"))
                dl.setVehicle(Vehicle.Equities);
            if (this.Invest_Vehicle.toLowerCase().contains("notes"))
                dl.setVehicle(Vehicle.Notes);
        }
        return dl;
    }
}
