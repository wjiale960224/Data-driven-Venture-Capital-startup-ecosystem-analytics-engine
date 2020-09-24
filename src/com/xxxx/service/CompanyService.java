package com.xxxx.service;

import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class CompanyService {


    public List<String> getCompanyNames(){
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<String> Company_name = userdao.listCompanyByName();
        return Company_name;
    }


    public String getCompanyInfo(List<String> company_names){
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<Company> companyList = new ArrayList<>();
        String output = "";
        for(String c: company_names){
            Company company = userdao.queryCompanyByName(c);
            companyList.add(company);
        }
        for(Company c : companyList){
            output = output +  "{\"Company_Name\":\"" + c.getCompany_name() + "\",\"Theme\":\"" + c.getTheme() + "\"},";
        }
        return "[" + output + "]";
    }
}
