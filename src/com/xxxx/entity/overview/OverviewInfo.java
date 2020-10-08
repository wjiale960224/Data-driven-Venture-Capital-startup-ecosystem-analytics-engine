package com.xxxx.entity.overview;


public class OverviewInfo {
    Double Total_Fund_Size;
    Double Drawn_Capital;
    Double Undrawn_Capital;
    Integer Total_Companies;
    Integer Total_Deals;
    Double Per_Deal;
    Integer Rounds;
    Double IRR;

    public OverviewInfo(Double total_Fund_Size, Double drawn_Capital, Double undrawn_Capital, Integer total_Companies, Integer total_Deals, Double per_Deal, Integer rounds, Double IRR) {
        Total_Fund_Size = total_Fund_Size;
        Drawn_Capital = drawn_Capital;
        Undrawn_Capital = undrawn_Capital;
        Total_Companies = total_Companies;
        Total_Deals = total_Deals;
        Per_Deal = per_Deal;
        Rounds = rounds;
        this.IRR = IRR;
    }
}
