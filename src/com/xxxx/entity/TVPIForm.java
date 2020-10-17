package com.xxxx.entity;

import java.sql.*;

public class TVPIForm {
    String date;
    Integer TVPI;
    Integer mseq_invest_to_date;
    Double cumu_post_value;
    Double cumu_acquire_percent;

    public TVPIForm() { }

    public TVPIForm(String date, Integer TVPI, Integer mseq_invest_to_date, Double cumu_post_value, Double cumu_acquire_percent) {
        this.date = date;
        this.TVPI = TVPI;
        this.mseq_invest_to_date = mseq_invest_to_date;
        this.cumu_post_value = cumu_post_value;
        this.cumu_acquire_percent = cumu_acquire_percent;
    }

    public void executeGetTVPI() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        CallableStatement call  = null;
        ResultSet res = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://msvc-database.ctmfp85b3w3e.ap-southeast-2.rds.amazonaws.com:3306/msvc?serverTimezone=UTC&useSSL=false&characterEcoding=UTF-8";
        String username = "admin";
        String password = "msvc2020";
        conn = DriverManager.getConnection(url, username, password);

        call = conn.prepareCall("{CALL getTVPI(?)}");
        call.setString(1, date);

        call.executeQuery();
        System.out.println("Procedure Execute Ready.");
    }

    public void setDate(String date) {this.date = date;}

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TVPIForm tf = new TVPIForm();
        tf.setDate("2019-10-01");
        tf.executeGetTVPI();
    }
}
