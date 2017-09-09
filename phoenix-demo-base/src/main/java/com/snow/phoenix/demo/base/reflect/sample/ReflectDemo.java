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

package com.snow.phoenix.demo.base.reflect.sample;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/9          FXY        Created
 **********************************************
 */


/**
 * 反射用于实例化的pojo
 */
public class ReflectDemo {


    private String key;

    private String value;

    /**
     * 默认无参构造函数
     */
    public ReflectDemo() {
    }


    public ReflectDemo(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
