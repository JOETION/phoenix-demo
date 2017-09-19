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

package com.snow.phoenix.demo.base.locale;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/19          FXY        Created
 **********************************************
 */


import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * 格式化案列
 * 包括货币格式化，时间格式化，消息格式化
 */
public class FormatterDemo {


    //货币格式案例，将货币转换为不同国家的货币
    public void numberFormatDemo() {
        // 需要格式化的数据
        double value = 987654.321;
        // 设定Locale
        Locale cnLocale = new Locale("zh", "CN");
        Locale usLocale = new Locale("en", "US");
        // 得到local对应的NumberFormat对象
        NumberFormat cnNf = NumberFormat.getCurrencyInstance(cnLocale);
        NumberFormat usNf = NumberFormat.getCurrencyInstance(usLocale);
        // 将上边的double数据格式化输出
        System.out.println("China Currency Format:" + cnNf.format(value));
        System.out.println("United Currency Format:" + usNf.format(value));
    }


    //日期格式化案列，将Date对象转换为指定格式字符串
    public void dateTimeFormatterDemo() {
        DateTimeFormatter[] formatters = new DateTimeFormatter[]{
                // 直接使用常量创建DateTimeFormatter格式器
                DateTimeFormatter.ISO_LOCAL_DATE,  //只有日期
                DateTimeFormatter.ISO_LOCAL_TIME,  //只有时间
                DateTimeFormatter.ISO_LOCAL_DATE_TIME, //有日期和时间
                // 使用本地化的不同风格来创建DateTimeFormatter格式器
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,
                        FormatStyle.MEDIUM),  //日期时间
                DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG), //日期
                // 根据模式字符串来创建DateTimeFormatter格式器
                DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss")};  //G表示公元年限
        LocalDateTime date = LocalDateTime.now();
        // 依次使用不同的格式器对LocalDateTime进行格式化
        Stream.of(formatters).forEachOrdered(a -> {
            // 下面两行代码的作用相同
            System.out.println(date.format(a));
            System.out.println(a.format(date));
        });

    }


    //将指定格式的字符串转换为Date对象
    public void parseDate() {
        // 定义一个任意格式的日期时间字符串
        String str1 = "2015==12==02 01时06分09秒";
        // 根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter fomatter1 = DateTimeFormatter
                .ofPattern("yyyy==MM==dd HH时mm分ss秒");
        // 执行解析
        LocalDateTime dt1 = LocalDateTime.parse(str1, fomatter1);
        System.out.println(dt1); // 输出 2015-12-02T01:06:09
        // ---下面代码再次解析另一个字符串---
        String str2 = "2015$$$十二月$$$02 20小时";
        DateTimeFormatter fomatter2 = DateTimeFormatter
                .ofPattern("yyyy$$$MMM$$$dd HH小时");
        LocalDateTime dt2 = LocalDateTime.parse(str2, fomatter2);
        System.out.println(dt2); // 调用Date对象的toString方法，输出 2015-12-02T20:00
    }

    //替换指定格式字符串中的表达式，常用于配置文件中替换目标正则表达式
    public void parseMessage() {
        // 定义一个带占位符的模式字符串
        String pattern1 = "{0},您好!欢迎您在{1}访问本系统！";
        // 获取默认语言环境
        Locale locale1 = Locale.getDefault();
        // 输出国家
        System.out.println(locale1.getCountry());
        // 构造模式串所需的对象数组
        Object[] msgParams1 = {"FXY", new Date()};
        // 调用msgFormat()实现消息格式化输出
        messageFormat(pattern1, locale1, msgParams1);

        // 定义一个带占位符的模式字符串,对占位符进行不同的格式化
        String pattern2 = "{0} ,你好!欢迎您在{1,date,long}访问本系统,现在是{1,time,hh:mm:ss}";
        // 调用msgFormat()实现消息格式化输出
        messageFormat(pattern2, locale1, msgParams1);

        System.out.println("--------------------------------------");
        // 创建一个语言环境
        Locale locale2 = new Locale("en", "US");
        // 输出国家
        System.out.println(locale2.getCountry());
        // 构造模式串所需的对象数组
        Object[] msgParams2 = {"正方教务系统", new Date()};
        // 调用msgFormat()实现消息格式化输出
        messageFormat(pattern1, locale2, msgParams2);
        messageFormat(pattern2, locale2, msgParams2);
    }

    //设置为私有，除本类自身外，不能访问
    private void messageFormat(String pattern, Locale locale,
                               Object[] msgParams) {
        // 根据指定的pattern模式字符串构造MessageFormat对象
        MessageFormat formatter = new MessageFormat(pattern);
        // formatter.applyPattern(pattern);
        // 设置语言环境
        formatter.setLocale(locale);
        // 根据传递的参数，对应替换模式串中的占位符
        System.out.println(formatter.format(msgParams));
    }

    public static void main(String args[]) {
        FormatterDemo formatterDemo = new FormatterDemo();
//        formatterDemo.numberFormatDemo();
//        formatterDemo.dateTimeFormatterDemo();
//        formatterDemo.parseDate();
        formatterDemo.parseMessage();
    }

}
