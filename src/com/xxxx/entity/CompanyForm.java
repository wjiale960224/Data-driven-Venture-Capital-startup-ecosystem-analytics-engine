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
    Integer Year_Founded;
    String Runway_Start_Date;
    String Runway_End_Date;
    Integer Runway_Month;
    Double Raise_to_Date;
    Integer Employee_No;
    Double Revenue;

    // Valuation fields
    Double Post_Valuation;
    String Valuation_Change_Reason;
    Double MSEQ_Investment_Cur_Val;
    Double Own_Percent;

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
        Company result = new Company();

        result.setCompany_name(this.Company_Name);

        if (this.Theme.toLowerCase().contains("exponential"))
            result.setTheme(com.xxxx.entity.Theme.Exponential_Machines);
        if (this.Theme.toLowerCase().contains("feeding"))
            result.setTheme(com.xxxx.entity.Theme.Feeding_10B_People);
        if (this.Theme.toLowerCase().contains("humanity"))
            result.setTheme(com.xxxx.entity.Theme.Humanity_Scale_Healthcare);
        if (this.Theme.toLowerCase().contains("society"))
            result.setTheme(com.xxxx.entity.Theme.New_Society);
        if (this.Theme.toLowerCase().contains("space"))
            result.setTheme(com.xxxx.entity.Theme.Space_Transport);

        //result.setYear_founded(Integer.parseInt(this.Year_Founded));

        //result.setRunway_end_date(this.Runway_End_Date);

        return result;
    }

//    public Valuation toValuation() {
//        SqlSession session = GetSqlSession.createSqlSession();
//        QueryDao queryDao = session.getMapper((QueryDao.class));
//
//        Valuation valuation = new Valuation();
//
//        valuation.setVal_id();
//
//        valuation.setCid(queryDao.queryCidByCompanyName(this.Company_Name));
//
//        valuation.setC_name(this.Company_Name);
//
//        valuation.setUpdate_date(LocalDate.now());
//
//        valuation.setPost_value(Double.parseDouble( this.Present_Valuation));
//
//        valuation.setValuation_change_reason(this.Valuation_Change_Reason);
//
//        valuation.setMseq_investment_cur_val(Double.parseDouble( this.MSEQ_Investment_Cur_Val));
//
//        valuation.setOwn_percent(Double.parseDouble( this.Own_Percent));
//
//        return valuation;
//    }
}
