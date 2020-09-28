package com.xxxx.test;

import com.google.gson.Gson;
import com.xxxx.entity.Company;
import org.json.JSONArray;
import org.json.JSONObject;

public class GsonTest {

    public static void main(String[] args) {
        Gson gson = new Gson();
        String cl = "{\"company\": [{\"c_name\": \"company1\", \"theme\": \"Space_Transport\"}, {\"c_name\": \"company2\", \"theme\": \"Exponential_Machines\"}]}";
        JSONObject jsonObject = new JSONObject(cl);
        JSONArray jsonArray = jsonObject.getJSONArray("company");

        int l = jsonArray.length();
        for (int i = 0; i < l; i++) {
            Company company = gson.fromJson(jsonArray.getJSONObject(i).toString(), Company.class);
            System.out.println(company.getCompany_name());
            System.out.println(company.getTheme());
        }
    }
}
