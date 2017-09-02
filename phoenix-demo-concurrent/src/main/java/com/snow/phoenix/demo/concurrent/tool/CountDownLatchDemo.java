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

package com.snow.phoenix.demo.concurrent.tool;

/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/7/31          FXY        Created
 **********************************************
 */


import com.snow.phoenix.demo.concurrent.base.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * 计数闭锁案列
 * 闭锁用于等待事件
 */

@ThreadSafe
public class CountDownLatchDemo {

    //开始闭锁
    private final CountDownLatch startLatch = new CountDownLatch(5);

    //结束闭锁
    private final CountDownLatch endLatch = new CountDownLatch(5);


    /**
     * 验证闭锁
     * 有时间限制的闭锁同理
     */
    private void verifyCountDownLatch() {
        System.err.println("开始初始化前3个线程");
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        startLatch.await();
                        System.out.println("线程执行了，id：" + Thread.currentThread().getId());
                        endLatch.countDown();
                    } catch (InterruptedException e) {
                        System.out.println("阻塞中的线程被中断了，原因：" + e);
                    }
                }
            }).start();

            //保证所有线程的正常发布，模拟每次请求的时间间隔，事实上每次请求都有时间间隔的，线上环境可以直接去掉
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                System.out.println("阻塞中的线程被中断，原因：" + e);
            }
        }

        //主线程休眠是为了让已经创建的线程运行起来
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("主线程休眠出错，原因：" + e);
        }

        System.err.println("开始初始化后2个线程");
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        startLatch.await();
                        System.out.println("线程执行了，id：" + Thread.currentThread().getId());
                        endLatch.countDown();
                    } catch (InterruptedException e) {
                        System.out.println("阻塞中的线程被中断了，原因：" + e);
                    }
                }
            }).start();

            //保证所有线程的正常发布，模拟每次请求的时间间隔，事实上每次请求都有时间间隔的，线上环境可以直接去掉
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                System.out.println("阻塞中的线程被中断，原因：" + e);
            }
        }

        System.err.println("打开闭锁，线程开始运行");

        //主线程休眠是为了让已经创建的线程运行起来
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("主线程休眠出错，原因：" + e);
        }

        long startTime = System.nanoTime();
        System.out.println("第一个线程已准备");
        startLatch.countDown();
        System.out.println("第二个线程已准备");
        startLatch.countDown();
        System.out.println("第三个线程已准备");
        startLatch.countDown();
        System.out.println("第四个线程已准备");
        startLatch.countDown();
        System.out.println("第五个线程已准备");
        startLatch.countDown();
        try {
            endLatch.await();
        } catch (InterruptedException e) {
            System.out.println("关闭结束闭锁开关时出错，原因：" + e);
        }
        System.out.println("验证成功，5个线程运行完成耗时：" + (System.nanoTime() - startTime));
    }


    public static void main(String args[]) {
        new CountDownLatchDemo().verifyCountDownLatch();
        //添加jvm关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }


}
