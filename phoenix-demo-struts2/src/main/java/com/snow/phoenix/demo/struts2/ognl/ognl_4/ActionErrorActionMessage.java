/*
 *  Copyright 2016-2020 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       QQ:1322874562  PHONE:13882946572
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.snow.phoenix.demo.struts2.ognl.ognl_4;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("struts-default")
@Results({ @Result(name = "success", location = "/ognl/ognl_4/showErrorActionMessage.jsp") })
public class ActionErrorActionMessage extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Action("messageTest")
	public String execute() {
		// 使用addActionError()方法添加信息
		addActionError("使用ActionError添加错误信息！");
		addActionMessage("使用ActionMessage添加普通信息！");
		return SUCCESS;
	}
}
