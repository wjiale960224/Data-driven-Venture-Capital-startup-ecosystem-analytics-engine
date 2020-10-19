package com.xxxx.entity;

import com.xxxx.dao.QueryDao;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ValuationID {
    //private static AtomicInteger atomicInteger = new AtomicInteger();

    public static Integer get_id() {
        SqlSession mysql = GetSqlSession.createSqlSession();
        Random r = new Random();
        int newId = r.nextInt(10000000)+10000000;
        QueryDao queryDao = mysql.getMapper(QueryDao.class);
        List<Integer> cids = queryDao.queryCid();
        while (cids.contains(newId)) {
            newId = r.nextInt(10000000)+10000000;
        }
        mysql.close();
        return newId;
    }
}
