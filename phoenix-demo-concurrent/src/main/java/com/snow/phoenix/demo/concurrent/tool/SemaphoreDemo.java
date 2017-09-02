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

import java.util.concurrent.Semaphore;

/**
 * 信号量案例
 */
@ThreadSafe
public class SemaphoreDemo {
    //信号量，最多只能有两个线程访问某个资源，这里用变量代替资源
    private final Semaphore semaphore = new Semaphore(3);

    //资源变量
    private final int resourceValue = 10;

    /**
     * 验证信号量
     */
    private void verifySemaphore() {

        System.err.println("开始初始化5个线程");
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("线程id为：" + Thread.currentThread().getId() + "的线程，读取了资源变量。值为：" + resourceValue);
                    } catch (InterruptedException e) {
                        System.out.println("线程请求信号量出错，原因：" + e);
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

        System.err.println("即将开始释放所有信号量");
        System.out.println("开始释放第一个信号量");
        semaphore.release();
        System.out.println("开始释放第二个信号量");
        semaphore.release();
        System.out.println("开始释放第三个信号量");
        semaphore.release();
        System.err.println("所有信号量已释放完成");
    }

    public static void main(String args[]) {
        new SemaphoreDemo().verifySemaphore();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }


}
