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

package com.snow.phoenix.demo.struts2.action;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/3/28          FXY        Created
 **********************************************
 */


import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.Map;

public class InterestAction extends ActionSupport {

    private Map<String, Boolean> stringBooleanMap = new HashMap<String, Boolean>();

    @Override
    public String execute() throws Exception {
        System.out.println("进入执行了。。。。");
        stringBooleanMap.put("111", true);
        stringBooleanMap.put("222", false);
        stringBooleanMap.put("333", true);
        stringBooleanMap.put("444", false);
        return SUCCESS;
    }

    public Map<String, Boolean> getStringBooleanMap() {
        return stringBooleanMap;
    }

    public void setStringBooleanMap(Map<String, Boolean> stringBooleanMap) {
        this.stringBooleanMap = stringBooleanMap;
    }
}
