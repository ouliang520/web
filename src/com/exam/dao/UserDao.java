package com.exam.dao;

import com.exam.util.JdbcUtil;
import com.exam.entity.Users;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserDao {
    private JdbcUtil util = new JdbcUtil();

    //用户的注册
    public int add(Users user) {
        String sql = "insert into users(userName,password,sex,email)" + "values(?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
    //add重载
    public int add(Users user, HttpServletRequest request) {
        String sql = "insert into users(userName,password,sex,email)" + "values(?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql,request);
        int result = 0;
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(request);
        }
        return result;
    }

    //查询所有用户信息
    public List<Users> findAll() {
        String sql = "select * from users";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List<Users> list = new ArrayList<>();
        try {
            rs = ps.executeQuery();//查询获得结果集
            while (rs.next()) {
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users user = new Users(userId, userName, password, sex, email);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
return list;
    }
    public int delete(String userId){
        String sql ="delete from users where userId=?";
        PreparedStatement ps =util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1, Integer.valueOf(userId));
            result = ps.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    public int login(String userName,String password){
        int i =0;
        ResultSet rs=null;
        String sql ="select count(*) from users where userName=? and password=?";
        PreparedStatement ps =util.createStatement(sql);
        try{
            ps.setString(1,userName);
            ps.setString(2,password);
           rs= ps.executeQuery();
           while (rs.next()){
               i=rs.getInt("count(*)");
           }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return i;
    }
}

