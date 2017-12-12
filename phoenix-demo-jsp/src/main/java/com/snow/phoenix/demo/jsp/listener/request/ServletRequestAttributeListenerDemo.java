package com.snow.phoenix.demo.jsp.listener.request;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/12          FXY        Created
 **********************************************
 */


import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletRequestAttributeListenerDemo implements ServletRequestAttributeListener {
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request中放入属性："+servletRequestAttributeEvent.getName()+"= "+servletRequestAttributeEvent.getValue());
    }

    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request中删除属性："+servletRequestAttributeEvent.getName()+"= "+servletRequestAttributeEvent.getValue());
    }

    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request中替换属性："+servletRequestAttributeEvent.getName()+"= "+servletRequestAttributeEvent.getValue());
    }
}
