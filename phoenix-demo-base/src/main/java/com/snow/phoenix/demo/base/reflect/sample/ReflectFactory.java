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

package com.snow.phoenix.demo.base.reflect.sample;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/9          FXY        Created
 **********************************************
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 实例化工厂，主要用于实例化
 */
public class ReflectFactory {


    private ReflectFactory() {
    }

    public static ReflectFactory createReflectFactory() {
        return new ReflectFactory();
    }

    /**
     *  构造无参数实例
     * @param target 目标类
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object newInstance(Class target) throws IllegalAccessException, InstantiationException {
        return target.newInstance();
    }

    /**
     *  构造有参数实例
     * @param target 目标类
     * @param paramsType 参数类型
     * @param value 参数值
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public Object newInstanceByConstructor(Class target, Class[] paramsType, Object[] value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = target.getConstructor(paramsType);
        return constructor.newInstance(value);
    }
}
