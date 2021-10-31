package com.exam.util;
//工具包
import java.sql.*;

public class JdbcUtil {
     final String URL ="jdbc:mysql://127.0.0.1:3306/exam";
     final String USERNAME ="root";
     final String PASSWORD="1234";
     PreparedStatement ps =null;
     Connection con =null;

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
