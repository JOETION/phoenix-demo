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


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


/**
 * 注解调用工厂
 */
public class AnnotationFactory {

    private AnnotationFactory() {
    }


    public static AnnotationFactory createAnnotationFactory() {
        return new AnnotationFactory();
    }

    /**
     * 通过注解调用某个类的某个方法，注意次注解必须是public和protected
     *
     * @param aClass
     * @param method
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object invokeMethodAnnotation(Class aClass, Method method) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            if (annotation instanceof AnnotationDemo) {
                System.out.println("开始调用sum方法了。。。");
                if (Modifier.PRIVATE == method.getModifiers()) {
                    method.setAccessible(true);
                    Object result = method.invoke(aClass.newInstance(), 5, 5);
                    method.setAccessible(false);
                    return result;
                }
                return method.invoke(aClass.newInstance(), 5, 5);
            }
        }
        return null;
    }
}
