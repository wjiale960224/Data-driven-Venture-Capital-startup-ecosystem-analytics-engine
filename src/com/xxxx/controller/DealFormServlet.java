package com.xxxx.controller;
import com.xxxx.service.DealService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deal_form")
public class DealFormServlet extends HttpServlet {
    DealService dealService = new DealService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String r = req.getParameter("refresh");
        String d = req.getParameter("deal");

        if (r != null && r.equals("[]")) {
            ServletOutputStream sos = resp.getOutputStream();
            sos.print(dealService.getDealInfo(dealService.getDealId()));
        } else {
            d = "{\"deal\": " + d + "}";
            dealService.updateDealInfo(d);
        }
    }
}




