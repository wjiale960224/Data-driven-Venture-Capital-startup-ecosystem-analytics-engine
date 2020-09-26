package com.xxxx.controller;
import com.google.gson.Gson;
import com.xxxx.entity.Deal;
import com.xxxx.entity.DealList;
import com.xxxx.service.DealService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


@WebServlet("/deal_form")
public class DealFormServlet extends HttpServlet {

    DealService dealService = new DealService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream sos = resp.getOutputStream();
        sos.print(dealService.getDealId().toString());
        /*Gson g = new Gson(); // JSON class

        String deal = req.getParameter("deal");
        String[] deals = SplitStrings(deal); // Get JSON format strings

        DealList dl = new DealList(); // Convert JSON strings to Java deal class
        for (String s : deals) {
            Deal d = g.fromJson(s, Deal.class);
            dl.arrayList.add(d);
        }

        ServletOutputStream sos = resp.getOutputStream(); // Response to front end
        sos.print("Deals name: " + dl.arrayList.get(0).getCompany().getCompany_name() + ", " + dl.arrayList.get(1).getCompany().getCompany_name());*/
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




