package com.exam.util;
//工具包
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JdbcUtil {
     final String URL ="jdbc:mysql://127.0.0.1:3306/exam";
     final String USERNAME ="root";
     final String PASSWORD="1234";
     PreparedStatement ps =null;
     Connection con =null;

     //------------通过全局作用域对象得到Connetion---------start
     public Connection getCon(HttpServletRequest request) {
        //通过请求对象,得到全局作用域对象
         ServletContext application =  request.getServletContext();
         //从全局作用域对象得到map
         Map map =(Map) application.getAttribute("key1");
         //从map得到一个处于空闲状态的Connection
         Iterator it =map.keySet().iterator();
         while (it.hasNext()){
             con=(Connection) it.next();
             boolean flag= (boolean) map.get(con);
             if (flag==true){
                 map.put(con,false);
                 break;
             }
         }
         return con;

     }
    public  PreparedStatement createStatement(String sql,HttpServletRequest request){
        try {
            ps =getCon(request).prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    //------------通过全局作用域对象得到Connetion---------start


    //将jar包中的driver实现类加载到JVN中
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //封装链接通道创建细节
    public Connection getCon(){
        try {
            con= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
    //封装Driver创建细节
    public  PreparedStatement createStatement(String sql){
        try {
            ps =getCon().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    //ps和con销毁
    public  void close(){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //close重载
    public  void close(HttpServletRequest request){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        ServletContext application =request.getServletContext();
        Map map= (Map) application.getAttribute("key1");
        map.put(con,true);

    }
    //select ps,con,rs
    public  void close(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
