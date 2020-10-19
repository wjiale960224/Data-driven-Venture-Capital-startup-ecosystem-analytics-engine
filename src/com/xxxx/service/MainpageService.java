package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.overview.*;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Capital getCapitalInfo(){
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        Capital capital = userdao.listAllCapital();
        return capital;
    }

    public List<TvpiData> getTvpiInfo(){
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<TvpiData> tvpiData = userdao.listAllTvpi();
        return tvpiData;
    }

    public String getMainpageDataInfo(List<String> company_names, List<Integer> dealIds){
        SqlSession session = GetSqlSession.createSqlSession();
        QueryDao queryDao = session.getMapper(QueryDao.class);
        Userdao userdao = session.getMapper(Userdao.class);
        Capital capital = getCapitalInfo();
        List<TvpiData> tvpiData = getTvpiInfo();
        List<Deal> deal = new ArrayList<>();
        List<Company> data = new ArrayList<>();
        List<MainpageData> dataMainpage = new ArrayList<>();
        Gson g = new Gson();
        String output = "";
        String perOfFund = "";
        String themeOfFund = "";
        String tvpioutput = "";
        String seriesoutput = "";
        double total_mseq_invest = 0;
        int number_of_series_a = 0;
        int number_of_series_b = 0;
        int number_of_series_c = 0;
        int number_of_series_seed = 0;
        int number_of_series_preseed = 0;
        Set<String> update_date = new HashSet<>();
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
        for (Deal d : deal){
            if (d.getMSEQ_invest_amount() == null){
                continue;
            }
            total_mseq_invest = total_mseq_invest + d.getMSEQ_invest_amount();
            if (d.getUpdate_date() == null){
                continue;
            }
            update_date.add(d.getUpdate_date().toString());
        }



        for (String s: update_date){
            int No_of_A = 0;
            int No_of_B = 0;
            int No_of_C = 0;
            int No_of_pre = 0;
            int No_of_seed = 0;
            int No_of_null = 0;
            for (Deal d : deal){
                if (d.getUpdate_date() == null){
                    continue;
                }
                if (s.equals(d.getUpdate_date().toString())){
                    if (d.getSeries() == null){
                        No_of_null ++;
                    }
                    else {
                        if (d.getSeries().toString().contains("A")) {
                            No_of_A++;
                        }
                        if (d.getSeries().toString().contains("B")) {
                            No_of_B++;
                        }
                        if (d.getSeries().toString().contains("C")) {
                            No_of_C++;
                        }
                        if (d.getSeries().toString().contains("P")) {
                            No_of_pre++;
                        }
                        if (d.getSeries().toString().equals("Seed")){
                            No_of_seed++;
                        }
                    }
                }

            }
            SeriesData seriesData = new SeriesData(No_of_A,No_of_B,No_of_C,No_of_pre,No_of_seed,No_of_null,s);
            seriesoutput += g.toJson(seriesData) + ",";
        }

        double total_mseq_invest_output = total_mseq_invest;

        for (TvpiData t : tvpiData){
            TvpiOutput tvpiOutput = new TvpiOutput(t.getDate(), t.getTvpi());
            tvpioutput += g.toJson(tvpiOutput) + ",";
        }

        for(Company c : data){
            double fund = 0;
            for(Deal d : deal){
                if(c.getC_name().equals(d.getC_name())){
                    if(d.getMSEQ_invest_amount() == null){
                        continue;
                    }
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
                if(m.getFund() == null){
                    continue;
                }
                spa_fund = spa_fund + m.getFund();
            }
            else if (m.getTheme().contains("New")){
                if(m.getFund() == null){
                    continue;
                }
                new_fund = new_fund + m.getFund();
            }
            else if (m.getTheme().contains("Human")){
                if(m.getFund() == null){
                    continue;
                }
                human_fund = human_fund + m.getFund();
            }
            else if (m.getTheme().contains("Exp")){
                if(m.getFund() == null){
                    continue;
                }
                Exp_fund = Exp_fund + m.getFund();
            }
            else if (m.getTheme().contains("Feed")){
                if(m.getFund() == null){
                    continue;
                }
                feed_fund = feed_fund + m.getFund();
            }
        }
        ThemeInfo themeInfo = new ThemeInfo("Space_Transport",spa_fund);
        ThemeInfo themeInfo1 = new ThemeInfo("New_Society",new_fund);
        ThemeInfo themeInfo2 = new ThemeInfo("Humanity_Scale_Healthcare",human_fund);
        ThemeInfo themeInfo3 = new ThemeInfo("Feeding_10B_People",feed_fund);
        ThemeInfo themeInfo4 = new ThemeInfo("Exponential_Machines",Exp_fund);
        themeOfFund = g.toJson(themeInfo)+","+g.toJson(themeInfo1)+","+g.toJson(themeInfo2)+","+g.toJson(themeInfo3)+","+g.toJson(themeInfo4)+",";

        themeOfFund = "ThemeOfFund[" + themeOfFund.substring(0,themeOfFund.length()-1)+"]";
        perOfFund = "PerOfFun[" + perOfFund.substring(0, perOfFund.length() - 1) + "]";
        tvpioutput = "Tvpi[" + tvpioutput.substring(0, tvpioutput.length()-1) + "]";
        OverviewInfo oi = new OverviewInfo(capital.getTotal_fund(),total_mseq_invest_output + capital.getManagement_fee(),capital.getTotal_fund() - total_mseq_invest_output - capital.getManagement_fee(), capital.getManagement_fee(), no_company,no_deal,total_mseq_invest_output/no_deal,capital.getTotal_fund()-capital.getManagement_fee()-total_mseq_invest_output, capital.getTotal_capital_raised(),total_mseq_invest_output,number_of_series_a,number_of_series_b,number_of_series_c,number_of_series_seed,number_of_series_preseed);
        String ovInfo = g.toJson(oi);
        ovInfo = "OvInfo[" + ovInfo + "]";
        seriesoutput = "SeriesData[" + seriesoutput.substring(0,seriesoutput.length()-1)+"]";

        output = perOfFund + ovInfo + themeOfFund + tvpioutput + seriesoutput;
        return output;
    }
}
