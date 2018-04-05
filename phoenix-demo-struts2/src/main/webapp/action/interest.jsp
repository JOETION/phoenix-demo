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
  Date: 2018/3/28
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>兴趣选择页面</title>
</head>
<body>

<div>
    <form action="interest">
        <input type="submit" value="提交">
    </form>
</div>

<div>
    <c:forEach items="${stringBooleanMap}" var="i">
        <c:choose>
            <c:when test="${i.value}">
                <span>${i.key}<input type="checkbox" checked></span>
            </c:when>
            <c:otherwise>
                <span>${i.key}<input type="checkbox"></span>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
</body>
</html>
