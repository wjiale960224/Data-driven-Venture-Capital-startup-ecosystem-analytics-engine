package com.xxxx.test;

import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

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
        String output = "";
        for(String c : company_names){
            Company company = queryDao.queryCompanyByName(c);
            data.add(company);
        }
        for (Integer id: dealIds){
            Deal d = userdao.queryDealById(id);
            deal.add(d);
            System.out.println(d.getC_name());
        }
        for(Company c : data) {
            double fund = 0;
            for (Deal d : deal) {
                if (c.getC_name().equals(d.getC_name())) {
                    fund = fund + d.getMSEQ_invest_amount();
                }
            }
        }
        System.out.println(output);
    }
}
