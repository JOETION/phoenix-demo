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

package com.snow.phoenix.demo.struts2.interceptor;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/4/2          FXY        Created
 **********************************************
 */


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

    public void init() {
        System.out.println("Login 拦截器初始化了");
    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("Login Before");
        String result = actionInvocation.invoke();
        System.out.println("Login After");
        return result;
    }

    public void destroy() {
        System.out.println("Login 拦截器销毁了");
    }
}
