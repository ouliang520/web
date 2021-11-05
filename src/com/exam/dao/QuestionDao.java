package com.exam.dao;

import com.exam.entity.Question;
import com.exam.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionDao {
    JdbcUtil util = new JdbcUtil();

    public int add(Question question) {
        String sql = "insert into question(title,optainA,optainB,optainC,optainD,answer) values(?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int i = 0;
        try {
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }

        return i;
    }

    public List findAll() {
        String sql = "select * from question";
        ResultSet rs = null;
        List<Question> list = new ArrayList<>();
        PreparedStatement ps = util.createStatement(sql);
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getNString("title");
                String onptainA = rs.getNString("optainA");
                String onptainB = rs.getNString("optainB");
                String onptainC = rs.getNString("optainC");
                String onptainD = rs.getNString("optainD");
                String answer = rs.getNString("answer");
                Question question = new Question(title, onptainA, onptainB, onptainC, onptainD, answer);
                list.add(question);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }

        return list;
    }

    public int delete(String title) {
        String sql = "delete from question where title=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, title);
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public List<Question> findRand() {
        String sql = "select * from question order by rand() limit 0,4";
        ResultSet rs = null;
        List<Question> list = new ArrayList<>();
        PreparedStatement ps = util.createStatement(sql);
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getNString("title");
                String onptainA = rs.getNString("optainA");
                String onptainB = rs.getNString("optainB");
                String onptainC = rs.getNString("optainC");
                String onptainD = rs.getNString("optainD");
                String answer = rs.getNString("answer");
                Question question = new Question(title, onptainA, onptainB, onptainC, onptainD, answer);
                list.add(question);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }

        return list;

    }

    public int contrash(String title, String optain) {
        int i = 0;
        ResultSet rs = null;
        String sql = "select * from question where title=? and answer=?";
        PreparedStatement ps = util.createStatement(sql);
        try {
            ps.setString(1, title);
            ps.setString(2, optain);
            rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return i;
    }

    public int gradesAdd(String name, int grades) {
        String sql = "INSERT INTO fraction(name,grades,time) VALUES(?,?,?)";
        int result=0;
        PreparedStatement ps = util.createStatement(sql);
        Date date =new Date();
        DateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time= f.format(date);
        try {
            ps.setString(1,name);
            ps.setInt(2,grades);
            ps.setString(3,time);
           result= ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }


        return result;
    }
    public List<exam> examfind(String name){
        String time;
        int greads;
        String sql ="SELECT * FROM fraction WHERE name =?";
        List<exam> list =new ArrayList<>();
        ResultSet rs=null;
        PreparedStatement ps=util.createStatement(sql);
        try {
            ps.setString(1,name);
            rs= ps.executeQuery();
            while (rs.next()){
               greads= rs.getInt("grades");
               time= rs.getString("time");
                exam exam =new exam(name,greads,time);
                list.add(exam);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally {
            util.close(rs);
        }
        return list;
    }
}
