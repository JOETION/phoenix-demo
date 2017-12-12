package com.snow.phoenix.demo.jsp.listener.application;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/12          FXY        Created
 **********************************************
 */


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听程序的启动与销毁
 */
@WebListener
public class ServletContextListenerDemo implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(this.getClass().getName() + "初始化成功，即程序启动成功");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(this.getClass().getName()+"销毁成功，即程序销毁成功");
    }
}
