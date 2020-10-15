package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.Valuation;
import com.xxxx.entity.companypageinfo.CompanyInfomation;
import com.xxxx.entity.companypageinfo.DealSize;
import com.xxxx.entity.companypageinfo.Dealinfo;
import com.xxxx.entity.companypageinfo.PostChange;
import com.xxxx.entity.overview.MainpageData;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class CompanypageService {
    public List<String> getCompanyNames(){ // prefer use ID instead of name if name is not distinct
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
        Map<Company, Valuation> companyValuationMap = new HashMap<>();
        String output = "";
        String companyinfostring = "";
        String dealSizeInfo = "";
        String postChangeInfo = "";
        Gson g = new Gson();
        List<Deal> latestDeals = new ArrayList<>();
        List<Deal> dealsOneCompany;
        List<DealSize> listds = new ArrayList<>();

        List<Valuation> valuationsOneCompany;
        List<PostChange> listpc = new ArrayList<>();
        // ---- Get all company from database and get latest deal and all deals for the company.
        for(String c : company_names){
            Company company = queryDao.queryCompanyByName(c);
            data.add(company);

            Valuation valuation = queryDao.queryLatestValuationByCID(company.getCid());
            companyValuationMap.put(company, valuation);

            Deal lastDeal = queryDao.queryLatestDealByCompanyCID(company.getCid());
            latestDeals.add(lastDeal);

            // Collect deal size info
            DealSize dealSize = new DealSize(company.getC_name(),new LinkedHashMap<>());
            dealsOneCompany = queryDao.queryDealsByCompanyName(dealSize.Company_Name);
            for (Deal d: dealsOneCompany){
                dealSize.lhm.put(d.getDeal_date_toString(),d.getDeal_size());
            }
            listds.add(dealSize);
            // Collect post valuation info
            PostChange postChange = new PostChange(company.getC_name(), new LinkedHashMap<>());
            valuationsOneCompany = queryDao.queryValuationsByCompanyName(postChange.name);
            for (Valuation v: valuationsOneCompany){
                postChange.lhm.put(v.getUpdate_date().toString(),v.getPost_value());
            }
            listpc.add(postChange);
        }
        for (Integer id: dealIds){
            Deal d = userdao.queryDealById(id);
            deal.add(d);
        }


        // --------
        /*for (Company c : data){
            int i = 1;
            for(Deal d : deal){
                String deal_no = "deal" + i;
                if (c.getC_name().equals(d.getC_name())){
                    Dealinfo dealinfo = new Dealinfo(c.getC_name(),c.getTheme().toString(),d.getDeal_size(),deal_no,d.getPost_value());
                    dealinfostring += g.toJson(dealinfo) + ",";
                    i = i + 1;
                }
            }
        }*/
        // Collect company information and MSEQ invest pie chart
        for(Company c : data){
            Double mseq_total_invest = 0.0;
            Valuation v = companyValuationMap.get(c);
            Deal ld = new Deal();
            Integer deal_no = 0;
            for(Deal d : deal){
                if (c.getC_name().equals(d.getC_name())){
                    mseq_total_invest = mseq_total_invest + d.getMSEQ_invest_amount();
                    deal_no++;
                }
            }
            for (Deal d: latestDeals){
                if (c.getCid().equals(d.getCid())){
                    ld = d;
                    break;
                }
            }
            Double others = 0.0;
            if (ld.getDeal_size() == null || ld.getOwn_percentage() == null){
                others = null;
            }else {
                others = ld.getDeal_size() * (1-ld.getOwn_percentage());
            }
            CompanyInfomation companyInfomation = new CompanyInfomation(c.getC_name(),c.getTheme().toString(),mseq_total_invest,deal_no,v.getMseq_investment_cur_val(),c.getRunway_month(),ld.getSeries_toString(),v.getOwn_percent(),c.getEmployee_no(),c.getRevenue(), ld.getMSEQ_invest_amount(), others);
            companyinfostring += g.toJson(companyInfomation) + ",";
        }

        dealSizeInfo = g.toJson(listds);
        dealSizeInfo = "DealSizeInfo" + dealSizeInfo;
        postChangeInfo = g.toJson(listpc);
        postChangeInfo = "PostChangeInfo" + postChangeInfo;
        companyinfostring = "CompanyInfo[" + companyinfostring.substring(0,companyinfostring.length()-1)+ "]";
        output = companyinfostring + dealSizeInfo + postChangeInfo;
        return output;
    }
}
