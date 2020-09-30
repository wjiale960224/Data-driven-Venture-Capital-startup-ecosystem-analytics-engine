package com.xxxx.test;

import com.xxxx.dao.InsertDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Theme;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertTest {
    public static void main(String[] args) {
        SqlSession mysql = GetSqlSession.createSqlSession();
        try {
            InsertDao insertDao =mysql.getMapper(InsertDao.class);
//            insertDao.addCompany(new Company(11110000,"hahaha", Theme.Exponential_Machines,2015,
//                    "2018-01-01","2020-01-01",5000000.0000,null,300000.0000));
            Map<String, Object> company = new HashMap<>();
            company.put("cid", "22220000");
            company.put("c_name", "hahaha2");
            company.put("theme", Theme.Exponential_Machines);
            insertDao.addCompanyByMap(company);

            mysql.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysql.close();
        }
    }
}
