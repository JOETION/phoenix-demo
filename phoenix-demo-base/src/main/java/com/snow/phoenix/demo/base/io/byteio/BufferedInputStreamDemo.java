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

package com.snow.phoenix.demo.base.io.byteio;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/14          FXY        Created
 **********************************************
 */


import java.io.BufferedInputStream;
import java.io.FileInputStream;


/**
 * 缓冲字节输入流案例
 * <p>
 * 缓冲可以将字节流先放入一个指定大小的缓冲区
 */
public class BufferedInputStreamDemo {

    private static final String FILE_PATH = "E://linux.txt";

    public static void main(String[] args) {
        // 定义一个BufferedInputStream类型的变量
        BufferedInputStream bi = null;
        try {
            // 利用FileInputStream对象创建一个输入缓冲流
            bi = new BufferedInputStream(new FileInputStream(FILE_PATH));
            int result = 0;
            //循环读数据
            while ((result = bi.read()) != -1) {
                //输出
                System.out.print((char) result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭缓冲流
                bi.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
