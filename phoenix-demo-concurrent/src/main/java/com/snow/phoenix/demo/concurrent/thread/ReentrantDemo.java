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

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁案列
 */

@ThreadSafe
public class ReentrantDemo {


    //原子引用，保证线程安全性
    private final AtomicReference<ConditionBoundedBuffer> atomicReference = new AtomicReference<ConditionBoundedBuffer>();

    //20个闭锁
    private final CountDownLatch countDownLatch = new CountDownLatch(20);

    public ReentrantDemo() {
        ConditionBoundedBuffer<String> conditionBoundedBuffer = new ConditionBoundedBuffer<String>();
        atomicReference.set(conditionBoundedBuffer);
    }

    //验证可重入锁
    private void verifyReentrantLock() {
        System.err.println("开始初始化10个线程");
        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await();
                        atomicReference.get().put(Thread.currentThread().getName());
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


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await();
                        String name = (String) atomicReference.get().take();
                        System.out.println("线程id：" + Thread.currentThread().getId() + " 得到的值为：" + name);
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

        for (int i = 0; i < 20; i++)
            countDownLatch.countDown();


    }


    public static void main(String args[]) {

        new ReentrantDemo().verifyReentrantLock();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }

    /**
     * 使用显式条件变量实现有界缓存
     *
     * @param <T> 队列类型
     */
    public static class ConditionBoundedBuffer<T> {
        //重入锁
        private final Lock reentrantLock = new ReentrantLock();

        //队列未满条件
        private final Condition notFull = reentrantLock.newCondition();

        //队列不为空条件
        private final Condition notEmpty = reentrantLock.newCondition();

        //队列数组
        private final T[] objects = (T[]) new Object[1000];

        //队列尾，头索引，以及队列中当前大小
        private int tail, head, count;

        //放入值
        public void put(T t) {
            reentrantLock.lock();
            try {
                while (count == objects.length)
                    notFull.await();
                objects[tail] = t;
                if (++tail == objects.length)
                    tail = 0;
                ++count;
                notEmpty.signal();
            } catch (InterruptedException e) {
                System.out.println("阻塞中的线程被中断了，原因：" + e);
            } finally {
                reentrantLock.unlock();
            }
        }


        //得到队首的值
        public T take() {
            reentrantLock.lock();
            try {
                while (count == 0)
                    notEmpty.await();
                T t = objects[head];
                objects[head] = null;
                if (++head == objects.length)
                    head = 0;
                --count;
                notFull.signal();
                return t;
            } catch (InterruptedException e) {
                System.out.println("阻塞中的线程被中断了，原因：" + e);
            } finally {
                reentrantLock.unlock();
            }
            return null;
        }


    }


}
