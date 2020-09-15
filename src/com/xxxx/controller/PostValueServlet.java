package com.xxxx.controller;

import com.google.gson.Gson;
import com.xxxx.entity.Company;
import com.xxxx.entity.CompanyList;
import com.xxxx.entity.msg.MessageModel;
import com.xxxx.service.ValueService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/company_postvalues")
public class PostValueServlet extends HttpServlet {
    private ValueService valueService = new ValueService();

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

        // a list of post-valuations string for each company
        List<String> post_list = valueService.getPostValue(cl);

        // TODO Format to front end?
        ServletOutputStream sos = resp.getOutputStream();
        if (post_list.get(0).equals("Input companies are not in portfolio."))  {
            sos.println(post_list.get(0));
        }
        else {
            for (String postvalues : post_list) {
                sos.println(postvalues);
            }
        }
    }
}
