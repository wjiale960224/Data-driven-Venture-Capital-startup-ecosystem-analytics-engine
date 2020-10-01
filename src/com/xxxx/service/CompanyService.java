package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.controller.DealFormServlet;
import com.xxxx.dao.InsertDao;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.UpdateDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.CompanyForm;
import com.xxxx.entity.Portfolio;
import com.xxxx.entity.Valuation;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

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
        Userdao userdao = session.getMapper(Userdao.class);
        Map<Company, Valuation> companyValuationMap = new HashMap<>();
        List<Company> companyList = new ArrayList<>();
        String output = "";
        for (String c : company_names) {
            Company company = userdao.queryCompanyByName(c);
            //Valuation valuation = userdao.queryValuationByCID(company.getCid());
            companyList.add(company);
            companyValuationMap.put(company, new Valuation());
        }
        for (Company c : companyValuationMap.keySet()) {
            Valuation v = companyValuationMap.get(c);
            output = output + "{\"No.\":\"" + c.getCid() + "\",\"Company_Name\":\"" + c.getCompany_name()
                    + "\",\"Theme\":\"" + c.getTheme() + "\",\"Year_Founded\":\"" + c.getYear_founded()
                    + "\",\"Runway_End_Date\":\"" + c.getRunway_end_date() + "\",\"Runway_Month\":\"" + c.getRunway_month()
                    + "\",\"Raise_to_Date\":\"" + c.getRaised_to_date() + "\",\"Employee_No\":\"" + c.getEmployee_no()
                    + "\",\"Revenue\":\"" + c.getRevenue() + "\",\"Present_Valuation\":\"" + v.getPost_value()
                    + "\",\"Valuation_Change_reason\":\"" + v.getVal_change_reason() + "\",\"MSEQ_Investment_Cur_Val\":\"" + v.getMseq_investment_cur_val()
                    + "\",\"Own_Percent\":\"" + v.getOwn_percent() + "\"},";
        }

        System.out.println("check getCompanyInfo");
        return "[" + output.substring(0, output.length() - 1) + "]";
    }

    /*public void updateCompanyInfo(String c) {
        Gson gson = new Gson();
        SqlSession session = GetSqlSession.createSqlSession();
        InsertDao insertdao = session.getMapper(InsertDao.class);
        QueryDao queryDao = session.getMapper((QueryDao.class));
        List<String> companys = queryDao.listCompanyByName(); // check companies in current portfolio

        String[] companies = DealFormServlet.SplitStrings(c);
        for (String s : companies) {
            Company company = gson.fromJson(s, Company.class);
            company.setCid();

            if (companys.contains(company.getCompany_name())) {
                // TODO implement 查重更新 company entry
                *//* if (parameter == Year_Founded) {
                *   updatedao;
                * }*//*
            } else {
                insertdao.addCompany(company); // insert new company entry
            }

            if (!Portfolio.getPortfolio().contains(company.getCompany_name())) { // update Porfolio class
                Portfolio.getPortfolio().add(company.getCompany_name());
            }
        }
    }*/

    public void updateCompanyInfo(String c) {
        Gson gson = new Gson();
        SqlSession session = GetSqlSession.createSqlSession();
        InsertDao insertdao = session.getMapper(InsertDao.class);
        UpdateDao updateDao = session.getMapper(UpdateDao.class);
        QueryDao queryDao = session.getMapper((QueryDao.class));
        List<String> companys = queryDao.listCompanyByName(); // check companies in current portfolio

        String[] updateInfo = c.substring(1, c.length()-1).split(",");
        for (String str : updateInfo) {
            CompanyForm companyform = gson.fromJson(str, CompanyForm.class);
            Company company = companyform.toCompany();
            if (companys.contains(company.getCompany_name())) {
                insertdao.addCompany(company);
            } else {
                updateDao.updateCompany(company);
            }
        }
    }

    // TODO Implement delete function
}
