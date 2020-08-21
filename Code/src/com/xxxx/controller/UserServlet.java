package com.xxxx.controller;

import com.xxxx.entity.User;
import com.xxxx.entity.msg.MessageModel;
import com.xxxx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        MessageModel messageModel = userService.userLogin(uname,upwd);
        if (messageModel.getCode() == 1) {
            req.getSession().setAttribute("user", messageModel.getObject());
            resp.sendRedirect("index.jsp");
        }
        else{
            req.setAttribute("messageModel",messageModel);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
