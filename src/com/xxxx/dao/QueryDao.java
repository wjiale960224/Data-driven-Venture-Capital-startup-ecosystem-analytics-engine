package com.xxxx.dao;

import com.xxxx.entity.*;
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

    Double[] queryValueByName(String company_name);

    List<String> listCompanyByName();

    Valuation[] queryValuationByCID(Integer cid); // get the latest present value of the company

    Valuation queryLatestValuationByCID(Integer cid); // get the latest present value of the company

    List<Integer> listDealById();

    Deal queryDealById(Integer deal_id);

    List<Map<String,Object>> queryTheme();

    Integer queryCidByCompanyName(String companyName);

    List<Integer> queryCid();

    List<Deal> queryDeals();

    Double queryDrawnByFundname(String fund_name);

    Double queryFeeByFundname(String fund_name);

    TotCapitalMngFee queryCapitalMngFee();

    Deal queryLatestDealByCompanyCID(Integer cid);

    List<Deal> queryDealsByCompanyName(String c_name);

    List<Valuation> queryValuationsByCompanyName(String c_name);

    Deal queryEarliestDealByCompanyCID(Integer cid);

}
