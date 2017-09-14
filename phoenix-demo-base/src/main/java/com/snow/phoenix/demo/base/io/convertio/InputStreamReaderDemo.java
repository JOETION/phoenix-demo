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

package com.snow.phoenix.demo.base.io.convertio;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/14          FXY        Created
 **********************************************
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字节转换为字符流案例、
 * <p>
 * 字节流不能按行读取，字符流可以按行读取，所以要将字节流转换为字符流
 */
public class InputStreamReaderDemo {

    private static final String QUIT = "exit";

    public static void main(String[] args) {
        try {
            // 将System.in标准输入流InputStream字节流转换成Reader字符流
            InputStreamReader reader = new InputStreamReader(System.in);
            // 将普通Reader包装成BufferedReader
            BufferedReader br = new BufferedReader(reader);
            String line = null;
            // 采用循环方式来一行一行的读取
            while ((line = br.readLine()) != null) {
                // 如果读取的字符串为"exit"，程序退出
                if (line.equals(QUIT)) {
                    System.exit(1);
                }
                // 打印读取的内容
                System.out.println("输入内容为:" + line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
