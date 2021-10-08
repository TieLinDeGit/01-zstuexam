package com.zstu.Dao;

import com.zstu.entity.Users;
import com.zstu.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcUtil util =new JdbcUtil();

    public int add(Users user){
        String sql ="insert into users(userName,password,sex,email)"+"value(?,?,?,?)";
        PreparedStatement ps =util.creatStatement(sql);
        int result=0;
        try {
            ps.setString(1,user.getUserName());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            ps.setString(2,user.getPassword());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    public int add(Users user, HttpServletRequest request){
        String sql ="insert into users(userName,password,sex,email)"+"value(?,?,?,?)";
        PreparedStatement ps =util.creatStatement(sql,request);
        int result=0;
        try {
            ps.setString(1,user.getUserName());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            ps.setString(2,user.getPassword());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
    public List find(){
        String sql = "select * from users";
        ResultSet rs =null;
        PreparedStatement ps = util.creatStatement(sql);
        List userList = new ArrayList();
        try {
            rs=ps.executeQuery();
            while (rs.next()){
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users user = new Users(userId,userName,password,sex,email);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return userList;
    }
    public int delete(Users user){
        String sql = "delete from users where userId =?";
        int result =0;
        PreparedStatement ps =util.creatStatement(sql);
        try {
            ps.setInt(1,user.getUserId());
            result =ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;


    }
    public int login(Users user){
        String sql = "select count(*) from users where userName =? and password =?";
        ResultSet rs =null;
        PreparedStatement ps = util.creatStatement(sql);
        int count = 0;
        try {

            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            rs =ps.executeQuery();
            while (rs.next()){
                count = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return count;
    }
}
