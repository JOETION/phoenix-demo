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


import java.util.HashSet;
import java.util.Set;

public class ApplicationContext {

    /**
     * 存放所有的监听器
     */
    private Set<ApplicationListener> listeners;

    public ApplicationContext() {
        this.listeners = new HashSet<>();
    }

    /**
     * 添加监听器
     *
     * @param listener 监听器
     */
    public void addApplicationListener(ApplicationListener listener) {
        this.listeners.add(listener);
    }

    /**
     * 发布事件
     * 回调所有监听器的回调方法
     *
     * @param event 事件
     */
    public void publishEvent(ApplicationEvent event) {
        for (ApplicationListener listener : listeners) {
            listener.onApplicationEvent(event);
        }
    }
}
