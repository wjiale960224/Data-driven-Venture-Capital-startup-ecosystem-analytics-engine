package com.xxxx.test;

import com.xxxx.dao.Userdao;
import com.xxxx.entity.User;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args) {
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        User user = userdao.queryUserByname("admin");
        System.out.println();

    }
}
