package com.xxxx.entity.overview;


public class OverviewInfo {
    Double Total_Fund_Size;
    Double Drawn_Capital;
    Double Undrawn_Capital;
    Double Management_Fee;
    Integer Total_Companies;
    Integer Total_Deals;
    Double Per_Deal;
    Double Remaining_to_invest;
    Double Total_capital_raised;
    Double Mseq_investment_amount;
    int No_series_a;
    int No_series_b;
    int No_series_c;
    int No_series_seed;
    int No_series_preseed;

    public OverviewInfo(Double total_Fund_Size, Double drawn_Capital, Double undrawn_Capital, Double management_Fee, Integer total_Companies, Integer total_Deals, Double per_Deal, Double remaining_to_invest, Double total_capital_raised, Double mseq_investment_amount, int no_series_a, int no_series_b, int no_series_c, int no_series_seed, int no_series_preseed) {
        Total_Fund_Size = total_Fund_Size;
        Management_Fee = management_Fee;
        Drawn_Capital = drawn_Capital;
        Undrawn_Capital = undrawn_Capital;
        Total_Companies = total_Companies;
        Total_Deals = total_Deals;
        Per_Deal = per_Deal;
        Remaining_to_invest = remaining_to_invest;
        Total_capital_raised = total_capital_raised;
        Mseq_investment_amount = mseq_investment_amount;
        No_series_a =no_series_a;
        No_series_b = no_series_b;
        No_series_c = no_series_c;
        No_series_seed = no_series_seed;
        No_series_preseed = no_series_preseed;
    }
}
