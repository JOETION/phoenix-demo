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

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 原子变量案列
 * 原子操作：这个操作是原子性的，不能再分了，例如 int i=5是原子操作，因为只有一个赋值操作
 * 但是i=i++不是一个原子操作，因为i先自增，然后再赋值，有两步操作
 * <p>
 * 原子类既保证可见性，又保证原子性
 * <p>
 * CAS：当多个线程尝试同时更新同一变量时，只有其中一个线程能够更新变量的值，而其他线程将失败，失败的线程不会被挂起，
 * 而是被告知这次竞争失败了，并可以尝试再次重试
 * <p>
 * 所有原子类的get，set方法只提供可见性，compareAndSet方法提供原子性，但是当并发量很高，变量修改速度过快的时候，会出现BAB问题，
 * 这时可以使用AtomicStampedReference类来维护
 */
@ThreadSafe
public class AtomicDemo {

    //原子引用类
    private final AtomicStampedReference<ResourceValue> atomicReference = new AtomicStampedReference<ResourceValue>(new ResourceValue("FXY", 20), 0);

    //验证原子引用
    private void verifyAtomic() {
        System.err.println("开始初始化10个线程");
        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        int oldVersion = atomicReference.getStamp();
                        ResourceValue oldResourceValue = atomicReference.getReference();
                        if (atomicReference.compareAndSet(oldResourceValue, new ResourceValue(Thread.currentThread().getName(), 0), oldVersion, oldVersion + 1)) {
                            System.out.println("线程id：" + Thread.currentThread().getId() + "得到的名字为：" + atomicReference.getReference().name);
                            break;
                        }

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

    }


    public static void main(String args[]) {

        new AtomicDemo().verifyAtomic();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }


    public static class ResourceValue {

        public final String name;
        public final int age;

        public ResourceValue(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
