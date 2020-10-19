package com.xxxx.dao;

import java.sql.*;

public class BaseDao {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public Connection getConn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String url="jdbc:mysql://msvc-database.ctmfp85b3w3e.ap-southeast-2.rds.amazonaws.com:3306/msvc?serverTimezone=UTC&useSSL=false&characterEcoding=UTF-8";
        try {
            con= DriverManager.getConnection(url,"admin","msvc2020");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
    public void closeAll(){

        try {
            if(rs!=null)
                rs.close();

            if(pst!=null)
                pst.close();
            if(con!=null)
                con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        BaseDao baseDao = new BaseDao();
        Connection conn=baseDao.getConn();
        if(conn!=null)
            System.out.println("yes");
        else System.out.println("no");
    }

    public int del(int id) {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        int result=0;
        con=getConn();
        String sql="delete from xxxxxxxxxxxxxxxxxx";
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            result=pst.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            closeAll();
        }
        return result;
    }

}
