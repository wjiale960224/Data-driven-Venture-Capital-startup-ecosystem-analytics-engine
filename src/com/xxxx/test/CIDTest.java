package com.xxxx.test;

import com.xxxx.dao.QueryDao;
import com.xxxx.entity.CompanyID;
import com.xxxx.entity.Valuation;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.Random;

public class CIDTest {
    public static void main(String[] args) {
//        int c = CompanyID.get_id();
//        Random r = new Random();
//        int next = r.nextInt(10000000)+10000000;
//        System.out.println(next);

        LocalDate ll = LocalDate.now();
        System.out.println(ll);
        SqlSession s = GetSqlSession.createSqlSession();
        QueryDao queryDao = s.getMapper(QueryDao.class);
        Valuation v = queryDao.queryLatestValuationByCID(18494191);
        System.out.println();
//        userdao.queryValuationByCID(company.getCid())
//        System.out.println(c);
    }
}
