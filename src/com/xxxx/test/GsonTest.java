package com.xxxx.test;

import com.google.gson.Gson;
import com.xxxx.dao.InsertDao;
import com.xxxx.entity.Company;
import com.xxxx.entity.Theme;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

public class GsonTest {

    public static void main(String[] args) {
        Gson gson = new Gson();
        String cl = "{\"company\": [{\"c_name\": \"company1\", \"theme\": \"Space_Transport\"}, {\"c_name\": \"company2\", \"theme\": \"Exponential_Machines\"}]}";
        JSONObject jsonObject = new JSONObject(cl);
        JSONArray jsonArray = jsonObject.getJSONArray("company");

        int l = jsonArray.length();
        SqlSession mysql = GetSqlSession.createSqlSession();
        try {
            InsertDao insertDao =mysql.getMapper(InsertDao.class);
            for (int i = 0; i < l; i++) {
                Company company = gson.fromJson(jsonArray.getJSONObject(i).toString(), Company.class);
                company.setCid();
                System.out.println(company.getCid());
                System.out.println(company.getC_name());
                System.out.println(company.getTheme());
                insertDao.addCompany(company);
            }
            mysql.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysql.close();
        }
    }
}
