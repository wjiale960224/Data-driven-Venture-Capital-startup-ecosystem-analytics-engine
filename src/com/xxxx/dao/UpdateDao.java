package com.xxxx.dao;

import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;

public interface UpdateDao {

    int updateRunwayMonth();

    int updateCompany(Company company);

    int updateDeal(Deal deal);

    void updateDrawnAndFee(String fund_name, Double drawn_capital, Double management_fee);
}
