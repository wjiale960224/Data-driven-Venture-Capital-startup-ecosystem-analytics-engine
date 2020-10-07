package com.xxxx.test;

import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.User;
import com.xxxx.service.CompanyService;
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
        Userdao userdao = session.getMapper(Userdao.class);
        List<Integer> DealId = userdao.listDealById();
        List<Deal> dealList = new ArrayList<>();
        String output = "";
        for (Integer d : DealId) {
            Deal deal = userdao.queryDealById(d);
            dealList.add(deal);
        }
        for (Deal d : dealList) {
            output += "{\"NoDealID.\":\"" + d.getDid() + "\"NoCID.\":\"" + d.getCompany().getC_name() + "\",\"Deal_Date\":\"" +
                    d.getDeal_date() + "\",\"Deal_Size\":\"" + d.getDeal_size() + "\",\"Deal_Status\":\"" + d.getDeal_status()
                    + "\",\"Series\":\"" + d.getSeries() + "\",\"MSEQ_Amount\":\"" + d.getMSEQ_invest_amount()
                    + "\",\"Invest_vehicle\":\"" + d.getVehicle() + "\",\"Co_Investor\":\"" + d.getCo_investor()
                    + "\",\"Fund_Percent\":\"" + d.getFund_percentage() + "\",\"Own_Percent\":\"" + d.getOwn_percentage()
                    + "\"}";

        }
        System.out.println(output);
    }
}
