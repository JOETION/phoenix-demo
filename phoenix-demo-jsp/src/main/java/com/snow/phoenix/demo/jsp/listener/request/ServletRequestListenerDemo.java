package com.snow.phoenix.demo.jsp.listener.request;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/12          FXY        Created
 **********************************************
 */


import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletRequestListenerDemo implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("请求销毁，远程服务器名字为："+servletRequestEvent.getServletRequest().getRemoteHost());
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("请求初始化，远程服务器名字为："+servletRequestEvent.getServletRequest().getRemoteHost());
    }
}
