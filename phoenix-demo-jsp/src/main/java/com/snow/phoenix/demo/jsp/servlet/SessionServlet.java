package com.snow.phoenix.demo.jsp.servlet;/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/6          FXY        Created
 **********************************************
 */


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/JspDemo/session")
public class SessionServlet extends HttpServlet {

    private static final String PATH = "../WEB-INF/jsp/sessionDemo.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PATH);
        if (null != requestDispatcher) {
            requestDispatcher.forward(req, resp);
        }
    }


}
