package com.xxxx.test;

import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.Valuation;
import com.xxxx.entity.companypageinfo.CompanyInfomation;
import com.xxxx.entity.themeinfo.CompanyInfo;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    public List<String> getCompanyNames() {
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<String> Company_name = userdao.listCompanyByName();
        return Company_name;
    }


    public String getCompanyInfo(List<String> company_names) {
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<Company> companyList = new ArrayList<>();
        String output = "";
        for (String c : company_names) {
            Company company = userdao.queryCompanyByName(c);
            companyList.add(company);
        }
        for (Company c : companyList) {
            output = output + "[{\"Company_Name\":\"" + c.getC_name() + "\",\"Theme\":\"" + c.getTheme() + "\"},";
        }
        return output;
    }

    public static void main(String[] args) {
        SqlSession session = GetSqlSession.createSqlSession();
        QueryDao queryDao = session.getMapper(QueryDao.class);
        Userdao userdao = session.getMapper(Userdao.class);
        List<String> company_names = userdao.listCompanyByName();
        List<Integer> dealIds = userdao.listDealById();
        List<Deal> deal = new ArrayList<>();
        List<Company> data = new ArrayList<>();
        List<CompanyInfo> companyInfos = new ArrayList<>();
        String output = "";
        List<CompanyInfomation> companyInfomations = new ArrayList<>();
        Map<Company, Valuation> companyValuationMap = new HashMap<>();
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
    }
}
