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

package com.snow.phoenix.demo.ood.decorator;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/10/21          FXY        Created
 **********************************************
 */

/**
 * 第一层装饰
 */
public class Decorator1 implements Sourceable {

    private Sourceable sourceable;

    public Decorator1(Sourceable sourceable) {
        super();
        this.sourceable = sourceable;
    }

    public void operation() {
        System.out.println("第1个装饰器前");
        sourceable.operation();
        System.out.println("第1个装饰器后");

    }
}
