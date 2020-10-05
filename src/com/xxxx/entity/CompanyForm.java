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
    String Year_Founded;
    String Runway_End_Date;
    String Runway_Month;
    String Raise_to_Date;
    String Employee_No;
    String Revenue;

    // Valuation fields
    String Present_Valuation;
    String Valuation_Change_Reason;
    String MSEQ_Investment_Cur_Val;
    String Own_Percent;


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
