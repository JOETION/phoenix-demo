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
 *    2017/9/12          FXY        Created
 **********************************************
 */


import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // 设置默认语言环境
        Locale.setDefault(Locale.CHINA);
        // 获取计算机默认语言环境
        Locale china = Locale.getDefault();
        System.out.println("-----------中国START------------");
        System.out.println("默认语言代码: " + china.getLanguage());
        System.out.println("默认地区代码: " + china.getCountry());
        System.out.println("默认语言地区代码: " + china.toString());
        System.out.println("---------------------------------------");
        System.out.println("默认语言描述: " + china.getDisplayLanguage());
        System.out.println("默认地区描述: " + china.getDisplayCountry());
        System.out.println("默认语言,地区描述: " + china.getDisplayName());
        System.out.println("---------------------------------------");
        System.out.println("在美国默认语言叫: " + china.getDisplayLanguage(Locale.US));
        System.out.println("在美国默认地区叫: " + china.getDisplayCountry(Locale.US));
        System.out.println("在美国默认语言,地区叫: " + china.getDisplayName(Locale.US));
        System.out.println("在日本默认语言代码叫: " + china.getDisplayLanguage(Locale.JAPAN));
        System.out.println("在日本默认地区代码叫: " + china.getDisplayCountry(Locale.JAPAN));
        System.out.println("在日本默认语言,地区代码叫: " + china.getDisplayName(Locale.JAPAN));
        System.out.println("---------------------------------------");
        System.out.println("语言环境三字母缩写: " + china.getISO3Language());
        System.out.println("国家环境三字母缩写: " + china.getISO3Country());
        System.out.println("-----------中国END---------------");
        // 机器已经安装的语言环境数组
        Locale[] allLocale = Locale.getAvailableLocales();
        // 返回 ISO 3166 中所定义的所有两字母国家代码
        String[] str1 = Locale.getISOCountries();
        // 返回 ISO 639 中所定义的所有两字母语言代码
        String[] str2 = Locale.getISOLanguages();
    }
}
