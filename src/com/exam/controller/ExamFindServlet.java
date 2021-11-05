package com.exam.controller;

import com.exam.dao.QuestionDao;
import com.exam.dao.exam;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExamFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao =new QuestionDao();
        List<exam> list =new ArrayList<>();
        list = dao.examfind((String) request.getSession().getAttribute("key"));
        request.setAttribute("exam",list);
        System.out.println(list);
        request.getRequestDispatcher("/examfind.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
