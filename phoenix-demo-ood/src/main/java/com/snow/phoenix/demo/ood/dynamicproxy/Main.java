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

package com.snow.phoenix.demo.ood.dynamicproxy;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/12          FXY        Created
 **********************************************
 */


import com.snow.phoenix.demo.ood.dynamicproxy.impls.Runner;
import com.snow.phoenix.demo.ood.dynamicproxy.impls.Singer;
import com.snow.phoenix.demo.ood.dynamicproxy.interfaces.Runnable;
import com.snow.phoenix.demo.ood.dynamicproxy.interfaces.Singable;
import com.snow.phoenix.demo.ood.dynamicproxy.proxy.handler.RunnerProxyHandler;
import com.snow.phoenix.demo.ood.dynamicproxy.proxy.handler.SingerProxyHandler;

import java.lang.reflect.Proxy;

/**
 * 动态代理用于避免直接与底层接触
 * 所有行为将交给代理去做
 */

//程序入口
public class Main {
    private static final String SINGER_NAME = "刘德华";

    private static final String RUNNER_NAME = "刘翔";

    public static void main(String args[]) {
        Singer liudehua = new Singer();
        //帮刘德华决定是否需要参加某次演唱会
        SingerProxyHandler singerProxyHandler = new SingerProxyHandler(liudehua);
        Singable singerProxy = (Singable) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), liudehua.getClass().getInterfaces(), singerProxyHandler);
        //代理人给刘德华说，他将参加这次演唱会
        singerProxy.sing(SINGER_NAME);

        Runner liuxiang = new Runner();
        //帮刘翔决定是否需要参加某次田径比赛
        RunnerProxyHandler runnerProxyHandler = new RunnerProxyHandler(liuxiang);
        com.snow.phoenix.demo.ood.dynamicproxy.interfaces.Runnable runnerProxy = (Runnable) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), liuxiang.getClass().getInterfaces(), runnerProxyHandler);
        //代理人给刘翔说，他将参加这次田径比赛
        runnerProxy.run(RUNNER_NAME);
    }
}
