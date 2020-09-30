package com.xxxx.test;

import com.xxxx.dao.QueryDao;
import com.xxxx.dao.UpdateDao;
import com.xxxx.dao.Userdao;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UpdateTest {
    public static void main(String[] args) {
        SqlSession mysql = GetSqlSession.createSqlSession();
        try {
            UpdateDao updateDao = mysql.getMapper(UpdateDao.class);
            updateDao.updateRunwayMonth();

            QueryDao queryDao = mysql.getMapper(QueryDao.class);
            List<Map<String, String>> result;
            result = queryDao.queryTheme();

            System.out.println(result);

            mysql.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysql.close();
        }
    }
}