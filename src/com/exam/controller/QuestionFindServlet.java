package com.exam.controller;

import com.exam.dao.QuestionDao;
import com.exam.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuestionFindServlet", value = "/QuestionFindServlet")
public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//调用Dao推送查询命令得到所有试题
        List<Question> list =null;
        QuestionDao dao =new QuestionDao();
        list=dao.findAll();
        //将得到试题添加到请求作用域对象作为共享数据
        request.setAttribute("question",list);
        //请求转发想tomcat调用question.jsp将结果与html标签写入响应体中
        request.getRequestDispatcher("/questions.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
