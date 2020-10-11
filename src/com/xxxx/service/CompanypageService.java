package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.Valuation;
import com.xxxx.entity.companypageinfo.CompanyInfomation;
import com.xxxx.entity.companypageinfo.Dealinfo;
import com.xxxx.entity.overview.MainpageData;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanypageService {
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

    public String getCompanypageDataInfo(List<String> company_names, List<Integer> dealIds){
        SqlSession session = GetSqlSession.createSqlSession();
        QueryDao queryDao = session.getMapper(QueryDao.class);
        Userdao userdao = session.getMapper(Userdao.class);
        List<Deal> deal = new ArrayList<>();
        List<Company> data = new ArrayList<>();
        List<CompanyInfomation> companyInfomations = new ArrayList<>();
        Map<Company, Valuation> companyValuationMap = new HashMap<>();
        String output = "";
        String companyinfostring = "";
        String dealinfostring = "";
        Gson g = new Gson();
        for(String c : company_names){
            Company company = queryDao.queryCompanyByName(c);
            Valuation valuation = queryDao.queryLatestValuationByCID(company.getCid());
            companyValuationMap.put(company, valuation);
            data.add(company);
        }
        for (Integer id: dealIds){
            Deal d = userdao.queryDealById(id);
            deal.add(d);
        }
        for (Company c : data){
            int i = 1;
            for(Deal d : deal){
                String deal_no = "deal" + i;
                if (c.getC_name().equals(d.getC_name())){
                    Dealinfo dealinfo = new Dealinfo(c.getC_name(),c.getTheme().toString(),d.getDeal_size(),deal_no,d.getPost_value());
                    dealinfostring += g.toJson(dealinfo) + ",";
                    i = i + 1;
                }
            }
        }
        for(Company c : data){
            Double mseq_total_invest = 0.0;
            Valuation v = companyValuationMap.get(c);
            int deal_no = 0;
            for(Deal d : deal){
                if (c.getC_name().equals(d.getC_name())){
                    mseq_total_invest = mseq_total_invest + d.getMSEQ_invest_amount();
                    deal_no++;
                }
            }
            CompanyInfomation companyInfomation = new CompanyInfomation(c.getC_name(),c.getTheme().toString(),mseq_total_invest,deal_no,v.getMseq_investment_cur_val(),c.getRunway_month(),"",0.0,v.getOwn_percent(),c.getEmployee_no(),c.getRevenue());
            companyInfomations.add(companyInfomation);

        }
        for (CompanyInfomation c: companyInfomations){
            if (c.getTotal_mseq_invest() <= 500000){
                c.setStage("Preseed");
            }
            else if(c.getTotal_mseq_invest() > 500000 && c.getTotal_mseq_invest() <= 1000000){
                c.setStage("Seed");
            }
            else if(c.getTotal_mseq_invest() > 1000000 && c.getTotal_mseq_invest() <= 2500000){
                c.setStage("Start");
            }
            else if(c.getTotal_mseq_invest() > 2500000 && c.getTotal_mseq_invest() <= 5000000){
                c.setStage("Scale");
            }
            else if(c.getTotal_mseq_invest() > 5000000){
                c.setStage("Growth");
            }
            companyinfostring += g.toJson(c) + ",";
        }
        companyinfostring = "CompanyInfo[" + companyinfostring.substring(0,companyinfostring.length()-1)+ "]";
        dealinfostring = "DealInfo[" + dealinfostring.substring(0,dealinfostring.length()-1)+ "]";
        output = companyinfostring + dealinfostring;

        return output;
    }
}
