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

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏案列
 * 栅栏用于等待其他线程
 */
@ThreadSafe
public class CyclicBarrierDemo {

    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    /**
     * 验证栅栏
     */
    private void verifyCyclicBarrier() {
        System.err.println("开始初始化3个线程");
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        cyclicBarrier.await();
                        System.out.println("线程执行了，id：" + Thread.currentThread().getId());
                    } catch (InterruptedException e) {
                        System.out.println("阻塞中的线程被打断了，原因：" + e);
                    } catch (BrokenBarrierException e) {
                        System.out.println("栅栏等待超时，原因：" + e);
                    }
                }
            }).start();
        }

        //保证所有线程的正常发布，模拟每次请求的时间间隔，事实上每次请求都有时间间隔的，线上环境可以直接去掉
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断，原因：" + e);
        }

        System.err.println("开始初始化后3个线程");
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        cyclicBarrier.await();
                        System.out.println("线程执行了，id：" + Thread.currentThread().getId());
                    } catch (InterruptedException e) {
                        System.out.println("阻塞中的线程被打断了，原因：" + e);
                    } catch (BrokenBarrierException e) {
                        System.out.println("栅栏等待超时，原因：" + e);
                    }
                }
            }).start();
        }
        System.err.println("验证成功，所有线程已运行完成");
    }


    public static void main(String args[]) {
        new CyclicBarrierDemo().verifyCyclicBarrier();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }

}
