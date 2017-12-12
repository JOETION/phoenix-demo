package com.snow.phoenix.demo.jsp.listener.application;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/12          FXY        Created
 **********************************************
 */


import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * 由打印的日志可以看出，web服务器的启动顺序为：
 * (contextParam)->listener->filter->servlet->(spring)
 */
@WebListener
public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {

        System.out.println("application中放入属性：" + servletContextAttributeEvent.getName() + "= " + servletContextAttributeEvent.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("application中删除属性：" + servletContextAttributeEvent.getName() + "= " + servletContextAttributeEvent.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("application中替换属性：" + servletContextAttributeEvent.getName() + "= " + servletContextAttributeEvent.getValue());
    }
}
