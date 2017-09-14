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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 打印流案例
 */
public class PrintStreamDemo {

    private static final String OUT_FILE_PATH = "E:\\linux.txt";

    public static void main(String[] args) {

        try {
            PrintStream ps = new PrintStream(new FileOutputStream(
                    OUT_FILE_PATH));
            // 使用PrintStream打印一个字符串
            ps.println("这是PrintStream打印流往文件中写数据！");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
