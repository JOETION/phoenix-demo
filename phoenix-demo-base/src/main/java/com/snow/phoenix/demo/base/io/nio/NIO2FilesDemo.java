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

package com.snow.phoenix.demo.base.io.nio;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/14          FXY        Created
 **********************************************
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * NIO2包下的文件案列
 */
public class NIO2FilesDemo {

    //源文件路径
    private static final String SOURCE_PATH = "E:\\Company\\phoenix-demo\\phoenix-demo-base\\src\\main\\java\\com\\snow\\phoenix\\demo\\base\\io\\nio\\NIO2FilesDemo.java";

    //目标文件路径
    private static final String TARGET_PATH = "E:\\NIO2FilesDemo.java";

    //目标文件路径
    private static final String _TARGET_PATH = "E:\\poem.txt";

    public static void main(String[] args) {
        try {
            // 复制文件
            Files.copy(
                    Paths.get(SOURCE_PATH),
                    new FileOutputStream(TARGET_PATH));
            // 判断NIO2FilesDemo.java文件是否为隐藏文件
            System.out.println("NIO2FilesDemo.java是否为隐藏文件："
                    + Files.isHidden(Paths
                    .get(SOURCE_PATH)));
            // 一次性读取FilesTest.java文件的所有行
            List<String> lines = Files.readAllLines(Paths.get("E://","Company","phoenix-demo","phoenix-demo-base","src", "main",
                    "java", "com", "snow","phoenix","demo","base","io","nio","NIO2FilesDemo.java"), Charset
                    .forName("gbk"));
            System.out.println("行数：" + lines.size());
            // 判断指定文件的大小
            System.out.println("NIO2FilesDemo.java文件的大小为：" + Files.size(Paths.get(TARGET_PATH)));
            List<String> poem = new ArrayList<String>();
            poem.add("使用NIO.2技术");
            poem.add("往文件中写内容");
            // 直接将多个字符串内容写入指定文件中
            Files.write(Paths.get(_TARGET_PATH), poem, Charset.forName("gbk"));
            FileStore cStore = Files.getFileStore(Paths.get("C:"));
            // 判断C盘的总空间，可用空间
            System.out.println("C:共有空间：" + cStore.getTotalSpace());
            System.out.println("C:可用空间：" + cStore.getUsableSpace());
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
