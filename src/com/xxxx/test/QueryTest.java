package com.xxxx.test;


import com.xxxx.dao.InsertDao;
import com.xxxx.dao.QueryDao;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Deal;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class QueryTest {
    public static void main(String[] args) {
        SqlSession mysql = GetSqlSession.createSqlSession();
        try {
            Userdao userdao = mysql.getMapper(Userdao.class);
            InsertDao insertDao = mysql.getMapper(InsertDao.class);
            QueryDao queryDao = mysql.getMapper(QueryDao.class);

            List<Deal> deals = queryDao.queryDeals();


            mysql.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysql.close();
        }
    }
}


