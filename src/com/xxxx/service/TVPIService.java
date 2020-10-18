package com.xxxx.service;

import java.sql.*;
import java.util.Date;

public class TVPIService {
    public void executeGetTVPI() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        CallableStatement call = null;
        ResultSet res = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://msvc-database.ctmfp85b3w3e.ap-southeast-2.rds.amazonaws.com:3306/msvc?serverTimezone=UTC&useSSL=false&characterEcoding=UTF-8";
        String username = "admin";
        String password = "msvc2020";
        conn = DriverManager.getConnection(url, username, password);

        call = conn.prepareCall("{CALL getTVPI(?)}");
        Date nDate = new Date();
        System.out.println(nDate);
        java.sql.Date sDate = new java.sql.Date(nDate.getTime());
        System.out.println(sDate.toString());
        call.setDate("date", sDate);

        call.executeQuery();
        System.out.println("Procedure Execute Ready.");
    }
}
