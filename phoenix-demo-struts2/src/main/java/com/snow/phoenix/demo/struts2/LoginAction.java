package com.snow.phoenix.demo.struts2;/*
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

/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/3/12          FXY        Created
 **********************************************
 */


import com.opensymphony.xwork2.ActionSupport;

/**
 * 控制器类 <br/>
 * 参考网址：<br/>
 * <a href="http://blog.csdn.net/shuiguolan/article/details/51728127"></a>
 */
public class LoginAction extends ActionSupport {

    private String name;

    private int age;

    private String result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String execute() throws Exception {
        this.setResult("name=" + name);
        this.setResult(this.getResult() + "  age=  " + String.valueOf(age));
        return "success";
    }

}