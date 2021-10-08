package com.zstu.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

public class JdbcUtil{
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    final String URL="jdbc:mysql://localhost:3306/zstu-exam";
    final String USERNAME="root";
    final String PASSWORD="333";
    PreparedStatement ps =null;
    Connection con =null;

    public Connection getCon(){
        try {
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public Connection getCon(HttpServletRequest req){
        ServletContext application =req.getServletContext();
        Map map =(Map) application.getAttribute("key");
        Iterator it =map.keySet().iterator();
        while (it.hasNext()){
             con =(Connection)it.next();
            Boolean bl=(Boolean) map.get(con);
            if(bl==true){
                map.put(con,false);
                break;
            }
        }
        return con;

    }

    public PreparedStatement creatStatement(String sql){
         con = getCon();
        try {
            ps=con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public PreparedStatement creatStatement(String sql,HttpServletRequest request){
         con = getCon(request);
        try {
            ps=con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public void close(){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(HttpServletRequest request){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
           ServletContext application =request.getServletContext();
           Map map=(Map) application.getAttribute("key");
           map.put(con,false);

    }
    public void close(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }
    public void close(ResultSet rs,HttpServletRequest request){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(request);
    }
}
