<%--
  ~  Copyright 2016-2020 the original author or authors.
  ~
  ~   Licensed under the Apache License, Version 2.0 (the "License");
  ~   you may not use this file except in compliance with the License.
  ~   You may obtain a copy of the License at
  ~
  ~       QQ:1322874562  PHONE:13882946572
  ~
  ~   Unless required by applicable law or agreed to in writing, software
  ~   distributed under the License is distributed on an "AS IS" BASIS,
  ~   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~   See the License for the specific language governing permissions and
  ~   limitations under the License.
  --%>

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