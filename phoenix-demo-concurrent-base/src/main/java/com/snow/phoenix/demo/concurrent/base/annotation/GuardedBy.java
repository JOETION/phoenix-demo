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

package com.snow.phoenix.demo.concurrent.base.annotation;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/6          FXY        Created
 **********************************************
 */


import java.lang.annotation.*;

/**
 * 获取某个锁的方法和域注解
 * <p/>
 * 参数主要见名知意，可以为："this","fieldName","ClassName.fieldName","methodName()","ClassName.class"
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface GuardedBy {

    /**
     * 单个锁 ，参数：锁名
     *
     * @return
     */
    String lock() default "";

    /**
     * 顺序获取多个锁，参数：锁名数组
     *
     * @return
     */

    String[] locks() default {};
}
