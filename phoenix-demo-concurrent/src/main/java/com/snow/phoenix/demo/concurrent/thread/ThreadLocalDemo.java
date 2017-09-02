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

package com.snow.phoenix.demo.concurrent.thread;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/3          FXY        Created
 **********************************************
 */


import com.snow.phoenix.demo.concurrent.base.annotation.ThreadSafe;

/**
 * 本地线程案列
 * 本地线程类似于全局变量，它会降低代码的可重用性，增加类与类之间的耦合性，使用时需慎重
 */
@ThreadSafe
public class ThreadLocalDemo {

    //保存整形变量的本地线程，第一次get时会调用初始化方法
    private final ThreadLocal<Long> threadLocal = new ThreadLocal<Long>() {

        @Override
        protected Long initialValue() {
            return -1L;
        }
    };


    private void verifyThreadLocal() {
        System.err.println("开始初始化10个线程");
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("线程id为：" + Thread.currentThread().getId() + "得到的初始值为：" + threadLocal.get());
                    threadLocal.set(Thread.currentThread().getId());
                    System.out.println("[ id：" + Thread.currentThread().getId() + " value：" + threadLocal.get() + " ]");
                }
            }).start();

            //保证所有线程的正常发布，模拟每次请求的时间间隔，事实上每次请求都有时间间隔的，线上环境可以直接去掉
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                System.out.println("阻塞中的线程被中断，原因：" + e);
            }
        }

        //休眠一秒，等待所有线程执行完成，也可以使用闭锁来实现所有线程达到某个事件
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断，原因：" + e);
        }
    }


    public static void main(String args[]) {

        new ThreadLocalDemo().verifyThreadLocal();
        //添加jvm关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }


}
