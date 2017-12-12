package com.snow.phoenix.demo.jsp.listener.session;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/12          FXY        Created
 **********************************************
 */


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class HttpSessionAtrributeListenerDemo implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("sessionId="+httpSessionBindingEvent.getSession().getId()+"的session中放入属性："+httpSessionBindingEvent.getName()+"= "+httpSessionBindingEvent.getValue()+httpSessionBindingEvent);
    }

    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("sessionId="+httpSessionBindingEvent.getSession().getId()+"的session中删除属性："+httpSessionBindingEvent.getName()+"= "+httpSessionBindingEvent.getValue()+httpSessionBindingEvent);
    }

    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("sessionId="+httpSessionBindingEvent.getSession().getId()+"的session中替换属性："+httpSessionBindingEvent.getName()+"= "+httpSessionBindingEvent.getValue()+httpSessionBindingEvent);
    }
}
