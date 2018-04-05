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

package com.snow.phoenix.demo.struts2.ognl.ognl_1;

import java.util.Date;

import org.apache.struts2.convention.annotation.*;

import com.opensymphony.xwork2.ActionSupport;



@Namespace("/")
@ParentPackage("struts-default")
@Results({ @Result(name = "success", location = "/ognl/ognl_1/showognl.jsp")})
public class PersonAction extends ActionSupport {
	private static final long serialVersionUID = -1494290883433357310L;	
	private Person person;

	@Action("personOgnlTest")
	public String ognlTest() throws Exception {	
		person = new Person("张三",26,new Date());			
		return SUCCESS;
	}
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}

