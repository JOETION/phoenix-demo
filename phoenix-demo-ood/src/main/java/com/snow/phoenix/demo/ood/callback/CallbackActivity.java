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

public class CallbackActivity implements Callback {

    @Override
    public boolean setContent(InputStream inputStream) {
        System.out.println("页面设置了图片：" + inputStream.toString());
        return true;
    }


}