package com.xxxx.controller;

import com.google.gson.Gson;
import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.entity.CompanyList;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String refresh = req.getParameter("refresh");
        ServletOutputStream sos = resp.getOutputStream(); // Response
        //sos.print("[{\"Company_Name\":\"av\",\"Theme\":\"1\"},{\"Company_Name\":\"v\",\"Theme\":\"2\"}]");

        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        Company company = userdao.queryCompanyByName("Assignar");
        Company company2 = userdao.queryCompanyByName("Lumina Networks");
        sos.print("[{\"Company_Name\":\"" + company.getCompany_name() + "\",\"Theme\":\"" + company.getTheme() + "\"},{\"Company_Name\":\"" + company2.getCompany_name() + "\",\"Theme\":\"" + company2.getTheme() + "\"}]");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson g = new Gson();

        whole = req.getParameter("company");
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        Company company = userdao.queryCompanyByName("Assignar");

        // output copmany info as JSON, https://blog.csdn.net/qq_17775871/article/details/80766973
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter(); // PrintWriter object that can return character data to the client
        JSONObject o = new JSONObject();
        o.put("Company_Name", company.getCompany_name());
        o.put("Theme", company.getTheme());
        writer.write(o.toString());

        /*String[] companyAry = DealFormServlet.SplitStrings(company);// Get JSON format strings

        CompanyList cl = new CompanyList(); // Convert JSON strings to Java deal class
        for (String s : companyAry) {
            Company c = g.fromJson(s, Company.class);
            cl.arrayList.add(c);
        }*/

//        ServletOutputStream sos = resp.getOutputStream(); // Response
//        sos.print(whole);
    }
}
