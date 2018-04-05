<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="/struts-tags" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<h2>Hello World!</h2>

<form action="login">
    <br/> 姓名<input type="text" name="name"> <br/> 年龄<input
        type="text" name="age"> <input type="submit" value="提交">
</form>

<div>
    <p>服务器返回结果为：</p>
    <c:property value="result"/>
</div>


</body>
</html>