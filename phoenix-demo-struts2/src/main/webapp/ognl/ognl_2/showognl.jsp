<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Struts2 OGNL与标签应用示例</title>
</head>
<body>
<h3>（2）访问OGNL上下文和Action上下文——使用OGNL访问属性值</h3>
parameters：
<s:property value="#parameters.msg"/>
<br> request.msg：
<s:property value="#request.msg"/>
<br> session.msg：
<s:property value="#session.msg"/>
<br> application.msg：
<s:property value="#application.msg"/>
<br> attr.msg：
<s:property value="#attr.msg"/>
<br>aaaaaxxyy:<s:property value="x2"/>
</body>
</html>