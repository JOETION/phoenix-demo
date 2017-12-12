<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--也是可以存放属性键值对的，与request,page,session不同的是，作用域不同--%>
<head>
    <title>内置对象application</title>
</head>
<body>
<b><p>application常用API</p></b>

<p>setAttribute(String key,Object value)</p>
<%
    out.println("设置name属性值成功！<br/>");
    application.setAttribute("name", "hello");
%>

<p>getAttribute(String key)</p>
<%
    out.println("取得属性name的值为<br/>：" + application.getAttribute("name"));
%>

<p>removeAttribute()</p>
<%
    out.println("删除属性name成功！<br/>");
    application.removeAttribute("name");
%>

<%--得到程序的虚目录，即浏览器里面的根路径，若要得到程序的实际目录可以直接用getRealPath();--%>
<p>getContextPath()</p>
<%
    out.println("程序的虚拟路径为：<br/>" + application.getContextPath());
    out.println("程序的实际路径位：<br/>" + application.getRealPath("/"));
%>

</body>
</html>
