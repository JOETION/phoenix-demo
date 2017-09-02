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
 * 多线程可见性案列
 * <p/>
 * volatile关键字只能保证可见性（任何时候返回的都是最新的值），不能保证原子性，常用做线程结束的状态变量
 */
@ThreadSafe
public class VolatileDemo {

    //是否完成的标志，也可使用原子类
    private static volatile boolean running = true;


    //验证可见性
    //方法有个调用栈，由主线程取出，然后在主线程中执行，并不会没执行一个方法就是另开一个线程
    private void verifyVolatile() {

        final Thread thread = new Thread(new Runnable() {
            public void run() {
                while (running) {
                    System.out.println("线程id：" + Thread.currentThread().getId() + " 执行中");
                }
                System.out.println("线程id：" + Thread.currentThread().getId() + " 执行完成");

            }
        });

        //保证所有线程的正常发布，模拟每次请求的时间间隔，事实上每次请求都有时间间隔的，线上环境可以直接去掉
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断，原因：" + e);
        }

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                running = false;
            }
        });
        thread.start();

        //等待线程执行完成
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断，原因：" + e);
        }

        thread1.start();

    }


    public static void main(String args[]) {

        new VolatileDemo().verifyVolatile();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }

}
