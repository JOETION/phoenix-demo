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

package com.snow.phoenix.demo.base;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/4/22          FXY        Created
 **********************************************
 */


public class ComplexDemo {
    //主函数入口
    public static void main(String[] args) {
        //数据输入验证
        System.out.println("数据验证：");
        System.out.println(new Complex(3, 2).toString());
        System.out.println(new Complex(3, -2).toString());
        System.out.println(new Complex(4, 1).toString());
        System.out.println(new Complex(4, -1).toString());
        System.out.println(new Complex(1, 0).toString());
        System.out.println(new Complex(0, 0).toString());
        System.out.println(new Complex(0, -2).toString());
        System.out.println(new Complex(0, 1).toString());
        System.out.println(new Complex(0, -1).toString());

        System.out.println("复数运算：");
        //复数运算
        System.out.println(new Complex(3, 2).complexAdd(new Complex(3, 2))); //加
        System.out.println(new Complex(3, 2).complexSub(new Complex(3, 2))); //减
        System.out.println(new Complex(3, 2).complexMulti(new Complex(3, 2))); //乘
        System.out.println(new Complex(3, 2).complexDiv(new Complex(3, 2))); //除
    }

}
