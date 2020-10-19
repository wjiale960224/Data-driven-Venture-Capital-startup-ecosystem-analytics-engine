package com.xxxx.controller;

import com.xxxx.service.CompanypageService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/companypageinfo")
public class CompanyPageInfoServlet extends HttpServlet {
    CompanypageService companypageService = new CompanypageService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String r = req.getParameter("refresh");

        if (r != null && r.equals("[]")) { // retrieve data from database
            ServletOutputStream sos = resp.getOutputStream();
            sos.print(companypageService.getCompanypageDataInfo(companypageService.getCompanyNames(),companypageService.getDealId()));
        }
    }
}
