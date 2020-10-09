package com.xxxx.entity;

import com.xxxx.dao.QueryDao;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import java.time.LocalDate;

public class CompanyForm {
    // Field name must match the form column name on webpage.

    // Company fields
    String Company_Name;
    String Theme;
    int Year_Founded;
    String Runway_Start_Date;
    String Runway_End_Date;
    int Runway_Month;
    double Raise_to_Date;
    int Employee_No;
    double Revenue;

    // Valuation fields
    double Post_Valuation;
    String Valuation_Change_Reason;
    double MSEQ_Investment_Cur_Val;
    double Own_Percent;

    public CompanyForm(String company_Name, String theme, Integer year_Founded, String runway_Start_Date, String runway_End_Date, Integer runway_Month, Double raise_to_Date, Integer employee_No, Double revenue, Double post_Valuation, String valuation_Change_Reason, Double MSEQ_Investment_Cur_Val, Double own_Percent) {
        Company_Name = company_Name;
        Theme = theme;
        Year_Founded = year_Founded;
        Runway_Start_Date = runway_Start_Date;
        Runway_End_Date = runway_End_Date;
        Runway_Month = runway_Month;
        Raise_to_Date = raise_to_Date;
        Employee_No = employee_No;
        Revenue = revenue;
        Post_Valuation = post_Valuation;
        Valuation_Change_Reason = valuation_Change_Reason;
        this.MSEQ_Investment_Cur_Val = MSEQ_Investment_Cur_Val;
        Own_Percent = own_Percent;
    }

    public CompanyForm() {}

    public Company toCompany() {
        Company company = new Company();

        company.setC_name(this.Company_Name);

        if (this.Theme.toLowerCase().contains("exponential"))
            company.setTheme(com.xxxx.entity.Theme.Exponential_Machines);
        if (this.Theme.toLowerCase().contains("feeding"))
            company.setTheme(com.xxxx.entity.Theme.Feeding_10B_People);
        if (this.Theme.toLowerCase().contains("humanity"))
            company.setTheme(com.xxxx.entity.Theme.Humanity_Scale_Healthcare);
        if (this.Theme.toLowerCase().contains("society"))
            company.setTheme(com.xxxx.entity.Theme.New_Society);
        if (this.Theme.toLowerCase().contains("space"))
            company.setTheme(com.xxxx.entity.Theme.Space_Transport);

        company.setYear_founded(this.Year_Founded);
        company.setRunway_start_date(this.Runway_Start_Date);
        company.setRunway_end_date(this.Runway_End_Date);
        company.setRunway_month(this.Runway_Month);
        company.setRaised_to_date(this.Raise_to_Date);
        company.setEmployee_no(this.Employee_No);
        company.setRevenue(this.Revenue);
        return company;
    }

    public Valuation toValuation() {
        Valuation valuation = new Valuation();

        valuation.setC_name(this.Company_Name);

        valuation.setUpdate_date(LocalDate.now());

        valuation.setPost_value(this.Post_Valuation);

        valuation.setValuation_change_reason(this.Valuation_Change_Reason);

        valuation.setMseq_investment_cur_val(this.MSEQ_Investment_Cur_Val);

        valuation.setOwn_percent(this.Own_Percent);

        return valuation;
    }
}
