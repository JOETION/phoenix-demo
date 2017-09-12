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

package com.snow.phoenix.demo.ood.dynamicproxy.impls;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/12          FXY        Created
 **********************************************
 */

//田径类实现
public class Runner implements com.snow.phoenix.demo.ood.dynamicproxy.interfaces.Runnable {


    public void run(String name) {
        System.out.println(name + "开始冲刺！");
        System.out.println("let it go ------");
        System.out.println(name + "赢得了冠军！");
        System.out.println(name + "获得一个价值100w的奖牌");
    }
}
