<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--el表达式所需要的库
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
  <title>测试界面</title>
</head>
<body>

<p style="font-size: large"><b><% out.println("欢迎来到Jsp测试界面");%></b></p>

<p style="color: red">第一章：基础语法</p>
<a href="/JspDemo/grammar">基础语法</a>
<br/>

<p style="color: red">第二章：内置对象测试</p>
<a href="/JspDemo/out">out内置对象</a><br>
<a href="/JspDemo/request">request内置对象</a><br>
<a href="/JspDemo/session">session内置对象</a><br>
<a href="/JspDemo/response">response内置对象</a><br>
<a href="/JspDemo/application">application内置对象</a><br>
<a href="/JspDemo/pageContext">pageContext内置对象</a><br>
<a href="/JspDemo/javabean">javabean案列</a>


</body>
</html>
