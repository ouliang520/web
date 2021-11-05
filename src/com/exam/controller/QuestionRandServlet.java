package com.exam.controller;

import com.exam.dao.QuestionDao;
import com.exam.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao =new QuestionDao();
        //调用Dao对象随机从question表拿出4道题目
        List<Question> list =new ArrayList<>();
        list=dao.findRand();
        //将4道题目添加到request作为共享数据
        request.setAttribute("questionlist",list);
        //请求转发,申请调用exam.jsp将四道题目写入到响应体
        request.getRequestDispatcher("/exam.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
