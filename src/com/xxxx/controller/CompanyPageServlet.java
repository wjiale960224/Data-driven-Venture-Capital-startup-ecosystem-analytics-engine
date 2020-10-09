package com.xxxx.controller;

import com.xxxx.dao.Userdao;
import com.xxxx.entity.Company;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/company_page")
public class CompanyPageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // hard coded query
        SqlSession session = GetSqlSession.createSqlSession();
        Userdao userdao = session.getMapper(Userdao.class);
        Company company = userdao.queryCompanyByName("Assignar");

        // output company info as JSON
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter(); // PrintWriter object that can return character data to the client
        JSONObject o = new JSONObject();
       // o.put("Company_Name", company.getCompany_name());
        o.put("Theme", company.getTheme());
        writer.write(o.toString());
    }
}
