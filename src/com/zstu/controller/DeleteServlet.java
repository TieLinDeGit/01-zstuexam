package com.zstu.controller;

import com.zstu.Dao.UserDao;
import com.zstu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao =new UserDao();
        Users user =new Users();
        Integer userId =Integer.valueOf(request.getParameter("userId"));
        user.setUserId(userId);
        int result = dao.delete(user);
        PrintWriter out = null;
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if(result==1){
            out.print("<font style='color:red;font-size:20'>用户信息删除成功</font>");
        }else {
            out.print("<font style='color:red;font-size:20'>用户信息删除失败</font>");
        }
    }

    }

