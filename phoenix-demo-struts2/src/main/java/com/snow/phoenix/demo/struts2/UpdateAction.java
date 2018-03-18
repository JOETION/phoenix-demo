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

package com.snow.phoenix.demo.struts2;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/3/18          FXY        Created
 **********************************************
 */


/**
 * 控制器类<br/>
 * 当一个Action中有多个业务方法时，可以采用调用的方法有：<br/>
 * 1：中struts.xml中配置method属性
 * 2：采用DMI（动态方法调用）方式调用
 * 3：采用通配符
 */
public class UpdateAction {

    private String name;

    private String pwd;

    private static final String SUCCESS = "success";

    private static final String ERROR = "error";

    /**
     * 更新name
     *
     * @return 请求结果
     */
    public String updateName() {

        return SUCCESS;
    }


    /**
     * 更新Pwd
     *
     * @return 请求结果
     */
    public String updatePwd() {

        return SUCCESS;
    }


    /**
     * 通配符形式更新name
     *
     * @return 请求结果
     */
    public String update_Name() {

        return SUCCESS;
    }

    /**
     * 通配符形式更新Pwd
     *
     * @return
     */
    public String update_Pwd() {

        return SUCCESS;
    }

    /**
     * 默认执行方法
     *
     * @return 请求结果
     */
    public String execute() {

        return SUCCESS;
    }


}
