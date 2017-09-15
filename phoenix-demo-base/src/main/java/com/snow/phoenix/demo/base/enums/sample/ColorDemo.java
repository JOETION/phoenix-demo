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


import javax.swing.*;
import java.awt.*;

/**
 * 枚举类中的每一个枚举都是该类的一个实例
 * <p>
 * 枚举中不能有 static final 的量，即常量
 * <p>
 * 此类中所有抽象方法和接口实现方法均在枚举变量中实现
 * 若要此类中实现接口方法，请参考
 *
 * @see Color2Demo
 */
public enum ColorDemo implements CodeDemo {

    //每一个枚举都是该类的实例，故要实例化，或者覆盖其抽象方法和接口中的方法
    RED("红色", "#FF0000") {
        @Override
        public String convertToRgb() {
            return "255.0.0";
        }

        public String getCodeByRgb(Object object) {
            return "#FF0000";
        }
    }, BLUE("蓝色", "#0000FF") {
        @Override
        public String convertToRgb() {
            return "0.0.255";
        }

        public String getCodeByRgb(Object object) {
            return "#0000FF";
        }
    };


    //颜色名称
    private String name;

    //颜色代码
    private String code;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    //构造函数默认private修饰符
    ColorDemo(String name, String code) {
        this.name = name;
        this.code = code;
    }

    //枚举中可以定义静态方法
    public static String getRgbOfCode(String code) {
        if (code.equals("#FF0000")) {
            return "255.0.0";
        } else if (code.equals("#0000FF")) {
            return "255.0.0";
        }
        return null;
    }

    //转会为RGB代码
    abstract public String convertToRgb();


}
