package com.xxxx.dao;

import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import org.apache.ibatis.annotations.Param;

public interface InsertDao {

    int add(@Param("user_name") String user_name, @Param("user_pwd") String user_pwd);

    int addCompany(Company company);

    int addDeal(Deal deal);
}
