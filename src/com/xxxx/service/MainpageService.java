package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.overview.MainpageData;
import com.xxxx.entity.overview.OverviewInfo;
import com.xxxx.entity.overview.ThemeInfo;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class MainpageService {

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

    public String getMainpageDataInfo(List<String> company_names, List<Integer> dealIds){
        SqlSession session = GetSqlSession.createSqlSession();
        QueryDao queryDao = session.getMapper(QueryDao.class);
        Userdao userdao = session.getMapper(Userdao.class);
        List<Deal> deal = new ArrayList<>();
        List<Company> data = new ArrayList<>();
        List<MainpageData> dataMainpage = new ArrayList<>();
        String output = "";
        String perOfFund = "";
        String themeOfFund = "";
        double total_mseq_invest = 0;
        for(String c : company_names){
            Company company = queryDao.queryCompanyByName(c);
            data.add(company);
        }
        for (Integer id: dealIds){
            Deal d = userdao.queryDealById(id);
            deal.add(d);
        }
        int no_company = data.size();
        int no_deal = dealIds.size();
        for(Deal d : deal){
            total_mseq_invest = total_mseq_invest + d.getMSEQ_invest_amount();
        }
        double total_mseq_invest_output = total_mseq_invest/1000000;
        Gson g = new Gson();

        for(Company c : data){
            double fund = 0;
            for(Deal d : deal){
                if(c.getC_name().equals(d.getC_name())){
                    fund = fund + d.getMSEQ_invest_amount();
                }
            }
            MainpageData mainpageData = new MainpageData(c.getC_name(),c.getTheme().toString(),fund);
            dataMainpage.add(mainpageData);
            perOfFund += g.toJson(mainpageData) + ",";
        }
        double spa_fund = 0;
        double new_fund = 0;
        double Exp_fund = 0;
        double feed_fund = 0;
        double human_fund = 0;
        for(MainpageData m: dataMainpage){
            if(m.getTheme().contains("Spa")){
                spa_fund = spa_fund + m.getFund();
            }
            else if (m.getTheme().contains("New")){
                new_fund = new_fund + m.getFund();
            }
            else if (m.getTheme().contains("Human")){
                human_fund = human_fund + m.getFund();
            }
            else if (m.getTheme().contains("Exp")){
                Exp_fund = Exp_fund + m.getFund();
            }
            else if (m.getTheme().contains("Feed")){
                feed_fund = feed_fund + m.getFund();
            }
        }
        for (MainpageData m : dataMainpage){
            if(m.getTheme().contains("Spa")){
                ThemeInfo themeInfo = new ThemeInfo(m.getTheme(),spa_fund);
                themeOfFund += g.toJson(themeInfo)+",";
            }
            else if (m.getTheme().contains("New")){
                ThemeInfo themeInfo = new ThemeInfo(m.getTheme(),new_fund);
                themeOfFund += g.toJson(themeInfo)+",";
            }
            else if (m.getTheme().contains("Human")){
                ThemeInfo themeInfo = new ThemeInfo(m.getTheme(),human_fund);
                themeOfFund += g.toJson(themeInfo)+",";
            }
            else if (m.getTheme().contains("Exp")){
                ThemeInfo themeInfo = new ThemeInfo(m.getTheme(),Exp_fund);
                themeOfFund += g.toJson(themeInfo)+",";
            }
            else if (m.getTheme().contains("Feed")){
                ThemeInfo themeInfo = new ThemeInfo(m.getTheme(),feed_fund);
                themeOfFund += g.toJson(themeInfo)+",";
            }
        }
        themeOfFund = "ThemeOfFund[" + themeOfFund.substring(0,themeOfFund.length()-1)+"]";
        perOfFund = "PerOfFun[" + perOfFund.substring(0, perOfFund.length() - 1) + "]";
        OverviewInfo oi = new OverviewInfo(1.1,total_mseq_invest_output,1.1,1.1,no_company,no_deal,total_mseq_invest_output/no_deal,1,1.1);
        String ovInfo = g.toJson(oi);
        ovInfo = "OvInfo[" + ovInfo + "]";

        output = perOfFund + ovInfo + themeOfFund;
        return output;
    }
}
