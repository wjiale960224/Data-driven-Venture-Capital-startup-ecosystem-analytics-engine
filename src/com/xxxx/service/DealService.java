package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.DeleteDao;
import com.xxxx.dao.InsertDao;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.*;
import com.xxxx.util.GetSqlSession;
import com.xxxx.util.StringUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
        Gson g = new Gson();

        for (Integer d : deal_IDs) {
            Deal deal = userdao.queryDealById(d);
            dealList.add(deal);
        }

        for (Deal d : dealList) {
            DealForm df = new DealForm(d.getC_name(),d.getDeal_date_toString(),d.getDeal_size(),d.getDeal_status().toString(),d.getSeries_toString(),
                    d.getMSEQ_invest_amount(),d.getPost_value(),d.getVehicle_toString(),d.getCo_investor(),d.getFund_percentage(),
                    d.getOwn_percentage_toString());
            output += g.toJson(df) + ",";
        }
        return "[" + output.substring(0, output.length() - 1) + "]";
    }

    // TODO deal_id, cid, post_val is not given in the input. Need to create deal_id, get cid, calculate post_val when add new Deal into database.
    public void updateDealInfo(String d) throws ParseException {
        Gson gson = new Gson();
        SqlSession session = GetSqlSession.createSqlSession();
        InsertDao insertdao = session.getMapper(InsertDao.class);
        QueryDao queryDao = session.getMapper(QueryDao.class);
        String[] updateInfo = StringUtil.SplitStrings(d);
        List<Deal> dealsInDB = queryDao.queryDeals();
        for (String str : updateInfo) {
            DealForm dealForm = gson.fromJson(str, DealForm.class); // Deal form instance
            Deal dealInForm = dealForm.toDeal(); // deal instance

            for (Deal deal: dealsInDB){
                if (deal.equals(dealInForm)){ // Compare two deals, if same return true.

                }
            }
        }

        /*JSONObject jsonObject = new JSONObject(d);
        org.json.JSONArray jsonArray = jsonObject.getJSONArray("deal");
        int l = jsonArray.length();
        for (int i = 0; i < l; i++) {
            Deal deal = gson.fromJson(jsonArray.getJSONObject(i).toString(), Deal.class);
            insertdao.addDeal(deal); // insert new deal entry
        }*/
    }

    // When to call this method?
    public void deleteDealInfo(String d) {
        Gson gson = new Gson();
        SqlSession session = GetSqlSession.createSqlSession();
        DeleteDao deleteDao = session.getMapper(DeleteDao.class);

        JSONObject jsonObject = new JSONObject(d);
        JSONArray jsonArray = jsonObject.getJSONArray("deal");
        int l = jsonArray.length();
        for (int i = 0; i < l; i++) {
            Deal deal = gson.fromJson(jsonArray.getJSONObject(i).toString(), Deal.class);
            deleteDao.delDeal(deal);
        }
    }

}
