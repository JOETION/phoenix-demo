<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request内置对象</title>
</head>
<body>
<b><p style="color: red">request内置对象</p></b>

<p>request常用API</p>

<p>setCharacterEncoding(String code)</p>
<%request.setCharacterEncoding("UTF-8");%>

<p>setAttribute(String key,Object value)</p>
<%
    request.setAttribute("name", "方孝勇");
    request.setAttribute("names", new String[]{"方", "孝", "勇"});
%>

<form action="/JspDemo/request" method="get">
    <input type="text" name="name" value="客户端上传的单个参数">

    <p>请输入名字：<input type="checkbox" name="names"></p>

    <p>参数一：<input type="checkbox" name="names" value="客户端上传的多个参数二"></p>

    <p>参数二：<input type="checkbox" name="names" value="客户端上传的多个参数三"></p>

    <p><input type="submit" value="提交"></p>
</form>
<%--用于服务器取得客户端传上来的表单里面的数据--%>
<p>getParameter(String name)</p>
<%="请求的name属性是：" + request.getParameter("name")%>

<p>getParameterValues(String name)</p>
<%="请求的name属性数组是：" + request.getParameterValues("names")%>

<p>getProtocol()</p>
<%="客户端请求用的协议是：" + request.getProtocol()%>

<p>getRemoteAddr()</p>
<%="客户端远程地址是：" + request.getRemoteAddr()%>

<p>getRemoteHost()</p>
<%="客户端主机是：" + request.getRemoteHost()%>

<p>getServerName()</p>
<%="接收该请求的服务器地址是：" + request.getServerName()%>

<p>getServerPort()</p>
<%="接收该请求的服务器端口是：" + request.getServerPort()%>

<p>getRealPath()</p>
<%="虚拟路径的真实路径是：" + request.getRealPath("/JspDemo/grammar")%>

<%--用于服务器取得服务器上的属性值--%>
<p>getAttribute(String key)</p>
<%
    out.println("name的属性值为：" + request.getAttribute("name") + "<br/>");
    out.println("names的属性值为：" + request.getAttribute("names").toString() + "<br/>");
%>

<p>removeAttribute(String name)</p>
<%
    request.removeAttribute("name");
    request.removeAttribute("names");
    out.println("<br/>");
    out.println("删除属性成功！");
%>

</body>
</html>
