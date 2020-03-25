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

package com.snow.phoenix.demo.ood.listener;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2020/3/25          FXY        Created
 **********************************************
 */

import java.util.EventListener;

/**
 * <p>基于swing中的事件处理模型</p>
 * <p>事件监听器</p>
 * <p>参考网址：<a href="https://www.jianshu.com/p/724e5814f78b">Java设计模式：事件驱动模式（观察者模式）</a></p>
 */
public interface ApplicationListener extends EventListener {
    void onApplicationEvent(ApplicationEvent event);
}
