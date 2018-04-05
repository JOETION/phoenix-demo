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

package com.snow.phoenix.demo.struts2.validation.action;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/4/5          FXY        Created
 **********************************************
 */


import com.opensymphony.xwork2.ActionSupport;
import com.snow.phoenix.demo.struts2.validation.dao.User;
import com.snow.phoenix.demo.struts2.validation.dao.UserDbase;

public class RegisterAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private User user;
    private String userPwd;

    @Override
    public String execute() throws Exception {
        UserDbase ud = new UserDbase();
        if (ud.addUser(user) == 1) return "success";
        else return "input";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
