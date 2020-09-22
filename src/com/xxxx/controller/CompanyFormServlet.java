package com.xxxx.controller;

import com.google.gson.Gson;
import com.xxxx.entity.Company;
import com.xxxx.entity.CompanyList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/company_form")

public class CompanyFormServlet extends HttpServlet {
    String whole = "";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String refresh = req.getParameter("refresh");
        ServletOutputStream sos = resp.getOutputStream(); // Response
        sos.print("[{\"Company_Name\":\"av\",\"Theme\":\"1\"},{\"Company_Name\":\"v\",\"Theme\":\"2\"}]");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson g = new Gson();

        whole = req.getParameter("company");

        /*String[] companyAry = DealFormServlet.SplitStrings(company);// Get JSON format strings

        CompanyList cl = new CompanyList(); // Convert JSON strings to Java deal class
        for (String s : companyAry) {
            Company c = g.fromJson(s, Company.class);
            cl.arrayList.add(c);
        }*/

        ServletOutputStream sos = resp.getOutputStream(); // Response
        sos.print(whole);
    }
}
