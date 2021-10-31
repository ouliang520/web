package com.exam.controller;

import com.exam.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserDeleteServlet", value = "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao =new UserDao();
        PrintWriter out =null;
        //调用请求对象,读取请求头的参数
        String userId;
        userId =request.getParameter("userId");
        response.setContentType("text/html;charset=utf-8");
        //调用dao将参数添加到delete发动到数据库
        int result = dao.delete(userId);
        //响应体发回
        out=response.getWriter();

        if (result==1){
            out.print("<font style='color:red;font-size:40'>删除成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40'>删除失败</font>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
