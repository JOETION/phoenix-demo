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

package com.snow.phoenix.demo.ood.factory;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/10/10          FXY        Created
 **********************************************
 */

/**
 * 黑色人种
 */
public class BlackPerson extends Person {

    public BlackPerson() {
        type = "black";
        weight = 70f;
        high = 1.8f;
    }

    public void cry() {
        System.out.println("黑人哭了");
    }

    public void laugh() {
        System.out.println("黑人笑了");
    }
}
