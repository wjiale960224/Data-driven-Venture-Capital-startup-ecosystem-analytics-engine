package com.xxxx.controller;

import com.xxxx.service.MainpageService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mainpagedata")
public class MainpageServlet extends HttpServlet {
    MainpageService mainpageService = new MainpageService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String r = req.getParameter("refresh");

        if (r != null && r.equals("[]")) { // retrieve data from database
            ServletOutputStream sos = resp.getOutputStream();
            sos.print(mainpageService.getMainpageDataInfo(mainpageService.getCompanyNames(),mainpageService.getDealId()));
        }
    }
}
