package com.zstu.Listener;


import com.zstu.util.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil util = new JdbcUtil();
        Map map=new HashMap();
        for(int i=0;i<10;i++){
            Connection con =util.getCon();
            System.out.println("创建"+con.toString());
            map.put(con,true);
        }
        ServletContext application=sce.getServletContext();
        application.setAttribute("key",map);
    }




    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application=sce.getServletContext();
        Map map =(Map)application.getAttribute("key");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            Connection con =(Connection) it.next();
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
