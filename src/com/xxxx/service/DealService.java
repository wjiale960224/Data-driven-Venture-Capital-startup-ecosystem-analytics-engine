package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.DelectDao;
import com.xxxx.dao.InsertDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Deal;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

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
            output += "{\"NoDealID.\":\"" + d.getDid() + "\"NoCID.\":\"" + d.getCompany().getCompany_name() + "\",\"Deal_Date\":\"" +
                    d.getDeal_date() + "\",\"Deal_Size\":\"" + d.getDeal_size() + "\",\"Deal_Status\":\"" + d.getDeal_status()
                    + "\",\"Series\":\"" + d.getSeries() + "\",\"MSEQ_Amount\":\"" + d.getMSEQ_invest_amount()
                    + "\",\"Invest_vehicle\":\"" + d.getVehicle() + "\",\"Co_Investor\":\"" + d.getCo_investor()
                    + "\",\"Fund_Percent\":\"" + d.getFund_percentage() + "\",\"Own_Percent\":\"" + d.getOwn_percentage()
                    + "\"}";

        }
        return "[" + output.substring(0, output.length() - 1) + "]";
    }

    public void updateDealInfo(String d) {
        Gson gson = new Gson();
        SqlSession session = GetSqlSession.createSqlSession();
        InsertDao insertdao = session.getMapper(InsertDao.class);

        JSONObject jsonObject = new JSONObject(d);
        org.json.JSONArray jsonArray = jsonObject.getJSONArray("deal");
        int l = jsonArray.length();
        for (int i = 0; i < l; i++) {
            Deal deal = gson.fromJson(jsonArray.getJSONObject(i).toString(), Deal.class);
            insertdao.addDeal(deal); // insert new deal entry
        }
        // It is not possible to check current deal and update since we cannot check by ID.
        // Need to delete the deal and create a new entry.
    }

    // TODO Implement delete function
    public void deleteDealInfo(String d) {
        Gson gson = new Gson();
        SqlSession session = GetSqlSession.createSqlSession();
        DelectDao delectdao = session.getMapper(DelectDao.class);

        JSONObject jsonObject = new JSONObject(d);
        JSONArray jsonArray = jsonObject.getJSONArray("deal");
        int l = jsonArray.length();
        for (int i = 0; i < l; i++) {
            Deal deal = gson.fromJson(jsonArray.getJSONObject(i).toString(), Deal.class);
            delectdao.delDeal(deal);
        }
    }


}
