package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.InsertDao;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.UpdateDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.CompanyForm;
import com.xxxx.entity.Portfolio;
import com.xxxx.entity.Valuation;
import com.xxxx.util.GetSqlSession;
import com.xxxx.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyService {

    public List<String> getCompanyNames() {
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<String> Company_name = userdao.listCompanyByName();
        return Company_name;
    }

    public String getCompanyInfo(List<String> company_names) {
        SqlSession session = GetSqlSession.createSqlSession();
        QueryDao queryDao = session.getMapper(QueryDao.class);
        Map<Company, Valuation> companyValuationMap = new HashMap<>();
        List<Company> companyList = new ArrayList<>();
        String output = "";
        for (String c : company_names) {
            Company company = queryDao.queryCompanyByName(c);
            Valuation valuation = queryDao.queryLatestValuationByCID(company.getCid());
            companyList.add(company);
            companyValuationMap.put(company, valuation);
        }
        for (Company c : companyValuationMap.keySet()) {

            Valuation v = companyValuationMap.get(c);
            CompanyForm cf = new CompanyForm(c.getCompany_name(),c.getTheme().toString(),c.getYear_founded(),c.getRunway_start_date(),
                    c.getRunway_end_date(),c.getRunway_month(),c.getRaised_to_date(),c.getEmployee_no(),c.getRevenue(),v.getPost_value(),
                    v.getValuation_change_reason(),v.getMseq_investment_cur_val(),v.getOwn_percent());
            Gson g = new Gson();
            output += g.toJson(cf) + ",";

//            output = output + "{\"No.\":\"" + c.getCid() + "\",\"Company_Name\":\"" + c.getCompany_name()
//                    + "\",\"Theme\":\"" + c.getTheme() + "\",\"Year_Founded\":\"" + c.getYear_founded()
//                    + "\",\"Runway_End_Date\":\"" + c.getRunway_end_date() + "\",\"Runway_Month\":\"" + c.getRunway_month()
//                    + "\",\"Raise_to_Date\":\"" + c.getRaised_to_date() + "\",\"Employee_No\":\"" + c.getEmployee_no()
//                    + "\",\"Revenue\":\"" + c.getRevenue() + "\",\"Present_Valuation\":\"" + v.getPost_value()
//                    + "\",\"Valuation_Change_reason\":\"" + v.getValuation_change_reason() + "\",\"MSEQ_Investment_Cur_Val\":\"" + v.getMseq_investment_cur_val()
//                    + "\",\"Own_Percent\":\"" + v.getOwn_percent() + "\"},";
        }
        System.out.println("check getCompanyInfo");
        return "[" + output.substring(0, output.length() - 1) + "]";
    }

    public void updateCompanyInfo(String c) {
        Gson gson = new Gson();
        SqlSession session = GetSqlSession.createSqlSession();
        InsertDao insertdao = session.getMapper(InsertDao.class);
        UpdateDao updateDao = session.getMapper(UpdateDao.class);
        QueryDao queryDao = session.getMapper((QueryDao.class));



        List<String> companys = queryDao.listCompanyByName(); // get companies in current table
        String[] updateInfo = StringUtil.SplitStrings(c);
        for (String str : updateInfo) {
//            System.out.println(str);
            CompanyForm companyform = gson.fromJson(str, CompanyForm.class);
            Company company = companyform.toCompany();
//            System.out.println(company.getCompany_name());
//            System.out.println(company.getTheme());
            if (!companys.contains(company.getCompany_name())) {
                company.setCid(); // generate a new cid for new company only
//                System.out.println(company.getCid());
                insertdao.addCompany(company); // no error, but no new entry in database
                List<String> ls = Portfolio.getPortfolio();
                if (!Portfolio.getPortfolio().contains(company.getCompany_name())) {
                    Portfolio.getPortfolio().add(company.getCompany_name());
                }
            } else {

                updateDao.updateCompany(company);
            }
            session.commit();

//            Valuation valuation = companyform.toValuation();
//            insertdao.addValuation(valuation);
        }
    }
}
