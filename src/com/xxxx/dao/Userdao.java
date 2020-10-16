package com.xxxx.dao;

import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.User;
import com.xxxx.entity.Valuation;
import com.xxxx.entity.overview.Capital;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口类
 */

public interface Userdao {



    // call SQL query prepared in Userdao.xml

    User queryUserByname(String user_name);

    int add(@Param("user_name") String user_name, @Param("user_pwd") String user_pwd);

    List<Double> queryPostValueByCompany(String company_name);

    Company queryCompanyByName(String company_name);

    List<String> listCompanyByName();

    int addCompany(Company company);

    int addDeal(Deal deal);

    int updateRunwayMonth();

    Valuation queryValuationByCID(Integer cid);

    Valuation queryLatestValuationByCID(Integer cid); // get the latest present value of the company

    List<Integer> listDealById();

    Deal queryDealById(Integer deal_id);

    int delDealByDealId( int deal_id);

    Capital listAllCapital();
}
