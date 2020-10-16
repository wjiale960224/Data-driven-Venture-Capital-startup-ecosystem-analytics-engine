package com.xxxx.service;

import java.sql.*;

public class TVPIService {

    public int getTVPI() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://msvc-database.ctmfp85b3w3e.ap-southeast-2.rds.amazonaws.com:3306/msvc?serverTimezone=UTC&useSSL=false&characterEcoding=UTF-8";
            String username = "admin";
            String password = "msvc2020";
            String sql = "getTVPI";
            conn = DriverManager.getConnection(dbURL, username, password);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
