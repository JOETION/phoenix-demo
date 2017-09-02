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


import com.snow.phoenix.demo.concurrent.base.annotation.GuardedBy;
import com.snow.phoenix.demo.concurrent.base.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 等待唤醒案列
 * <p/>
 * wait()和notifyAll()是针对于线程而言，等待和唤醒的都是线程，而不是指某一个具体的对象或某一个线程变量，
 * <p/>
 * wait()和notifyAll()必须获得相同的锁，wait()时释放锁，请求操作系统挂起自己，notify()时获得锁，并又操作系统唤醒自己
 * <p/>
 * notify()时，操作系统随机唤醒一个在该锁上等待的线程，并不一定会唤醒某个指定的线程，一般都.是使用的notifyAll()
 */
@ThreadSafe
public class WaitNotifyAllDemo {

    private final AtomicReference<BaseBoundedBuffer> atomicReference = new AtomicReference<BaseBoundedBuffer>();

    //20个闭锁
    private final CountDownLatch countDownLatch = new CountDownLatch(20);

    public WaitNotifyAllDemo() {
        BaseBoundedBuffer<String> boundedBuffer = new BaseBoundedBuffer<String>();
        atomicReference.set(boundedBuffer);
    }

    //验证
    private void verifyWaitNotifyAll() {

        System.err.println("开始初始化10个线程");
        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await();
                        put(Thread.currentThread().getName());
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
                        String name = (String) take();
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

    public synchronized void put(Object object) {
        try {
            System.out.println("当前线程是：" + Thread.currentThread().getName());//查看当前线程
            while (atomicReference.get().isFull())
                wait();  //当前线程等待，既那个线程调用的这个方法，那个线程就会等待
            atomicReference.get().doPut(object);
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("被阻塞的线程被中断了，原因：" + e);
        }
    }

    public synchronized Object take() {
        try {
            System.out.println("当前线程是：" + Thread.currentThread().getName());//查看当前线程
            while (atomicReference.get().isEmpty())
                wait();  //当前线程等待，既那个线程调用的这个方法，那个线程就会等待
            Object object = atomicReference.get().doTake();
            notifyAll();
            return object;
        } catch (InterruptedException e) {
            System.out.println("被阻塞的线程被中断了，原因：" + e);
        }
        return null;
    }

    public static void main(String args[]) {

        new WaitNotifyAllDemo().verifyWaitNotifyAll();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }


    public static class BaseBoundedBuffer<V> {

        //构造队列
        @GuardedBy(lock = "this")
        private final V[] buffer = (V[]) new Object[1000];

        //队列尾，头索引，以及队列当前大小
        @GuardedBy(lock = "this")
        private int tail, head, count;

        public synchronized final void doPut(V v) {
            buffer[tail] = v;
            if (++tail == buffer.length)
                tail = 0;
            ++count;

        }

        public synchronized final V doTake() {
            V v = buffer[head];
            buffer[head] = null;
            if (++head == buffer.length)
                head = 0;
            --count;
            return v;
        }

        public synchronized boolean isFull() {
            return count == buffer.length;
        }

        public synchronized boolean isEmpty() {
            return count == 0;
        }
    }

}
