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


/**
 * 为了区分枚举中接口实现的用法，这里另开一个类来演示
 * <p>
 * 此类中接口的实现方法，写在类中，而不写在枚举变量中
 */
public enum Color2Demo implements CodeDemo {


    //每一个枚举都是该类的实例，故要实例化，或者覆盖其抽象方法和接口中的方法
    RED("红色", "#FF0000") {
        @Override
        public String convertToRgb() {
            return "255.0.0";
        }
    }, BLUE("蓝色", "#0000FF") {
        @Override
        public String convertToRgb() {
            return "0.0.255";
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
    Color2Demo(String name, String code) {
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


    //此处演示switch中使用枚举变量
    @Override
    public String getCodeByRgb(Object object) {
        if (!(object instanceof ApplePojo))
            throw new IllegalArgumentException("参数异常，此参数不是ApplePojo的实例！");
        ApplePojo applePojo = (ApplePojo) object;
        switch (applePojo.getColor2Demo()) {
            case RED: {
                return "#FF0000";
            }
            case BLUE: {
                return "#0000FF";
            }
            default: {
                System.out.println("此苹果未定义颜色");
                return null;
            }
        }
    }
}
