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
 * 程序入口
 */
public class Main {

    public static void main(String args[]) throws InstantiationException, IllegalAccessException {
        PersonFactory<Person> personFactory = PersonFactory.getInstance();
        //只需要获取行为，不需要获取人实例具体的内容
        Action blackAction = personFactory.makePerson(BlackPerson.class);
        Action yellowAction = personFactory.makePerson(YellowPerson.class);
        blackAction.cry();
        blackAction.laugh();
        yellowAction.cry();
        yellowAction.laugh();
    }
}
