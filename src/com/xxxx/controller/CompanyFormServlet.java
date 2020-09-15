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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson g = new Gson();

        String company = req.getParameter("company");
        String[] companyAry = DealFormServlet.SplitStrings(company);// Get JSON format strings

        CompanyList cl = new CompanyList(); // Convert JSON strings to Java deal class
        for (String s : companyAry) {
            Company c = g.fromJson(s, Company.class);
            cl.arrayList.add(c);
        }

        ServletOutputStream sos = resp.getOutputStream(); // Response
        sos.print("Companies name: " + cl.arrayList.get(0).getCompany_name() + ", " + cl.arrayList.get(1).getCompany_name());
    }
}
