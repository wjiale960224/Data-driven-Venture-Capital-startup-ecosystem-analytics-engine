package com.xxxx.dao;

import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.User;
import com.xxxx.entity.Valuation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface QueryDao {

    /**
        Generate new QueryDao in Test:
            QueryDao queryDao = mysql.getMapper(QueryDao.class);
    */

    User queryUserByname(String user_name);

    List<Double> queryPostValueByCompany(String company_name);

    Company queryCompanyByName(String company_name);

    Valuation queryValueByName(String company_name);


    List<String> listCompanyByName();

    //TODO complete this method in Userdao.xml if the code in CompanyService is necessary
    Valuation[] queryValuationByCID(Integer cid); // get the latest present value of the company

    Valuation queryLatestValuationByCID(Integer cid); // get the latest present value of the company

    List<Integer> listDealById();

    Deal queryDealById(Integer deal_id);

    List<Map<String,Object>> queryTheme();

    // TODO implement this query
    Integer queryCidByCompanyName(String companyName);

    List<Integer> queryCid();
}
