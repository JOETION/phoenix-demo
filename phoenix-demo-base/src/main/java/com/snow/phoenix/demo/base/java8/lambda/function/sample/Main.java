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

package com.snow.phoenix.demo.base.java8.lambda.function.sample;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/23          FXY        Created
 **********************************************
 */

/**
 * 程序入口
 */
public class Main {
    public static void main(String[] args) {

        //f()方法会自动找到一个无参数的方法
        f(() -> System.out.println("OK"));//传lambda表达式 一个匿名函数对应一个方法

        //双冒号 即直接传方法参数
        g(Math::random);

        //与上面一条语句作用相同
        g(() -> {
            return Math.random();
        });

        //双冒号 即直接传方法参数
        f(A::f);

    }


    public static void f(FunctionInterfaceVoid v) {
        v.f();
    }

    public static void g(FunctionalInterfaceReturn r) {
        System.out.println(r.f());
    }

    static class A {
        public static void f() {
            System.out.println("a.f");

        }
    }
}
