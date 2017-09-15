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

package com.snow.phoenix.demo.base.java8.interfaces;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/15          FXY        Created
 **********************************************
 */


/**
 * java8 新特性：接口支持静态方法和默认方法
 * <p>
 * 默认方法，实现类中可以不用实现
 * <p>
 * 静态方法，接口可以直接调用
 */
public interface InterfaceDemo {

    //普通方法，需要在实现类中实现
    public void ordinary();

    //静态方法，实现类中可以不用实现，只能通过接口名调用静态方法，不能通过接口实现类调用静态方法
    public static void fixed() {
        System.out.println("在java8中，接口中可以有静态方法，不需要实现，只能通过接口名调用静态方法，不能通过接口实现类调用静态方法");
    }

    //默认方法，实现类中可以不用实现，实现类中可以直接调用
    public default void tolerant() {
        System.out.println("在java8中，接口中可以有默认方法，不强制要求实现，可以直接调用");
    }

}
