package com.zstu.controller;

import com.zstu.Dao.UserDao;
import com.zstu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName, password;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        Users user = new Users(null, userName, password, null, null);
        UserDao dao = new UserDao();
        int count = dao.login(user);
        PrintWriter out;
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (count==1) {
            HttpSession session =request.getSession();
            out.print("<tr>");
            out.print("<td>登录成功</td>");
            out.print("<td><a href='/zstuexam/index.html'>点击跳转</a></td>");
            out.print("</tr>");

        } else {
            out.print("<tr>");
            out.print("<td>登录失败/td>");
            out.print("<td><a href='/zstuexam/login.html'>点击跳转</a></td>");
            out.print("</tr>");

        }
    }
}
