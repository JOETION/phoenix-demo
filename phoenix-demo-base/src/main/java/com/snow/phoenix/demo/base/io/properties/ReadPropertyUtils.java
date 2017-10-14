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

package com.snow.phoenix.demo.base.io.properties;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/10/10          FXY        Created
 **********************************************
 */


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ReadPropertyUtils {

    /**
     * 通过Properties类来加载
     */
    public static void byPropertiesClass() throws IOException {
        InputStream resourceAsStream = ReadPropertyUtils.class.getClassLoader().getResourceAsStream("./localedemo.properties");

        //读取
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        System.out.println("title：" + properties.getProperty("title"));
        System.out.println("name：" + properties.getProperty("name"));

/*
        //写入
        FileOutputStream oFile = new FileOutputStream("./localedemo.properties", true);//true表示追加打开
        properties.setProperty("phone", "10086");
        properties.store(oFile, "The New properties file");
        oFile.close();
*/


    }

    /**
     * 通过ResourceBundle来加载
     */
    public static void byResourceBundle() throws IOException {
        InputStream resourceAsStream = ReadPropertyUtils.class.getClassLoader().getResourceAsStream("./localedemo.properties");

        //第一种读取方式
        ResourceBundle oneBundle = new PropertyResourceBundle(resourceAsStream);
        System.out.println("title：" + oneBundle.getString("title"));
        System.out.println("name：" + oneBundle.getString("name"));

        //第二种读取方式
        ResourceBundle twoBundle = ResourceBundle.getBundle("localedemo");
        System.out.println("title：" + twoBundle.getString("title"));
        System.out.println("name：" + twoBundle.getString("name"));

        //写入待续

    }

}
