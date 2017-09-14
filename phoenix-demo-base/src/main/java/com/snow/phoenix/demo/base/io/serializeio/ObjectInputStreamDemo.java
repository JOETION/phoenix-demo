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

package com.snow.phoenix.demo.base.io.serializeio;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/14          FXY        Created
 **********************************************
 */


import java.io.FileInputStream;
import java.io.ObjectInputStream;


/**
 * 对象输入流案列
 */
public class ObjectInputStreamDemo {

    private static final String FILE_PATH="E://UserPojo.txt";

    public static void main(String[] args) {

        // 创建一个ObjectInputStream对象输入流
        try {
            // 从ObjectInputStream对象输入流中读取一个对象，并强制转换成Person对象
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            UserPojo person = (UserPojo) ois.readObject();
            System.out.println("序列化完毕！读出的对象信息如下：");
            System.out.println("name:" + person.getName());
            System.out.println("age:" + person.getAge());
            System.out.println("sex:" + person.getSex());
            System.out.println("high:" + person.getHigh());
            System.out.println("weight:" + person.getWeight());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
