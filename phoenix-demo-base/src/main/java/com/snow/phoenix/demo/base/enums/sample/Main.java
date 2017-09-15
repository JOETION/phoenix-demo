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

package com.snow.phoenix.demo.base.enums.sample;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/15          FXY        Created
 **********************************************
 */


//入口程序
public class Main {

    private static final String SHAPE = "圆形";

    public static void main(String args[]) {

        //测试values()方法和其他一些方法
        System.out.println("开始测试枚举内置的values()方法...");
        ColorDemo[] values = ColorDemo.values();
        for (ColorDemo colorDemo : values) {
            System.out.println("颜色：" + colorDemo.getName() + "，代码：" + colorDemo.getCode() + "，RGB:" + colorDemo.convertToRgb());
            System.out.println("索引为：" + colorDemo.ordinal());
        }
        System.out.println("values()方法测试完成...");
        System.out.println();

        //测试枚举类的中静态方法
        System.out.println("开始测试枚举中的静态方法...");
        System.out.println("红色的RGB值为：" + ColorDemo.getRgbOfCode("#FF0000")); //红色
        System.out.println("枚举中的静态方法测试完成...");
        System.out.println();

        //测试compareTo()方法，原理：比较枚举的索引大小
        System.out.println("开始测试枚举中compareTo()方法...");
        System.out.println(ColorDemo.RED.compareTo(ColorDemo.BLUE) > 0 ? "RED的索引比BLUE的大..." : "RED的索引比BLUE的小...");
        System.out.println("测试枚举中的compareTo方法完成...");
        System.out.println();

        //测试valueOf()方法
        System.out.println("开始测试枚举内置valueOf()方法...");
        ColorDemo red = ColorDemo.valueOf("RED");
        ColorDemo blue = Enum.valueOf(ColorDemo.class, "BLUE");
        System.out.println("颜色：" + red.getName() + "，代码：" + red.getCode() + "，RGB:" + red.convertToRgb());
        System.out.println("颜色：" + blue.getName() + "，代码：" + blue.getCode() + "，RGB:" + blue.convertToRgb());
        System.out.println("测试valueOf()方法测试完成...");
        System.out.println();

        //测试第二种枚举接口的实现方式
        System.out.println("开始测试第二种枚举接口实现方式...");
        System.out.println("颜色：红色，代码：" + Color2Demo.RED.getCodeByRgb(new ApplePojo(Color2Demo.RED, SHAPE)));
        System.out.println("第二种枚举接口的实现方式测试完成...");
        System.out.println();

    }


}
