package com.exam.controller;

import com.exam.dao.UserDao;
import com.exam.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserFindServlet", value = "/UserFindServlet")
public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out =null;
        //调用[DAO]将查询命令推送到数据库服务器上,得到所有用户信息[List]
        UserDao dao =new UserDao();

        List<Users> list =dao.findAll();
        //调用响应对象 将用户信息结合<table>标签命令以二进制格式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out =response.getWriter();
        out.print("<table border=2 align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>操作</td>");
        out.print("</tr>");
        for (int i =0;i<list.size();i++){
            out.print("<tr>");
            out.print("<td>"+ list.get(i).getUserId() +"</td>");
            out.print("<td>"+ list.get(i).getUserName() +"</td>");
            out.print("<td>******</td>");//密码不可见
            out.print("<td>"+ list.get(i).getSex() +"</td>");
            out.print("<td>"+ list.get(i).getEmail() +"</td>");
            out.print("<td><a href='userdelete?userId="+list.get(i).getUserId()+"'>删除用户</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
