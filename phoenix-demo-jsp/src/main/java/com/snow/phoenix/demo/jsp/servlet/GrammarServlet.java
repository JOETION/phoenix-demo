package com.snow.phoenix.demo.jsp.servlet;/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/4          FXY        Created
 **********************************************
 */


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//如果不用这个注解就需要在web.xml中配置servlet
@WebServlet(urlPatterns = "/JspDemo/grammar")
public class GrammarServlet extends HttpServlet {


    //由于编译后的字节码文件在WEB-INF下面，与jsp界面通路径，所以不是看与源代码的路径，而是看字节码的路径
    private static final String PATH = "../WEB-INF/jsp/grammarDemo.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        不可以用resp将请求重定向到某个文件，resp地址栏的地址会发生变化，res地址栏地址不会发生变化
//        resp.sendRedirect("http://www.baidu.com");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PATH);
        if (null != requestDispatcher) {
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
