package com.exam.controller;

import com.exam.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao =new UserDao();
        PrintWriter out =response.getWriter();
        int i=0;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        i =dao.login(userName,password);
        System.out.println(i);
        if (i == 1) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("login_error.html");
        }

    }
}
