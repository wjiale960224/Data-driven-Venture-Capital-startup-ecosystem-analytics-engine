package com.xxxx.controller;

import com.google.gson.Gson;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.CompanyList;
import com.xxxx.service.CompanyService;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/company_form")

public class CompanyFormServlet extends HttpServlet {
    String whole = "[]";
    CompanyService companyService = new CompanyService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c = req.getParameter("company");

        if (c == null) { // frontend does not pass any data, so retrieve info from database
            ServletOutputStream sos = resp.getOutputStream();
            sos.print(companyService.getCompanyInfo(companyService.getCompanyNames()));
        } else { // frontend passes company data as a list, need to update info in database
            companyService.updateCompanyInfo(c);
        }
    }
}
