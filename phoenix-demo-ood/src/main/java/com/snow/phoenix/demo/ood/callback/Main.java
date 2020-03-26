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

package com.snow.phoenix.demo.ood.callback;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2020/3/26          FXY        Created
 **********************************************
 */


public class Main {

    public static void main(String args[]) {
        CallbackActivity callbackActivity = new CallbackActivity();
        AsynTask asynTask = new AsynTask(callbackActivity);//此处我们并没有直接调用页面的设置内容方法，而是将控制权限交给了异步任务类AsynTask
        asynTask.doWork();//由异步任务类来决定什么时候设置内容
    }


}
