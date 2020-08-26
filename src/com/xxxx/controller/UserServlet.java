package com.xxxx.controller;

import com.xxxx.dao.Userdao;
import com.xxxx.entity.User;
import com.xxxx.entity.msg.MessageModel;
import com.xxxx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接受请求（调用service层， 返回结果）
 * 响应结果
 */

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_name = req.getParameter("user_name");
        String user_pwd = req.getParameter("user_pwd");
        MessageModel messageModel = userService.userLogin(user_name,user_pwd);
        if (messageModel.getCode() == 1) {
            messageModel.setMsg("");
            req.getSession().setAttribute("user", messageModel.getObject());
            resp.sendRedirect("index.jsp");
        }
        else{
            /*int num = userService.userInsert(user_name,user_pwd);*/
            req.setAttribute("messageModel",messageModel);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
