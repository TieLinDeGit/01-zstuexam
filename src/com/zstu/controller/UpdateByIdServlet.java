package com.zstu.controller;

import com.zstu.Dao.QuestionDao;
import com.zstu.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao =new QuestionDao();
        Integer questionId =Integer.valueOf(request.getParameter("questionId"));
        Questions question =dao.select(questionId,request);
        request.setAttribute("questionById",question);
        request.getRequestDispatcher("/questionById.jsp").forward(request,response);
    }
}
