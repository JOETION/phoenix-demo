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

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 可重入读写锁案列
 * <p/>
 * 注意：读写锁不能跨线程解锁，既一个线程持有读取锁，然后持有写入锁的线程不能解锁拥有读取锁的线程
 */

@ThreadSafe
public class ReentrantReadWriteLockDemo {

    //读写锁
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //读取锁
    private final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    //写入锁
    private final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    //原子类型，资源变量
    private final AtomicInteger atomicInteger = new AtomicInteger(10);


    /**
     * 验证可重入读写锁
     * 注意不能跨线程解锁，因为不同的线程有自己的线程栈，各不影响
     */
    private void verifyReentrantReadWriteLock() {
        new Thread(new Runnable() {
            public void run() {
                readLock.lock();
                System.out.println("线程id：" + Thread.currentThread().getId() + " 读取到变量的值为：" + atomicInteger.get());
                readLock.unlock();
            }
        }).start();

        //保证所有线程的正常发布，模拟每次请求的时间间隔，事实上每次请求都有时间间隔的，线上环境可以直接去掉
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断，原因：" + e);
        }

        new Thread(new Runnable() {
            public void run() {
                writeLock.lock();
                atomicInteger.set(11);
                System.out.println("线程id：" + Thread.currentThread().getId() + " 读取到变量的值为：" + atomicInteger.get());
                writeLock.unlock();
            }
        }).start();

    }


    public static void main(String args[]) {

        new ReentrantReadWriteLockDemo().verifyReentrantReadWriteLock();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }

}
