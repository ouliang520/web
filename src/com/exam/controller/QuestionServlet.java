package com.exam.controller;

import com.exam.dao.QuestionDao;
import com.exam.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao =new QuestionDao();
        Question question =null;
        //调用请求对象,读取请求头参数信息
        String title =request.getParameter("title");
        String optainA =request.getParameter("optainA");
        String optainB =request.getParameter("optainB");
        String optainC =request.getParameter("optainC");
        String optainD =request.getParameter("optainD");
        String answer =request.getParameter("answer");
        question =new Question(title,optainA,optainB,optainC,optainD,answer);
        //调用dao得到信息编辑成inser推送到数据库服务器并得到处理结果
        int result =dao.add(question);
        //将处理结果写入到请求作用域对象作为共享数据给jsp
        if(result==1) {
            request.setAttribute("info", "试题添加成功");
        }else{
            request.setAttribute("info", "试题添加失败");
        }
        //请求转发tomcat申请info,jsp将结果写入到响应体
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
