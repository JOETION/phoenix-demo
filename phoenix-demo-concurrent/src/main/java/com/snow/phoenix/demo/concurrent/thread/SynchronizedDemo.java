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
 *    2017/7/31          FXY        Created
 **********************************************
 */


import com.snow.phoenix.demo.concurrent.base.annotation.GuardedBy;
import com.snow.phoenix.demo.concurrent.base.annotation.ThreadSafe;

/**
 * 内置锁案列
 */
@ThreadSafe
public class SynchronizedDemo {

    //当同步块内线程访问的不是对象时，可以人为构造一个对象锁，如果同步块内访问的是对象，则可以直接以该对象作为锁
    private final Object lock = new Object();

    //资源变量值
    @GuardedBy(lock = "this")
    private int resourceValue = 0;

    //同步方法
    private synchronized void synchronizedMethod(long threadId) {
        resourceValue++;
        System.out.println("[ " + threadId + " ，" + resourceValue + " ]");
    }

    //验证同步方法
    private void verifySynchronizedMethod() {
        System.err.println("开始进行同步方法测试");
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    synchronizedMethod(Thread.currentThread().getId());
                }
            }).start();
        }

        //保证所有线程的正常发布，模拟每次请求的时间间隔，事实上每次请求都有时间间隔的，线上环境可以直接去掉
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断，原因：" + e);
        }

    }


    //同步块
    private void synchronizedBlock(long threadId) {

        //弄清楚概念，每次只有一个线程获得该对象锁
        synchronized (this) {
            resourceValue++;
        }
        System.out.println("[ " + threadId + " ，" + resourceValue + " ]");
    }


    //验证同步块
    private void verifySynchronizedBlock() {
        System.err.println("开始进行同步块测试");
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    synchronizedBlock(Thread.currentThread().getId());
                }
            }).start();
        }

        //保证所有线程的正常发布，模拟每次请求的时间间隔，事实上每次请求都有时间间隔的，线上环境可以直接去掉
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断，原因：" + e);
        }
    }

    public static void main(String args[]) {

        //验证同步方法
        new SynchronizedDemo().verifySynchronizedMethod();

        //验证同步块
        new SynchronizedDemo().verifySynchronizedBlock();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }

}
