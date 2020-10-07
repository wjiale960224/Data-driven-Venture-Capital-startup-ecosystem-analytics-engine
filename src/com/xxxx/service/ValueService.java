package com.xxxx.service;

import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.CompanyList;
import com.xxxx.entity.Portfolio;
import com.xxxx.entity.User;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueService {

    // TODO Implement getPreValue method?

    public List<String> getPostValue(CompanyList cl) {

        List<String> post_list = new ArrayList<>();
        SqlSession session = GetSqlSession.createSqlSession();

        for (Company c : cl.arrayList) {
            //if (Portfolio.portfolio.contains(c.getCompany_name())) {
                Userdao userdao = session.getMapper(Userdao.class);
              //List<Double> values = userdao.queryPostValueByCompany(c.getCompany_name());
               // post_list.add(Arrays.toString(values.toArray()));
            }
  //      }

       // if (post_list.size() == 0) {
//            post_list.add("Input companies are not in portfolio.");
        //}
        //return post_list;
    //}
return null;}
}
