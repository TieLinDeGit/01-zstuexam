package com.zstu.controller;

import com.zstu.Dao.UserDao;
import com.zstu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName,password,sex,email;
        userName =request.getParameter("userName");
        password =request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        Users user =new Users(null,userName,password,sex,email);

        UserDao dao =new UserDao();
        Date startdate =new Date();
        int result =dao.add(user,request);
        Date outdate = new Date();
        System.out.println("消耗时间"+(outdate.getTime()-startdate.getTime())+"毫秒");
        PrintWriter out = null;
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if(result==1){
            out.print("<font style='color:red;font-size:20'>用户信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:20'>用户信息注册失败</font>");
        }
    }
}
