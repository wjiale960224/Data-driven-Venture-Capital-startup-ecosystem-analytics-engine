package com.xxxx.service;

import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Valuation;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyService {


    public List<String> getCompanyNames(){
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<String> Company_name = userdao.listCompanyByName();
        return Company_name;
    }


    public String getCompanyInfo(List<String> company_names){
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        Map<Company, Valuation> companyValuationMap = new HashMap<>();
        List<Company> companyList = new ArrayList<>();
        String output = "";
        for(String c: company_names){
            Company company = userdao.queryCompanyByName(c);
            Valuation valuation = userdao.queryValuationByCID(company.getCid());
            companyList.add(company);
            companyValuationMap.put(company, new Valuation());
        }
        for(Company c : companyValuationMap.keySet()){
            Valuation v = companyValuationMap.get(c);
            output = output +  "{\"No.\":\"" + c.getCid() + "\",\"Company_Name\":\"" + c.getCompany_name()
                    + "\",\"Theme\":\"" + c.getTheme() + "\",\"Year_Founded\":\"" + c.getYear_founded()
                    + "\",\"Runway_End_Date\":\"" + c.getRunway_end_date() + "\",\"Runway_Month\":\"" + c.getRunway_month()
                    + "\",\"Raise_to_Date\":\"" + c.getRaised_to_date() + "\",\"Employee_No\":\"" + c.getEmployee_no()
                    + "\",\"Revenue\":\"" + c.getRevenue() + "\",\"Present_Valuation\":\"" + v.getPresent_value()
                    + "\",\"Valuation_Change_reason\":\"" + v.getVal_change_reason() + "\",\"MSEQ_Investment_Cur_Val\":\"" + v.getMseq_investment_cur_val()
                    + "\",\"Own_Percent\":\"" + v.getOwn_percent() + "\"},";
        }
        return "[" + output.substring(0,output.length()-1) + "]";
    }
}
