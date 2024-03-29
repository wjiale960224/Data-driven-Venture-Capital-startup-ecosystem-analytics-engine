package com.xxxx.test;

import com.xxxx.dao.InsertDao;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.UpdateDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.*;
import com.xxxx.service.DealService;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xxxx.entity.Theme.Feeding_10B_People;

public class InsertTest {
    public static void main(String[] args) {
        SqlSession mysql = GetSqlSession.createSqlSession();
        try {
            Userdao userdao = mysql.getMapper(Userdao.class);
            InsertDao insertDao =mysql.getMapper(InsertDao.class);
            QueryDao queryDao = mysql.getMapper(QueryDao.class);


            /*Valuation vv = queryDao.queryLatestValuationByCID(18494191);
            Company cc = queryDao.queryCompanyByName("lakeba");
            cc.setC_name("llke");
            cc.setCid(); // generate a new cid for new company only
            insertDao.addCompany(cc); // no error, but no new entry in database
            vv.setVal_id();
            vv.setCid(cc.getCid()); // change
            insertDao.addValuation(vv);*/

            Deal d = queryDao.queryDealById(133361);
            DealForm df = new DealForm(d.getC_name(),d.getDeal_date(),d.getDeal_size(),d.getSeries_toString(),
                    d.getMSEQ_invest_amount(),d.getPost_value(),d.getVehicle_toString(),d.getCo_investor(),d.getFund_percentage(),
                    d.getOwn_percentage_toString(),d.getUpdate_date());
            Deal d2 = df.toDeal();

            DealService ds = new DealService();
            boolean bb = d2.equals(d);
            System.out.println(d.equals(d2));
//            String cc = d.getCo_investor();
//            System.out.println(cc);
//            UpdateDao updateDao = mysql.getMapper(UpdateDao.class);
//            Company c1 = queryDao.queryCompanyByName("lakeba");
//            c1.setYear_founded(2014);
//            updateDao.updateCompany(c1);
//            List<Integer> l = queryDao.queryCid();
//
//            Valuation[] vs = queryDao.queryValuationByCID(10179991);
//
//            LocalDate ll = LocalDate.now();
//            Valuation vadd = new Valuation(10179991,"lakeba", LocalDate.now(), 17000000.0, "new investment", 5000000.0,30.0);
//            vadd.setVal_id();
//            InsertDao insertDao = mysql.getMapper(InsertDao.class);
//            insertDao.addValuation(vadd);
//
//            int id = 0;
//            for (int i = 0; i < 100; i++){
//               id = CompanyID.get_id();
//            }
//            int aa = id;

            System.out.println("yes");
            /*            Map<String, Object> company = new HashMap<>();
            company.put("cid", "22220000");
            company.put("c_name", "hahaha2");
            company.put("theme", Theme.Exponential_Machines);
            insertDao.addCompanyByMap(company);*/

            mysql.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysql.close();
        }
    }
}
