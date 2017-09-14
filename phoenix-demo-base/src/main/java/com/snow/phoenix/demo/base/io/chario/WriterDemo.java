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


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * 字符输出流
 */
public class WriterDemo {

    private static final String OUT_FILE_PATH = "E:\\linux.txt";

    public static void main(String[] args) {

        // 建立一个从键盘接收数据的扫描器
        Scanner scanner = new Scanner(System.in);

        // 声明文件字符输出流
        FileWriter fw = null;
        try {
            // 实例化文件字符输出流
            fw = new FileWriter(OUT_FILE_PATH);
            System.out.println("请输入内容：");
            String str = scanner.nextLine();
            // 将数据写入文件中
            fw.write(str);
            System.out.println("已保存！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭文件字符输出流
                fw.close();
                scanner.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }
}
