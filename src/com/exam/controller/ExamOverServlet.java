package com.exam.controller;

import com.exam.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ExamOverServlet", value = "/ExamOverServlet")
public class ExamOverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> list =new ArrayList();
        QuestionDao dao =new QuestionDao();
        int i =0;
        int grades =0;
        String name = (String) request.getSession().getAttribute("key");
    list=(List<String>) request.getSession().getAttribute("title");
        for (String title:list
             ) {
            i=dao.contrash(title,request.getParameter("answer"+i+""));
            if(i==1){
                grades +=i*25;
            }

        }
        int result=0;
        result = dao.gradesAdd(name, grades);
        if(result==1){
            request.setAttribute("grades","试卷提交成功,请到系统查询自己的成绩");
            request.getRequestDispatcher("/exan_error.jsp").forward(request,response);
        }else{
            request.setAttribute("grades","试卷提交失败,请重新考试");
            request.getRequestDispatcher("/exan_error.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
