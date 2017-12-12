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

//这里注解是数组
@WebFilter(urlPatterns = {"/JspDemo/request","/JspDemo/out"},filterName = "filterThree")
public class FilterThree implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterThree init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterThree handling");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterThree handled");

    }

    public void destroy() {
        System.out.println("FilterThree Destroy");
    }
}
