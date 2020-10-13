package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.InsertDao;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.UpdateDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.CompanyForm;
import com.xxxx.entity.TotCapitalMngFee;
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
        String output = "";
        Gson g = new Gson();
        for (String cc : company_names) {
            Company c = queryDao.queryCompanyByName(cc);
            Valuation v = queryDao.queryLatestValuationByCID(c.getCid());
            CompanyForm cf = new CompanyForm(c.getC_name(),c.getTheme().toString(),c.getYear_founded(),c.getRunway_start_date(),
                    c.getRunway_end_date(),c.getRunway_month(),c.getRaised_to_date(),c.getEmployee_no(),c.getRevenue(),
                    c.getIrr(), v.getPost_value(),
                    v.getValuation_change_reason(),v.getMseq_investment_cur_val(),v.getOwn_percent());
            output += g.toJson(cf) + ",";
        }
        System.out.println("check getCompanyInfo");
        return "[" + output.substring(0, output.length() - 1) + "]";
    }

    public String getCapitalMngFeeInfo(){
        SqlSession session = GetSqlSession.createSqlSession();
        QueryDao queryDao = session.getMapper(QueryDao.class);
        TotCapitalMngFee capitalFee = queryDao.queryCapitalMngFee();
        Gson gson = new Gson();
        return gson.toJson(capitalFee);
    }

    public void updateTotCapitalMngFee(String c){
        SqlSession session = GetSqlSession.createSqlSession();
        UpdateDao updateDao = session.getMapper(UpdateDao.class);
        Gson gson = new Gson();
        TotCapitalMngFee cf = gson.fromJson(c,TotCapitalMngFee.class);
        updateDao.updateCapitalMngFee(cf);
        session.commit();
        session.close();
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
            CompanyForm companyform = gson.fromJson(str, CompanyForm.class);
            Company companyInForm = companyform.toCompany();
            Valuation valuationInForm = companyform.toValuation();
            double[] valuationsInDB = null;
            int cidInDB = 0;
            if (!companys.contains(companyInForm.getC_name())) { // Add company and valuation
                companyInForm.setCid(); // generate a new cid for new company only
                insertdao.addCompany(companyInForm);
                valuationInForm.setVal_id();
                valuationInForm.setCid(companyInForm.getCid()); // change
                insertdao.addValuation(valuationInForm);
            }else{
                valuationsInDB = queryDao.queryValueByName(companyInForm.getC_name());
                Company companyInDB = queryDao.queryCompanyByName(companyInForm.getC_name());
                cidInDB = companyInDB.getCid();
                boolean same = CompareChange(companyInForm, companyInDB);
                if (!same){ // Update company info
                    companyInForm.setCid(companyInDB.getCid());
                    updateDao.updateCompany(companyInForm);
                }
                if (!HasPostValue(valuationsInDB, valuationInForm.getPost_value())){ // Update post value info
                    valuationInForm.setVal_id();
                    valuationInForm.setCid(cidInDB);
                    insertdao.addValuation(valuationInForm);
                }
            }

        }
        session.commit();
        session.close();
    }

    public static boolean CompareChange(Company c1, Company c2) {
        return c1.getTheme() == c2.getTheme() && c1.getYear_founded() == c2.getYear_founded() && c1.getRunway_start_date().equals(c2.getRunway_start_date()) &&
                c1.getRunway_end_date().equals(c2.getRunway_end_date()) && c1.getRunway_month() == c2.getRunway_month() &&
                c1.getRaised_to_date() == c2.getRaised_to_date() && c1.getEmployee_no() == c2.getEmployee_no() &&
                c1.getRevenue() == c2.getRevenue() && c1.getIrr().equals(c2.getIrr());
    }

    public static boolean HasPostValue(double[] postValuations, double v){
        // check all past valuations in db, if any past valuation matches the new one, return True
        for (double pv : postValuations){
            if (pv == v){
                return true;
            }
        }
        return false;
    }
}
