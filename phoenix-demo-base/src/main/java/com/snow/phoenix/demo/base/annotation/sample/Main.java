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

package com.snow.phoenix.demo.base.annotation.sample;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/18          FXY        Created
 **********************************************
 */


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 主函数入口
 */
public class Main {

    @AnnotationDemo(version = "1.0.0")
    private int sum(Integer a, Integer b) {
        return a + b;
    }

    /**
     * getDeclaredMethod()可以得到所有修饰符修饰的方法和继承自父类的方法，getMethod()只能得到public修饰符修饰的方法
     *
     * @param args
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void main(String args[]) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Method method = Main.class.getDeclaredMethod("sum", Integer.class, Integer.class);
        Integer result = (Integer) AnnotationFactory.createAnnotationFactory().invokeMethodAnnotation(Main.class, method);
        System.out.println("得到的结果为：" + result);
    }
}
