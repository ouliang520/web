package com.exam.controller;

import com.exam.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuestionDeleteServlet", value = "/QuestionDeleteServlet")
public class QuestionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
      String title=  request.getParameter("title");
        PrintWriter out =response.getWriter();
        QuestionDao dao = new QuestionDao();
        int i =0;
       i = dao.delete(title);

        out=response.getWriter();

        if (i==1){
            out.print("<font style='color:red;font-size:40'>删除成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40'>删除失败</font>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
