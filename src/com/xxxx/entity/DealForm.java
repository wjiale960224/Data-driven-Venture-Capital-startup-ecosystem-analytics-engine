package com.xxxx.entity;

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

    public Deal toDealFrom(){
        Deal dl = new Deal();
/*        if (this.deal_status.toLowerCase().contains("completed"))
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
            dl.setSeries(Series.Series_D);*/

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
