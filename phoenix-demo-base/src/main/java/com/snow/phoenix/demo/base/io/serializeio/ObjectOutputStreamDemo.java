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


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 对象输出流案列
 */
public class ObjectOutputStreamDemo {

    private static final String OUT_FILE_PATH="E://UserPojo.txt";

    public static void main(String[] args) {

        // 创建一个ObjectOutputStream对象输出流
        try {
            // 创建一个Person类型的对象
            ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream(OUT_FILE_PATH));
            UserPojo person = new UserPojo.Builder().setAge(21).setHigh("173cm").setName("FXY").setSex("male").setWeight("65").build();
            // 把对象写入到文件中
            obs.writeObject(person);
            obs.flush();
            System.out.println("序列化完毕！");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
