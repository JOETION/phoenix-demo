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


import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件字节输入流案列
 */
public class FileInputStreamDemo {

    private static final String FILE_PATH = "E://linux.txt";

    public static void main(String[] args) {

        // 声明文件字节输入流
        FileInputStream fis = null;
        try {
            // 实例化文件字节输入流
            fis = new FileInputStream(
                    FILE_PATH);
            // 创建一个长度为1024的字节数组作为缓冲区
            byte[] bbuf = new byte[1024];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            // 使用循环重复读文件中的数据
            while ((hasRead = fis.read(bbuf)) > 0) {
                // 将缓冲区中的数据转换成字符串输出
                System.out.print(new String(bbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭文件输入流
                fis.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}
