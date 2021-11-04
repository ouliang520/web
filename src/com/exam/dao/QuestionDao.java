package com.exam.dao;

import com.exam.entity.Question;
import com.exam.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        }finally {
            util.close();
        }

        return i;
    }
    public List findAll(){
        String sql ="select * from question";
        ResultSet rs=null;
        List<Question> list =new ArrayList<>();
       PreparedStatement ps=util.createStatement(sql);
        try {
           rs= ps.executeQuery();
           while(rs.next()){
               String title =rs.getNString("title");
               String onptainA =rs.getNString("optainA");
               String onptainB =rs.getNString("optainB");
               String onptainC =rs.getNString("optainC");
               String onptainD =rs.getNString("optainD");
               String answer =rs.getNString("answer");
               Question question =new Question(title,onptainA,onptainB,onptainC,onptainD,answer);
               list.add(question);
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }

        return list;
    }
}
