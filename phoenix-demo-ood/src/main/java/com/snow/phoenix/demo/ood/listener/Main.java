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

package com.snow.phoenix.demo.ood.listener;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2020/3/25          FXY        Created
 **********************************************
 */


public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ApplicationContext();

        /**
         * 添加监听事件源为整型的监听器
         */
        applicationContext.addApplicationListener(event -> {
            Object source = event.getSource();
            if (source instanceof Integer) {
                int now = (int) source;
                System.out.println("检测到事件源为整型：事件源变为" + now);
            }
        });

        /**
         * 添加监听事件源为字符串类型的监听器
         */
        applicationContext.addApplicationListener(event -> {
            Object source = event.getSource();
            if (source instanceof String) {
                String now = (String) source;
                System.out.println("检测到事件源为字符串类型：事件源变为" + now);
            }
        });

        /**
         * 发布事件
         */
        applicationContext.publishEvent(new ApplicationEvent(1001));//此处还可以抽象事件类型，在ApplicationContext中分发不同的事件，或者再写一个事件分发器
        applicationContext.publishEvent(new ApplicationEvent("Hello"));
    }
}
