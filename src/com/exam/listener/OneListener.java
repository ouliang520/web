package com.exam.listener;

import com.exam.dao.UserDao;
import com.exam.util.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {
    @Override
    //在tomcat启动的时候,预先创建20个connection,在userDao.add方法执行时候
    //将实现创建好connection交给add方法
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil util =new JdbcUtil();
        Map map =new HashMap();
        for (int i =1;i<=20;i++){
            Connection con =util.getCon();
            System.out.println("服务器启动时候,创建connection"+con);
            map.put(con,true);//true表示这个通道处于空闲钻沟通,false表示通道处于被使用
        }
        //为了在Http服务器运行期间,一直都可以使用这个connection,将connection保存到全局作用域对象中
        //使用ServletContextEvent sce中的方法获取全局作用域对象
        ServletContext application =sce.getServletContext();
        application.setAttribute("key1",map);
    }//作为局部变量map被销毁
    //在http服务器关闭的时候,将全局作用域对象20个Connection销毁

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
            ServletContext application =sce.getServletContext();
            Map map= (Map) application.getAttribute("key1");
            Iterator it = map.keySet().iterator();
            while(it.hasNext()){
                Connection con=(Connection) it.next();
                if (con!=null){
                    System.out.println(con+"被销毁");

                }
            }
    }
}
