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

package com.snow.phoenix.demo.spring.aop.sample;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/5          FXY        Created
 **********************************************
 */


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String args[]) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"method-invoke-aspectj.xml"});
        VerifyMethodInvoke verifyMethodInvoke = (VerifyMethodInvoke) classPathXmlApplicationContext.getBean("verifyMethodInvoke");
        try {
            verifyMethodInvoke.sum(5, 5);
            verifyMethodInvoke.sum(5, 0);
        } catch (Throwable throwable) {
//            System.out.println(throwable.getMessage());
        }
        System.out.println("验证完成");
    }
}
