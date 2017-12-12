package com.snow.phoenix.demo.jsp.filter;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/12          FXY        Created
 **********************************************
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 多个filter是按递归的形式传递的
 */
@WebFilter(urlPatterns = "/JspDemo/request",filterName = "filterTwo")
public class FilterTwo implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterTwo init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterTwo handling");
        filterChain.doFilter(servletRequest, servletResponse); //递归
        System.out.println("FilterTwo handled");

    }

    public void destroy() {
        System.out.println("FilterTwo Destroy");
    }
}
