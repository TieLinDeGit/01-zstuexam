package com.zstu.controller;

import com.zstu.Dao.QuestionDao;
import com.zstu.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questions =new QuestionDao();
        List<Questions> questionlist=questions.find(request);
        request.setAttribute("questionsfind",questionlist);
        request.getRequestDispatcher("/questionsfind.jsp").forward(request,response);
    }
}
