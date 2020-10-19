package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.Valuation;
import com.xxxx.entity.overview.MainpageData;
import com.xxxx.entity.overview.ThemeInfo;
import com.xxxx.entity.themeinfo.CompanyInfo;
import com.xxxx.entity.themeinfo.CompanyTotalInvestment;
import com.xxxx.entity.themeinfo.ThemeInfomation;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThemepageService {
    public List<String> getCompanyNames(){
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<String> Company_name = userdao.listCompanyByName();
        return Company_name;
    }
    public List<Integer> getDealId() {
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<Integer> DealId = userdao.listDealById();
        return DealId;
    }

    public String getThemepageDataInfo(List<String> c_name, List<Integer> deal_id){
        SqlSession session = GetSqlSession.createSqlSession();
        QueryDao queryDao = session.getMapper(QueryDao.class);
        Userdao userdao = session.getMapper(Userdao.class);
        List<Deal> deal = new ArrayList<>();
        List<Deal> latestDeal = new ArrayList<>();// Latest deals for each company
        List<Deal> earlistDeals = new ArrayList<>(); // Earliest company for each deal
        List<Company> data = new ArrayList<>(); // All companies data
        List<CompanyInfo> companyInfos = new ArrayList<>();
        List<Valuation> valuations = new ArrayList<>();
        String output = "";
        String company_total_investment = "";
        String companyInfoString = "";
        String themeOffund="";
        String tableInfo = "";
        Gson g = new Gson();
        for(String c : c_name){
            Company company = queryDao.queryCompanyByName(c);
            data.add(company);

            Deal lastDeal = queryDao.queryLatestDealByCompanyCID(company.getCid());
            latestDeal.add(lastDeal);

            Valuation valuation = queryDao.queryLatestValuationByCID(company.getCid());
            valuations.add(valuation);

            Deal earlyDeal = queryDao.queryEarliestDealByCompanyCID(company.getCid());
            earlistDeals.add(earlyDeal);
        }
        for (int i : deal_id){
            Deal d = queryDao.queryDealById(i);
            deal.add(d);
        }

        for (Company c : data){
            int i = 1;
            Double fund = 0.0;
            Valuation latestV = new Valuation();
            for (Valuation vv : valuations){
                if (vv.getC_name().equals(c.getC_name())){
                    latestV = vv;
                    break;
                }
            }
            Deal earlyDeal = new Deal();
            for (Deal earlyD : earlistDeals){
                if (earlyD == null){
                    continue;
                }
                if (earlyD.getC_name().equals(c.getC_name())){
                    earlyDeal = earlyD;
                }
            }
            Deal latestD = new Deal();
            for (Deal lastD: latestDeal){
                if (lastD == null){
                    continue;
                }
                if (lastD.getC_name().equals(c.getC_name())){
                    latestD = lastD;
                }
            }

            CompanyInfo cif = new CompanyInfo(c.getC_name(),c.getTheme().toString(),null,earlyDeal.getDeal_date(),latestD.getMSEQ_invest_amount(),latestD.getOwn_percentage_toString(),latestD.getPost_value(),latestD.getInvest_vehicle_toString(),c.getIrr(),null);
            tableInfo += g.toJson(cif) + ",";

            for (Deal d : deal){
                String deal_no = "deal" + i;
                if (c.getC_name().equals(d.getC_name())){
                    CompanyInfo companyInfo = new CompanyInfo(c.getC_name(),c.getTheme().toString(),deal_no,d.getDeal_date(),d.getMSEQ_invest_amount(),d.getOwn_percentage(),10000.0,"ok",20.1,d.getPost_value());
                    companyInfos.add(companyInfo);
                    companyInfoString += g.toJson(companyInfo) + ",";
                    i = i + 1;
                    if (d.getMSEQ_invest_amount() == null){
                        fund = fund + 0;
                    }
                    else{fund = fund + d.getMSEQ_invest_amount();}
                }

            }
            CompanyTotalInvestment companyTotalInvestment = new CompanyTotalInvestment(c.getC_name(),fund,c.getTheme().toString());
            company_total_investment += g.toJson(companyTotalInvestment) + ",";
        }
        double spa_fund = 0;
        double new_fund = 0;
        double Exp_fund = 0;
        double feed_fund = 0;
        double human_fund = 0;
        double over_all = 0;
        HashSet spa_company_no = new HashSet();
        HashSet new_company_no = new HashSet();
        HashSet Exp_company_no = new HashSet();
        HashSet feed_company_no = new HashSet();
        HashSet human_company_no = new HashSet();
        for(CompanyInfo c: companyInfos){
            if(c.getTheme().contains("Spa")){
                if (c.getCost() == null){
                    spa_fund = spa_fund + 0;
                }
                else {
                    spa_fund = spa_fund + c.getCost();
                    spa_company_no.add(c.getCompany_name());
                }
            }
            else if (c.getTheme().contains("New")){
                if (c.getCost() == null){
                    new_fund = new_fund + 0;
                }
                else {
                    new_fund = new_fund + c.getCost();
                    new_company_no.add(c.getCompany_name());
                }
            }
            else if (c.getTheme().contains("Human")){
                if (c.getCost() == null){
                    human_fund = human_fund + 0;
                }
                else {
                    human_fund = human_fund + c.getCost();
                    human_company_no.add(c.getCompany_name());
                }
            }
            else if (c.getTheme().contains("Exponential")){
                if (c.getCost() == null){
                    Exp_fund = Exp_fund + 0;
                }
                else {
                    Exp_fund = Exp_fund + c.getCost();
                    Exp_company_no.add(c.getCompany_name());
                }
            }
            else if (c.getTheme().contains("Feed")){
                if (c.getCost() == null){
                    feed_fund = feed_fund + 0;
                }
                else {
                    feed_fund = feed_fund + c.getCost();
                    feed_company_no.add(c.getCompany_name());
                }
            }
        }
        over_all = Exp_fund + feed_fund + human_fund + new_fund + spa_fund;
        ThemeInfomation themeInfo = new ThemeInfomation("Exponential_Machines",Exp_company_no.size(),Exp_fund,over_all,data.size());
        ThemeInfomation themeInfo1 = new ThemeInfomation("Feeding_10B_People",feed_company_no.size(),feed_fund,over_all, data.size());
        ThemeInfomation themeInfo2 = new ThemeInfomation("Humanity_Scale_Healthcare",human_company_no.size(),human_fund,over_all, data.size());
        ThemeInfomation themeInfo3 = new ThemeInfomation("New_Society",new_company_no.size(),new_fund,over_all, data.size());
        ThemeInfomation themeInfo4 = new ThemeInfomation("Space_&_Transport",spa_company_no.size(),spa_fund,over_all, data.size());
        themeOffund = g.toJson(themeInfo)+","+g.toJson(themeInfo1)+","+g.toJson(themeInfo2)+","+g.toJson(themeInfo3)+","+g.toJson(themeInfo4)+",";
        themeOffund = "ThemeOfFund[" + themeOffund.substring(0,themeOffund.length()-1)+"]";
        companyInfoString = "CompanyInFo[" + companyInfoString.substring(0,companyInfoString.length()-1)+"]";
        company_total_investment = "CompanyTotal[" + company_total_investment.substring(0,company_total_investment.length()-1) + "]";
        tableInfo = "tableInfo[" + tableInfo.substring(0,tableInfo.length()-1) + "]";
        output = companyInfoString + themeOffund + company_total_investment + tableInfo;
        return output;
    }
}
