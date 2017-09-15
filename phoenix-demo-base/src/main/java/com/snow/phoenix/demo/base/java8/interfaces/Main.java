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

package com.snow.phoenix.demo.base.java8.interfaces;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/15          FXY        Created
 **********************************************
 */


/**
 * 程序入口
 * <p>
 * 请将java编译器版本调为1.8，jdk8默认的编译器版本是1.5
 */
public class Main {

    public static void main(String args[]) {
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl();
        System.out.println("开始测试java8新特性，接口中可以有静态方法和默认方法........");
        interfaceDemo.ordinary();
        InterfaceDemo.fixed();
        interfaceDemo.tolerant();
        System.out.println("测试完成........");
    }

}
