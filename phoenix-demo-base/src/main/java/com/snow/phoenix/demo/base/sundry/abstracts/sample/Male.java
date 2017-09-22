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

package com.snow.phoenix.demo.base.sundry.abstracts.sample;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/22          FXY        Created
 **********************************************
 */


/**
 * 男人
 */
public class Male extends Human {
    @Override
    protected Object doWork() {
        love();
        requestPaPaPa();
        marry();
        Object son = becomeFather();
        return son;
    }

    //谈恋爱了
    private void love() {
        System.out.println("男人恋爱了...");
    }

    //请求做羞羞的事
    private void requestPaPaPa() {
        System.out.println("男人请求啪啪啪...");
        System.out.println("女友沉默中...");
        System.out.println("成功上船...");
    }


    //结婚了
    private void marry() {
        System.out.println("带着女友见家长啦，内心是忐忑的...");
        System.out.println("男人结婚了...");
    }

    /**
     * 男人当爸爸了
     *
     * @return 宝宝的实例
     */
    private Object becomeFather() {
        System.out.println("女友有宝宝了...");
        System.out.println("岁月蹉跎，男人当爸爸了！");
        return new Object();
    }

}
