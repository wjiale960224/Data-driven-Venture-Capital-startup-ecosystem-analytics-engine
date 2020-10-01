package com.xxxx.controller;

import com.xxxx.service.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
        String r = req.getParameter("refresh");

        if (r != null && r.equals("[]")) {
            ServletOutputStream sos = resp.getOutputStream();
            sos.print(companyService.getCompanyInfo(companyService.getCompanyNames()));
        } else { // frontend passes company data as an array, need to update info in database
            String c = req.getParameter("company");
            //c = "{\"company\": " + c + "}";
            System.out.println(c);
            companyService.updateCompanyInfo(c);
        }
    }
}
