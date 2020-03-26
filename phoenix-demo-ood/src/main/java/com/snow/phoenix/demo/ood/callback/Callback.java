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
 * 回调接口
 * 情景：安卓手机上某一页面需要显示从本地读取的图片，那么需要等待下载线程下载结束后，再回调页面的
 * 设置图片接口，此处仅模拟场景，并不具体建立窗体
 * 用于将控制权交给第三方，何时调用取决于第三方，系统只需要提供回调时所执行的接口即可
 * 回调是一种思想，不能局限于代码，java中的事件监听器也是用的回调函数，listener包也是回调的案列
 */
public interface Callback {
    public boolean setContent(InputStream inputStream);
}
