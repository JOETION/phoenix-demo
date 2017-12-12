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

/*
多个filter需要进行精确拦截的话，还是需要在web.xml中声明，
不过只需声明filter-mapping即可，web.xml中声明顺序即拦截顺序
参考网址：<br/>
<a>https://segmentfault.com/q/1010000003909250/a-1020000003909820</a>
 */
@WebFilter(urlPatterns = "/JspDemo/request", filterName = "filterOne")
public class FilterOne implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterOne init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterOne handling");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterOne handled");

    }

    public void destroy() {
        System.out.println("FilterOne Destroy");
    }
}
