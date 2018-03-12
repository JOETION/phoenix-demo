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

package com.snow.phoenix.demo.safe.oauth2.dto;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/18          FXY        Created
 **********************************************
 */


import lombok.ToString;

import java.io.Serializable;

// lombok的注解，减少代码量
// @Getter
// @Setter
@ToString
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
