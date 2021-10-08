package com.zstu.controller;

import com.zstu.Dao.QuestionDao;
import com.zstu.entity.Questions;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class QuestionAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        //Integer questionId  =Integer.valueOf(request.getParameter("questionId"));
        title =request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        Questions question =new Questions(null,title,optionA,optionB,optionC,optionD,answer);
        QuestionDao dao =new QuestionDao();
        Date startdate =new Date();
        int result =dao.add(question,request);
        Date outdate = new Date();
        System.out.println("消耗时间"+(outdate.getTime()-startdate.getTime())+"毫秒");
        //PrintWriter out = null;
        //response.setContentType("text/html;charset=utf-8");
        //out = response.getWriter();
        if(result==1){
            //out.print("<font style='color:red;font-size:20'>试题信息注册成功</font>");
            request.setAttribute("key","试题添加成功");
        }else {
            //out.print("<font style='color:red;font-size:20'>试题信息注册失败</font>");
            request.setAttribute("key","试题添加失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }

}
