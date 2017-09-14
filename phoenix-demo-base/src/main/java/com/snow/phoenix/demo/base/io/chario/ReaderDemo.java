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

package com.snow.phoenix.demo.base.io.chario;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/14          FXY        Created
 **********************************************
 */


import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 字符读取流可以按行读取
 */

public class ReaderDemo {

    private static final String FILE_PATH = "E:\\linux.txt";

    public static void main(String[] args) {
        // 声明一个BufferedReader流的对象
        BufferedReader br = null;
        try {
            // 实例化BufferedReader流，连接FileReader流用于读文件
            br = new BufferedReader(new FileReader(
                    FILE_PATH));
            String result = null;
            //循环读文件，一次读一行
            while ((result = br.readLine()) != null) {
                //输出
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭缓冲流
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
