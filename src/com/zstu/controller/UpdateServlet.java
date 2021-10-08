package com.zstu.controller;

import com.zstu.Dao.QuestionDao;
import com.zstu.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        Integer questionId  =Integer.valueOf(request.getParameter("questionId"));
        title =request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        Questions question =new Questions(questionId,title,optionA,optionB,optionC,optionD,answer);
        QuestionDao dao =new QuestionDao();
        int result =dao.update(question,request);
        if(result==1){
            request.setAttribute("key","试题更新成功");
        }else {
            request.setAttribute("key","试题更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}

