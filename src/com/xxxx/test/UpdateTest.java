package com.xxxx.test;

import com.xxxx.dao.UpdateDao;
import com.xxxx.dao.Userdao;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class UpdateTest {
    public static void main(String[] args) {
        SqlSession mysql = GetSqlSession.createSqlSession();
        try {
            UpdateDao updateDao = mysql.getMapper(UpdateDao.class);
            updateDao.updateRunwayMonth();

            mysql.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysql.close();
        }
    }
}