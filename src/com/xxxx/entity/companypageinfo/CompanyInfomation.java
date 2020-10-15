package com.xxxx.entity.companypageinfo;

public class CompanyInfomation {
    String Company_Name;
    String Company_Theme;
    Double Total_MSEQ_Investment;
    Integer Total_deals;
    Double Current_Valuation;
    Integer Runaway_Month;
    String Series;
    Double Own;
    Integer Employee_No;
    Double Revenue;
    Double MSEQ_Investment;
    Double Others;

    public CompanyInfomation(String company_Name, String company_Theme, Double total_MSEQ_Investment, Integer total_deals, Double current_Valuation, Integer runaway_Month, String series, Double own, Integer employee_No, Double revenue, Double MSEQ_Investment, Double others) {
        Company_Name = company_Name;
        Company_Theme = company_Theme;
        Total_MSEQ_Investment = total_MSEQ_Investment;
        Total_deals = total_deals;
        Current_Valuation = current_Valuation;
        Runaway_Month = runaway_Month;
        Series = series;
        Own = own;
        Employee_No = employee_No;
        Revenue = revenue;
        this.MSEQ_Investment = MSEQ_Investment;
        Others = others;
    }

    public String getCompany_Name() {
        return Company_Name;
    }

    public void setCompany_Name(String company_Name) {
        Company_Name = company_Name;
    }

    public Double getMSEQ_Investment() {
        return MSEQ_Investment;
    }

    public void setMSEQ_Investment(Double MSEQ_Investment) {
        this.MSEQ_Investment = MSEQ_Investment;
    }

    public Double getOthers() {
        return Others;
    }

    public void setOthers(Double others) {
        Others = others;
    }
}
