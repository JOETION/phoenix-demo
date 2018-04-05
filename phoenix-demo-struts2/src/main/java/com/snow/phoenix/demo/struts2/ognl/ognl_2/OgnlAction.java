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

package com.snow.phoenix.demo.struts2.ognl.ognl_2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("struts-default")
@Results({ @Result(name = "success", location = "/ognl/ognl_2/showognl.jsp")})
public class OgnlAction extends ActionSupport {
	private static final long serialVersionUID = -1494290883433357310L;		
	@Action("ognlTest")
	public String ognlTest() throws Exception {		
		// 获得ActionContext实例，以便访问Servlet API
		ActionContext ctx = ActionContext.getContext();
		// 存入application
		ctx.getApplication().put("msg", "application信息");
		// 保存session
		ctx.getSession().put("msg", "seesion信息");
		// 保存request信息
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("msg", "request信息");		
		return SUCCESS;
	}
}

