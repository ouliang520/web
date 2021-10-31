package com.exam.controller;

import com.exam.dao.UserDao;
import com.exam.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, password, sex, email;
        int result ;
        UserDao dao =new UserDao();

        PrintWriter out = null;
        //[调用请求对象]读取[请求头]参数信息
        Users user =new Users();
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        //[调用UserDao]将用户信息填充到INSSERT命令并接着JDBC规范发送到数据库服务器
        user = new Users(null,userName,password,sex,email);
        if(user != null) {
            result = dao.add(user);
            //[调用响应对象]将[处理结构]以二进制形式写入到响应体
            response.setContentType("text/html;charset=utf-8");
            out = response.getWriter();
            if (result == 1) {
                out.println("<font style='color:red;font-size:40'>用户信息注册成功</font>");
            } else {
                out.println("<font style='color':red;font-size:40'>用户信息注册失败</font>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
