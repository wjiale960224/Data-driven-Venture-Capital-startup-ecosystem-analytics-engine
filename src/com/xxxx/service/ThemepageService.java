package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.overview.MainpageData;
import com.xxxx.entity.overview.ThemeInfo;
import com.xxxx.entity.themeinfo.CompanyInfo;
import com.xxxx.entity.themeinfo.ThemeInfomation;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

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
        List<Company> data = new ArrayList<>();
        List<CompanyInfo> companyInfos = new ArrayList<>();
        String output = "";
        String companyInfoString = "";
        String themeOffund="";
        Gson g = new Gson();
        for(String c : c_name){
            Company company = queryDao.queryCompanyByName(c);
            data.add(company);
        }

        for (Integer id: deal_id){
            Deal d = userdao.queryDealById(id);
            deal.add(d);
        }
        for (Company c : data){
            int i = 1;
            for (Deal d : deal){
                String deal_no = "deal" + i;
                if (c.getC_name().equals(d.getC_name())){
                    CompanyInfo companyInfo = new CompanyInfo(c.getC_name(),c.getTheme().toString(),deal_no,d.getDeal_date(),d.getMSEQ_invest_amount(),d.getOwn_percentage(),10000.0,"ok",20.1,d.getPost_value());
                    companyInfos.add(companyInfo);
                    companyInfoString += g.toJson(companyInfo) + ",";
                    i = i + 1;
                }

            }
        }
        double spa_fund = 0;
        double new_fund = 0;
        double Exp_fund = 0;
        double feed_fund = 0;
        double human_fund = 0;
        int spa_company_no = 0;
        int new_company_no = 0;
        int Exp_company_no = 0;
        int feed_company_no = 0;
        int human_company_no = 0;
        for(CompanyInfo c: companyInfos){
            if(c.getTheme().contains("Spa")){
                spa_fund = spa_fund + c.getCost();
                spa_company_no += 1;
            }
            else if (c.getTheme().contains("New")){
                new_fund = new_fund + c.getCost();
                new_company_no += 1;
            }
            else if (c.getTheme().contains("Human")){
                human_fund = human_fund + c.getCost();
                human_company_no += 1;
            }
            else if (c.getTheme().contains("Exp")){
                Exp_fund = Exp_fund + c.getCost();
                Exp_company_no += 1;
            }
            else if (c.getTheme().contains("Feed")){
                feed_fund = feed_fund + c.getCost();
                feed_company_no += 1;
            }
        }
        ThemeInfomation themeInfo = new ThemeInfomation("Exponential_Machines",Exp_company_no,Exp_fund);
        ThemeInfomation themeInfo1 = new ThemeInfomation("Feeding_10B_People",feed_company_no,feed_fund);
        ThemeInfomation themeInfo2 = new ThemeInfomation("Humanity_Scale_Healthcare",human_company_no,human_fund);
        ThemeInfomation themeInfo3 = new ThemeInfomation("New_Society",new_company_no,new_fund);
        ThemeInfomation themeInfo4 = new ThemeInfomation("Space_&_Transport",spa_company_no,spa_fund);
        themeOffund = g.toJson(themeInfo)+","+g.toJson(themeInfo1)+","+g.toJson(themeInfo2)+","+g.toJson(themeInfo3)+","+g.toJson(themeInfo4)+",";
        themeOffund = "ThemeOfFund[" + themeOffund.substring(0,themeOffund.length()-1)+"]";
        companyInfoString = "CompanyInFo[" + companyInfoString.substring(0,companyInfoString.length()-1)+"]";
        output = companyInfoString + themeOffund;
        return output;
    }
}
