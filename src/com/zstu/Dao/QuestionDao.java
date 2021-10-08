package com.zstu.Dao;

import com.zstu.entity.Questions;
import com.zstu.entity.Users;
import com.zstu.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private JdbcUtil util =new JdbcUtil();

    public int add(Questions question){
        String sql ="insert into questions(title,optionA,optionB,optionC,optionD,answer)"+"value(?,?,?,?,?,?)";
        PreparedStatement ps =util.creatStatement(sql);
        int result=0;
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    public int add(Questions question, HttpServletRequest request){
        String sql ="insert into questions(title,optionA,optionB,optionC,optionD,answer)"+"value(?,?,?,?,?,?)";
        PreparedStatement ps =util.creatStatement(sql,request);
        int result=0;
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    public List find(){
        String sql = "select * from questions";
        ResultSet rs =null;
        PreparedStatement ps = util.creatStatement(sql);
        List questionList = new ArrayList();
        try {
            rs=ps.executeQuery();
            while (rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer= rs.getString("answer");
                Questions question =new Questions(questionId,title,optionA,optionB,optionC,optionD,answer);
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return questionList;
    }
    public List find(HttpServletRequest request){
        String sql = "select * from questions";
        ResultSet rs =null;
        PreparedStatement ps = util.creatStatement(sql,request);
        List questionList = new ArrayList();
        try {
            rs=ps.executeQuery();
            while (rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer= rs.getString("answer");
                Questions question =new Questions(questionId,title,optionA,optionB,optionC,optionD,answer);
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return questionList;
    }
    public int delete(Questions question){
        String sql = "delete from questions where questionId =?";
        int result =0;
        PreparedStatement ps =util.creatStatement(sql);
        try {
            ps.setInt(1,question.getQuestionId());
            result =ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;

    }
    public int delete(Questions question,HttpServletRequest request){
        String sql = "delete from questions where questionId =?";
        int result =0;
        PreparedStatement ps =util.creatStatement(sql,request);
        try {
            ps.setInt(1,question.getQuestionId());
            result =ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }
        return result;
    }

     public Questions select(Integer questionId,HttpServletRequest request){
         String sql = "select * from questions where questionId =?";
         ResultSet rs =null;
         PreparedStatement ps = util.creatStatement(sql,request);
         Questions question= null;
         try {
             ps.setInt(1,questionId);
             rs=ps.executeQuery();
             while (rs.next()) {
                 String title = rs.getString("title");
                 String optionA = rs.getString("optionA");
                 String optionB = rs.getString("optionB");
                 String optionC = rs.getString("optionC");
                 String optionD = rs.getString("optionD");
                 String answer = rs.getString("answer");
                 question = new Questions(questionId, title, optionA, optionB, optionC, optionD, answer);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             util.close(rs,request);
         }

         return question;
}
    public int update(Questions question, HttpServletRequest request){
        String sql ="update questions set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
        PreparedStatement ps =util.creatStatement(sql,request);
        int result=0;
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setInt(7,question.getQuestionId());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    public List findrand(HttpServletRequest request){
        String sql = "select * from questions ORDER BY RAND() LIMIT 0,5";
        ResultSet rs =null;
        PreparedStatement ps = util.creatStatement(sql,request);
        List questionList = new ArrayList();
        try {
            rs=ps.executeQuery();
            while (rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer= rs.getString("answer");
                Questions question =new Questions(questionId,title,optionA,optionB,optionC,optionD,answer);
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs,request);
        }
        return questionList;
    }
}