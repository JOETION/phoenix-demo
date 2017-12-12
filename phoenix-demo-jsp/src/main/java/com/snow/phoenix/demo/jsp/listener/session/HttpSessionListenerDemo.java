package com.snow.phoenix.demo.jsp.listener.session;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/12          FXY        Created
 **********************************************
 */


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class HttpSessionListenerDemo implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("一个session创建了，sessionId= "+httpSessionEvent.getSession().getId());
        httpSessionEvent.getSession().setMaxInactiveInterval(1000);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("一个session销毁了，sessionId= "+httpSessionEvent.getSession().getId());
    }
}
