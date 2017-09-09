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


import java.lang.reflect.InvocationTargetException;

/**
 * 主函数入口
 */
public class Main {


    public static void main(String args[]) {
        try {
            System.out.println("开启无参构造函数实例化");
            Object instance = ReflectFactory.createReflectFactory().newInstance(ReflectDemo.class);
            if (instance == null)
                throw new IllegalAccessException();
            System.out.println("无参构造函数实例化成功！");
            System.out.println("开启有参构造函数实例化");
            try {
                Object instanceByConstructor = ReflectFactory.createReflectFactory().newInstanceByConstructor(ReflectDemo.class, new Class[]{String.class, String.class}, new Object[]{"方孝勇", "方孝勇"});
                if (instanceByConstructor == null)
                    throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                System.err.println("获取有参构造函数失败！");
            } catch (InvocationTargetException e) {
                System.err.println("实例化有参构造函数失败！");
            }

        } catch (IllegalAccessException e) {
            System.err.println("获取无参构造函数失败！");
        } catch (InstantiationException e) {
            System.err.println("实例化无参构造函数失败！");
        }
    }
}
