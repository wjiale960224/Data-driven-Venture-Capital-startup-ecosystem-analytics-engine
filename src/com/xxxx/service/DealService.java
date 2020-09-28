package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.InsertDao;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.*;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class DealService {
    public List<Integer> getDealId() {
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
            output += "{\"NoDealID.\":\"" + d.getDid() + "\"NoCID.\":\"" + d.getCompany() + "\",\"Deal_Date\":\"" +
                    d.getDeal_date() + "\",\"Deal_Size\":\"" + d.getDeal_size() + "\",\"Deal_Status\":\"" + d.getDeal_status()
                    + "\",\"Series\":\"" + d.getSeries() + "\",\"MSEQ_Amount\":\"" + d.getMSEQ_invest_amount()
                    + "\",\"Invest_vehicle\":\"" + d.getVehicle() + "\",\"Co_Investor\":\"" + d.getCo_investor()
                    + "\",\"Fund_Percent\":\"" +  d.getFund_percentage()+ "\",\"Own_Percent\":\"" +  d.getOwn_percentage()
                    + "\"}";

        }
        return "[" + output.substring(0, output.length() - 1) + "]";
    }

    public void updateDealInfo(String c) {
        Gson gson = new Gson();
        SqlSession session = GetSqlSession.createSqlSession();
        InsertDao insertdao = session.getMapper(InsertDao.class);
        QueryDao queryDao = session.getMapper((QueryDao.class));
        List<Integer> dealIds = queryDao.listDealById();

        DealList dealList = gson.fromJson(c, DealList.class);
        for (Deal deal : dealList.arrayList) {
            if (!dealIds.contains(deal)) {
                insertdao.addDeal(deal); // insert new deal entry
            } else {
                // TODO implement 查重更新 deal entry

            }

            if (!Portfolio.getPortfolio1().contains(deal)) {
                Portfolio.getPortfolio1().add(deal.getDid());
            }
        }
    }
}
