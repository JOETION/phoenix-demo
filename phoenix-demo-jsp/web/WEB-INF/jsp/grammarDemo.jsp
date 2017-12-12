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
    <title>Jsp语法基础</title>
</head>
<body>
<b><p style="color: red">代码块</p></b>

<p>案列一：循环输出10个数</p>
<%
    for (int i = 0; i < 10; i++) {
        out.println(i);
    }
//    out.close(); //关闭输出流后，后面的out对象将不起作用
%>

<p>案列二：表达式输出变量的值（表达式中只能有一条语句，故不能加分号）</p>
<% int a = 10;
    int b = 10;
    int sum = a + b;
%>
<%="sum的值为：" + sum%>
</body>
</html>
