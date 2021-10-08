package com.zstu.controller;

import com.zstu.Dao.QuestionDao;
import com.zstu.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao =new QuestionDao();
        Questions questions =new Questions();
        Integer questionId =Integer.valueOf(request.getParameter("questionId"));
        questions.setQuestionId(questionId);
        int result = dao.delete(questions,request);
        PrintWriter out = null;
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if(result==1){
            out.print("<font style='color:red;font-size:20'>试题信息删除成功</font>");
        }else {
            out.print("<font style='color:red;font-size:20'>试题信息删除失败</font>");
        }
    }

    }

