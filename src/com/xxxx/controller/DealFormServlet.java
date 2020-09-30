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

        if (r.equals("[]")) {
            ServletOutputStream sos = resp.getOutputStream();
            sos.print(dealService.getDealInfo(dealService.getDealId()));
        } else {
            d = "{\"deal\": " + d + "}";
            dealService.updateDealInfo(d);
        }
    }


    // Split JSON Array string to JSON strings.
    public static String[] SplitStrings(String s) {
        String[] ss = s.substring(1,s.length()-1).split("},\\{"); // Get rid of "[]" in "[{},{}]", and split deals
        for (int i = 0; i < ss.length; i++){ // Reconstruct string format to json format
            if (i == 0) {
                ss[i] += "}";
            }else if (i == ss.length-1){
                ss[i] = "{" + ss[i];
            }else {
                ss[i] = "{" + ss[i] + "}";
            };
        }
        return ss;
    }
}




