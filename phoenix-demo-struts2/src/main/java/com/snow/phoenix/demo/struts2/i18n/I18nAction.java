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

package com.snow.phoenix.demo.struts2.i18n;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/4/5          FXY        Created
 **********************************************
 */


import com.opensymphony.xwork2.ActionSupport;

//获取国际化资源文件中的内容
public class I18nAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String abcd;

    public String getAbcd() {
        return abcd;
    }

    public void setAbcd(String abcd) {
        this.abcd = abcd;
    }

    @Override
    public String execute() throws Exception {
        // 在 Action 中访问国际化资源文件的 value 值,这里是"username"
        String username = getText("username");
        abcd = username;
        System.out.println(username);
        return SUCCESS; //接口里面的常量
    }

}
