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
                    v.getValuation_change_reason(),v.getMseq_investment_cur_val());
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
            System.out.println(companyInForm.getC_name());
            System.out.println(companyInForm.getEmployee_no());
            Valuation valuationInForm = companyform.toValuation();

            Double[] valuationsInDB = null;
            Integer cidInDB = 0;
            if (!companys.contains(companyInForm.getC_name())) { // Add company and valuation
                System.out.println("Need to add new company/valuation");
                companyInForm.setCid(); // generate a new cid for new company only
                insertdao.addCompany(companyInForm);
                System.out.println("Insert company finish");
                valuationInForm.setVal_id();
                valuationInForm.setCid(companyInForm.getCid()); // change
                insertdao.addValuation(valuationInForm);
                System.out.println("Insert valuation finish");

            } else {
                System.out.println("Need to update existing company/valuation");
                valuationsInDB = queryDao.queryValueByName(companyInForm.getC_name());
                System.out.println("queryValueByName finish");
                Company companyInDB = queryDao.queryCompanyByName(companyInForm.getC_name());
                System.out.println("queryCompanyByName finish");
                cidInDB = companyInDB.getCid();
                System.out.println("cid obtained");

                Boolean same = CompareChange(companyInForm, companyInDB);
                System.out.println("Compare company finish: " + (same ? "same" : "not same"));
                if (!same){ // Update company info
                    companyInForm.setCid(companyInDB.getCid());
                    updateDao.updateCompany(companyInForm);
                    System.out.println("Update company finish");
                }
                if (!HasPostValue(valuationsInDB, valuationInForm.getPost_value())){ // Update post value info
                    System.out.println("Found new post value");
                    valuationInForm.setVal_id();
                    valuationInForm.setCid(cidInDB);
                    insertdao.addValuation(valuationInForm);
                    System.out.println("Update valuation finish");
                }
            }

        }
        session.commit();
        session.close();
    }

    public static Boolean CompareChange(Company c1, Company c2) { // NullPointerException if only use equals()
        return  (  c1.getTheme()==null ? c2.getTheme()==null : c1.getTheme().equals(c2.getTheme())                                                  )&&
                (  c1.getYear_founded()==null ? c2.getYear_founded()==null : c1.getYear_founded().equals(c2.getYear_founded())                      )&&
                (  c1.getRunway_start_date()==null ? c2.getRunway_start_date()==null : c1.getRunway_start_date().equals(c2.getRunway_start_date())  )&&
                (  c1.getRunway_end_date()==null ? c2.getRunway_end_date()==null : c1.getRunway_end_date().equals(c2.getRunway_end_date())          )&&
                (  c1.getRunway_month()==null ? c2.getRunway_month()==null : c1.getRunway_month().equals(c2.getRunway_month())                      )&&
                (  c1.getRaised_to_date()==null ? c2.getRaised_to_date()==null : c1.getRaised_to_date().equals(c2.getRaised_to_date())              )&&
                (  c1.getEmployee_no()==null ? c2.getEmployee_no()==null : c1.getEmployee_no().equals(c2.getEmployee_no())                          )&&
                (  c1.getRevenue()==null ? c2.getRevenue()==null : c1.getRevenue().equals(c2.getRevenue())                                          )&&
                (  c1.getIrr()==null ? c2.getIrr()==null : c1.getIrr().equals(c2.getIrr())                                                          );
    }

    public static Boolean HasPostValue(Double[] postValuations, Double v){
        // check all past valuations in db, if any past valuation matches the new one, return True
        if (postValuations.length == 0)
            return false;
        for (Double pv : postValuations){
            boolean match = (pv==null ? v==null : pv.equals(v));
            if (match){
                return true;
            }
        }
        return false;
    }
}
