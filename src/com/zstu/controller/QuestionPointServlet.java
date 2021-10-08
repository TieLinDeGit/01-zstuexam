package com.zstu.controller;

import com.zstu.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionPointServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession(false);
        List<Questions> questionsList =(List) session.getAttribute("questionrand");
        int point =0;
        for(Questions question :questionsList){
            if (question.getAnswer().equals(request.getParameter("answer_"+question.getQuestionId()))){
                point+=20;
            }
        }
        request.setAttribute("key","本次考试成绩="+point);
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
