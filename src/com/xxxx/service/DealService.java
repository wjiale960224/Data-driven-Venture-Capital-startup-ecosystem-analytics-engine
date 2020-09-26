package com.xxxx.service;

import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Deal;
import com.xxxx.entity.Valuation;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class DealService {
    public List<Integer> getDealId(){
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<Integer> DealId = userdao.listDealById();
        return DealId;
    }

    public String getDealInfo(List<Integer> deal_IDs) {
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<Deal> dealList = new ArrayList<>();
        String output = "";
        for (Integer d : deal_IDs) {
            Deal deal = userdao.queryDealById(d);
            dealList.add(deal);
        }
        for (Deal d : dealList) {
            output += "{\"No.\":\"" + d.getDid() + "\"}";
        }
        return "[" + output.substring(0, output.length() - 1) + "]";
    }
}
