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

package com.snow.phoenix.demo.base.io.file;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/14          FXY        Created
 **********************************************
 */

import java.io.File;
import java.io.IOException;

/**
 * 文件案列
 */

public class FileDemo {
    public static void main(String[] args) {
        // 以当前路径来创建一个File对象,"."代表当前路径
        File file = new File(".");
        // 直接获取文件名，输出"."
        System.out.println(file.getName());
        // 获取相对路径的父路径可能出错，下面代码输出null
        System.out.println(file.getParent());
        // 获取绝对路径
        System.out.println(file.getAbsoluteFile());
        // 获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        // 以指定的文件名创建File对象
        File newFile = new File("C:\\FileDemo.txt");
        System.out.println("newFile对象是否存在：" + newFile.exists());
        try {
            // 以指定newFile对象来创建一个文件
            newFile.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 以newFile对象来创建一个目录，因为newFile已经存在
        // 所以下面方法返回false，即无法创建该目录
        System.out.println("创建目录："+newFile.mkdir());
        // 使用list()方法来列出当前路径下的所有文件和路径
        String[] fileList = file.list();
        System.out.println("====当前路径下所有文件和路径如下====");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
        // listRoots()静态方法列出所有的磁盘根路径。
        File[] roots = File.listRoots();
        System.out.println("====系统所有根路径如下====");
        for (File root : roots) {
            System.out.println(root);
        }

    }
}
