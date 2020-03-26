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

import java.io.InputStream;

/**
 * 异步任务类，应该是个线程类，但是此处仅表达回调函数的用法，并不参与实际
 */
public class AsynTask {

    private Callback callback;

    public AsynTask(Callback callback) {
        this.callback = callback;
    }

    public void doWork() {
        InputStream inputStream = null;//此处是从本地文件取得流
        callback.setContent(inputStream);//获取到流后，调用回调方法设置页面内容
    }

}
