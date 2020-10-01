package com.xxxx.dao;

import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;

import java.util.Map;


public interface DelectDao {


    int delCompany(Company company);

    int delCompanyByMap(Map<String,Object> map);

    int delDeal(Deal deal_id);


}
