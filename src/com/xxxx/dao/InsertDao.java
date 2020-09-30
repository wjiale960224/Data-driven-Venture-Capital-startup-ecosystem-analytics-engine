package com.xxxx.dao;

import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface InsertDao {

    int add(@Param("user_name") String user_name, @Param("user_pwd") String user_pwd);

    int addCompany(Company company);

    int addCompanyByMap(Map<String,Object> map);

    int addDeal(Deal deal);
}
