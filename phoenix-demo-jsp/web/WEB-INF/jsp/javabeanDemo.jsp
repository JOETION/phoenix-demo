<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/11
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%--
1:post一个json数据到后台产生一个对象
2:form表单传递各个对象的属性值到后台封装成对象
3:前台直接生成对象，将对象放进某个域中，比如session，request等
4:后台直接将对象放进某个域中，前台取值
5:前台直接生成对象，直接用--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>javabeanDemo</title>
</head>
<body>
<%--两个案例：传javabean到服务器。从服务器传javabean到页面。form表单接收到数据转换为javabean--%>

<%--方法一：用內置的javabean語法--%>

<%--这里的类必须要能够找得到，必须是package.class--%>
<jsp:useBean id="person" class="com.snow.phoenix.demo.jsp.bean.PersonBean" scope="session"></jsp:useBean>
<%
    person.setSex("男");
    person.setName("方孝勇");
%>
<%
    out.println("通过内置Javabean输出：name= " + person.getName() + " sex= " + person.getSex());
%>
<%--方法二：用非内置的javabean语法--%>
<jsp:setProperty name="person" property="name" value="何金鑫"></jsp:setProperty>
<jsp:setProperty name="person" property="sex" value="男"></jsp:setProperty>
<p>通过非内置的Javabean取得 name=
    <jsp:getProperty name="person" property="name"></jsp:getProperty>
    sex=
    <jsp:getProperty name="person" property="sex"></jsp:getProperty>
</p>
</body>
</html>
