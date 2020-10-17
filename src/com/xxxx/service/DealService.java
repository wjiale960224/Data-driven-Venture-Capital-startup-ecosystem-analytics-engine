package com.xxxx.service;

import com.google.gson.Gson;
import com.xxxx.dao.InsertDao;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.UpdateDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.*;
import com.xxxx.util.GetSqlSession;
import com.xxxx.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DealService {

    public List<Integer> getDealId() {
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        List<Integer> dealId = userdao.listDealById();
        return dealId;
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
            DealForm df = new DealForm(d.getC_name(),d.getDeal_date().toString(),d.getDeal_size(),d.getSeries_toString(),
                    d.getMSEQ_invest_amount(),d.getPost_value(),d.getVehicle_toString(),d.getCo_investor(),d.getFund_percentage(),
                    d.getOwn_percentage_toString());
            output += g.toJson(df) + ",";
        }
        return "[" + output.substring(0, output.length() - 1) + "]";
    }

    public void updateDealInfo(String d) {
        Gson gson = new Gson();
        SqlSession session = GetSqlSession.createSqlSession();
        InsertDao insertdao = session.getMapper(InsertDao.class);
        QueryDao queryDao = session.getMapper(QueryDao.class);
        UpdateDao updateDao = session.getMapper(UpdateDao.class);
        List<Deal> dealsInDB = queryDao.queryDeals();
        String[] updateInfo = StringUtil.SplitStrings(d);

        for (String str : updateInfo) {
            DealForm dealForm = gson.fromJson(str, DealForm.class); // DealForm instance
            Deal dealInForm = dealForm.toDeal(); // Deal instance
            System.out.println("c_name: "+dealInForm.getC_name());
            System.out.println("deal_size: "+dealInForm.getDeal_size());
            System.out.println("deal_date: "+dealInForm.getDeal_date());
            System.out.println("series: "+dealInForm.getSeries());
            System.out.println("mseq_invest_amt: "+dealInForm.getMSEQ_invest_amount());
            System.out.println("post_value: "+dealInForm.getPost_value());
            System.out.println("vehicle: "+dealInForm.getVehicle());
            System.out.println("co-investor: "+dealInForm.getCo_investor());
            System.out.println("fund_percent: "+dealInForm.getFund_percentage());
            System.out.println("own_percent: "+dealInForm.getOwn_percentage());

            dealInForm.setCid(queryDao.queryCidByCompanyName(dealInForm.getC_name())); // set cid in
            System.out.println("cid: " + dealInForm.getCid());

            int update = 0;
            for (Deal deal: dealsInDB){
                // Assumption: one company has only one deal on the same day.
                if (deal.getCid().equals(dealInForm.getCid()) && deal.getDeal_date().equals(dealInForm.getDeal_date())) { // update a deal entry in db
                    boolean same = CompareChange(deal, dealInForm);
                    if (!same) {
                        System.out.println("Need to update existing deal");
                        dealInForm.setDeal_id(deal.getDeal_id());
                        updateDao.updateDeal(dealInForm);

                        // adjust deal_size to drawn_capital in fund table, adjust management_fee in fund table
//                        if (!(deal.getDeal_size().equals(dealInForm.getDeal_size()))) { // deal size is updated
//                            Double current_drawn = queryDao.queryDrawnByFundname(dealInForm.getFund_name());
//                            Double current_fee = queryDao.queryFeeByFundname(dealInForm.getFund_name());
//                            current_drawn -= deal.getDeal_size();
//                            current_drawn += dealInForm.getDeal_size();
//                            current_fee += dealInForm.getDeal_size() * 0.02;
//                            updateDao.updateDrawnAndFee(dealInForm.getFund_name(), current_drawn, current_fee);
//                        }
                    }
                    update = 1;
                    break;
                }
            }

            if (update == 0) { // create a new deal entry in db
                System.out.println("Need to add new deal");
                dealInForm.setDeal_id();
                System.out.println("deal_id: " + dealInForm.getDeal_id());
                insertdao.addDeal(dealInForm);
                System.out.println("Insert deal finish");

                // add deal_size to drawn_capital in fund table, add 2% of deal_size to management_fee in fund table
//                    Double current_drawn = queryDao.queryDrawnByFundname(dealInForm.getFund_name());
//                    Double current_fee = queryDao.queryFeeByFundname(dealInForm.getFund_name());
//                    current_drawn += dealInForm.getDeal_size();
//                    current_fee += dealInForm.getDeal_size() * 0.02;
//                    updateDao.updateDrawnAndFee(dealInForm.getFund_name(), current_drawn, current_fee);

            }
        }

        session.commit();
        session.close();
    }

    // check all fields except: deal_id, cid, c_name, deal_date
    public static boolean CompareChange(Deal d1, Deal d2) {
        return d1.getDeal_size().equals(d2.getDeal_size()) &&
                d1.getSeries().equals(d2.getSeries()) &&
                d1.getMSEQ_invest_amount().equals(d2.getMSEQ_invest_amount()) &&
                d1.getPost_value().equals(d2.getPost_value()) &&
                d1.getVehicle().equals(d2.getVehicle()) &&
                d1.getCo_investor().equals(d2.getCo_investor()) &&
                d1.getFund_percentage().equals(d2.getFund_percentage()) &&
                d1.getOwn_percentage().equals(d2.getOwn_percentage());
    }
}
