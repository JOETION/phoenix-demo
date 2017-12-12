<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/6
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>config内置对象之pageContext</title>
</head>
<body>

<%--application的子类（application为ServletContext的实例）--%>
<b><p style="color: red">pageContext常用API</p></b>

<p>getOut()</p>
<%
    pageContext.getOut().println("利用pageContext输出的信息");
%>

<P>getSession()</P>
<%
    out.println("session编号为:" + pageContext.getSession().getId());
%>

<%--page对象是Object的实例，即当前jsp页面本身--%>
<P>getPage()</P>
<%
    out.println("page对象是否为空：" + pageContext.getPage() == null);
%>


<p>getRequest()</p>
<%
    out.println("pageContext获取的request里面的信息:" + pageContext.getRequest().getRemoteAddr());
%>

<%--可调用的方法都是可以重写的方法--%>
<p>getResponse()</p>
<%
    out.println("pageContext获取的response里面的信息：" + pageContext.getResponse().getCharacterEncoding());
%>

<p>getException()</p>
<%
    if (pageContext.getException() != null)
        out.println("pageContext获取的exception里面的信息：" + pageContext.getException().getMessage());
%>

<p>getServletContext()</p>
<%
    out.println("pageContext获取到application里面的信息：" + pageContext.getServletContext().getServerInfo());
%>

<P>set/get/remove/findAttribute()</P>
<%
    out.println("pageContext查找属性值name为：" + pageContext.findAttribute("name"));
%>

<p>forward()</p>
<%--
<%
    pageContext.forward("/JspDemo/request");
%>
--%>

<P>include()</P>
<%--<%
    pageContext.include("./requestDemo.jps");
%>--%>

<p>release()</p>
<%--
<%
    out.println("释放pageContext的资源成功！");
    pageContext.release();
%>
--%>

<p></p>
</body>
</html>
