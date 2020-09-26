package com.xxxx.test;

import com.xxxx.dao.Userdao;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class UpdateTest {
    public static void main(String[] args) {
        SqlSession mysql = GetSqlSession.createSqlSession();
        try {
            Userdao userdao = mysql.getMapper(Userdao.class);
            userdao.updateRunwayMonth();

            mysql.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysql.close();
        }
    }
}