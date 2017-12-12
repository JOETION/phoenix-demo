<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response内置对象</title>
</head>
<body>
<b><p style="color: red">response内置对象</p></b>

<p>response常用API</p>
<%
    response.setCharacterEncoding("UTF-8");
%>

<p>addCookie(Cookie cookie)</p>
<%
    try {
        out.println("添加Cookie：" + "<br/>");
        response.addCookie(new Cookie("hello", "world"));

    } catch (Exception e) {
        out.println("添加cookie发生了异常，原因：" + e);
    }

%>

<p>sendError(int code)</p>
<%
    response.sendError(200, "请求成功！");
%>

<p>sendRedirect()</p>
<button onclick="function forward(){<%response.sendRedirect("/JspDemo/request");%>};" value="点击重定向"/>

<p>sendContentType(String contentType)</p>
<%
response.setContentType("msword");
%>

</body>
</html>
