package com.zstu.controller;

import com.zstu.Dao.QuestionDao;
import com.zstu.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questions =new QuestionDao();
        HttpSession session =request.getSession(false);
        List<Questions> questionlist=questions.findrand(request);
        session.setAttribute("questionrand",questionlist);
        request.getRequestDispatcher("/questionrand.jsp").forward(request,response);
    }
}
