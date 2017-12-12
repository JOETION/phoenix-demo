<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session内置对象</title>
</head>
<body>
<b><p style="color: red">session内置对象</p></b>

<p>session常用API</p>

<p>getId()</p>
<%
    out.println("当前session的id为：" + session.getId() + "<br/>");
%>

<%--与request,application,page等的设置，得到API的作用域不同--%>
<p>setAttribute()</p>
<%
    session.setAttribute("name", "fangxiaoyong");
%>


<p>getAttribute()</p>
<%
    Object name = session.getAttribute("name");
    out.println("取得的属性name为：" + name.toString());
%>


<p>removeAttribute()</p>
<%
    out.println("删除name属性成功！" + "<br/>");
    session.removeAttribute("name");
%>

<p>setMaxInactiveInterval</p>
<%
    out.println("设置最大的发呆时间：<br/>");
    session.setMaxInactiveInterval(3000);
%>

<p>getMaxInactiveInterval</p>
<%
    out.println("取得最大的发呆时间：<br/>" + session.getMaxInactiveInterval());
%>

<p>invalidate</p>
<%
    out.println("销毁session对象<br/>");
    session.invalidate();

%>


</body>
</html>
