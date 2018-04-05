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
    <title>表单设计演示</title>
</head>
<body>
<h3>FORM表单</h3>
<s:form action="" name="test">
    <s:textfield label="用户名" name="uname"/>
    <s:password label="密码" name="upass"/>
    <s:file name="file" label="上传文件"/>
    <s:hidden name="id" value="1"/>
    <s:select list="#{'1':'博士','2':'硕士'}" name="edu" label="学历"
              listKey="key" listValue="value"></s:select>
    <!-- value是选中的 -->
    <s:select label="lanuage" list="{'java','.net',''}" value="{'.net'}"></s:select>
    <!-- 必须有name -->
    <s:checkbox label="爱好 " name="checkboxFiled1" value="true"></s:checkbox>
    <!-- 多个checkbox -->
    <s:checkboxlist list="{'java','css','html','struts2'}" label="喜欢的编程语言1"
                    name="box" value="{'css','struts2'}"></s:checkboxlist>
    <!-- map集合前要加# -->
    <s:checkboxlist
            list="#{1:'java',2:'css',3:'html',4:'struts2',5:'spring'}"
            label="喜欢的编程语言2" name="boxs" value="{1,2}"></s:checkboxlist>
    <!-- radio -->
    <%
        //从服务器传过来值用于设置单选按钮的默认值
        request.setAttribute("sex", "男");
        session.setAttribute("sex1", "1");
    %>
    <s:radio label="性别1" list="{'男','女'}" name="sex1" value="#request.sex"></s:radio>
    <s:radio label="性别2" list="#{'1':'男','2':'女'}" name="sex2" listKey="key"
             listValue="value" value="#session.sex1"></s:radio>
    <s:textarea name="rmake" cols="40" rows="5" label="备注"></s:textarea>
    <!-- 防止表单提交的方式 -->
    <s:token></s:token>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>