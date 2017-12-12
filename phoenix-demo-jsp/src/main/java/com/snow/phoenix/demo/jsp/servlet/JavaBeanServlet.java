package com.snow.phoenix.demo.jsp.servlet;/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/11          FXY        Created
 **********************************************
 */


import com.snow.phoenix.demo.jsp.bean.PersonBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//serizable 序列号可以直接看其他类
//idea中重写了的方法，都是加粗了的，未重写的方法都是未加粗的
@WebServlet(urlPatterns = "/JspDemo/javabean", initParams = {@WebInitParam(name = "fang", value = "ok")})
public class JavaBeanServlet extends HttpServlet {

    private static final String PATH = "../WEB-INF/jsp/javabeanDemo.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PATH);
        PersonBean person = (PersonBean) req.getSession().getAttribute("person");
        System.out.println("initParams="+this.getInitParameter("fang"));
        if (person != null)
            System.out.println(person.toString());
        else
            System.out.println("person为空");
        if (null != requestDispatcher) {

            //sendRedirect 后面的代码会执行，地址栏会发生变化，属于两个请求
            //resp.sendRedirect("/JspDemo/request");


            //设置5秒钟刷新一次页面
            resp.setHeader("Refresh", "5");


            //forward被称为服务器的跳转，后面的代码不会被执行,地址栏不会变化，只有一个请求，可用于不同页面之间传递信息
            requestDispatcher.forward(req, resp);
        }

    }
}
