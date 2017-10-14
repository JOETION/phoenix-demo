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

package com.snow.phoenix.demo.ood.factory;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/10/10          FXY        Created
 **********************************************
 */

/**
 * 造人工厂
 */
public class PersonFactory<T> {

    private static PersonFactory personFactory = new PersonFactory();

    //不允许实例化
    private PersonFactory() {
    }

    //获取实例
    public static PersonFactory getInstance() {
        return personFactory;
    }

    //产生人实例
    public <T> T makePerson(Class<? extends T> aClass) throws IllegalAccessException, InstantiationException {
        return aClass.newInstance();
    }

}
