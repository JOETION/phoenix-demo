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
 *    2017/9/22          FXY        Created
 **********************************************
 */


import com.snow.phoenix.demo.concurrent.base.annotation.ThreadSafe;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 线程等待案列
 * <p>
 * 可以看出，Join方法实现是通过wait（小提示：Object 提供的方法）。 当main线程调用t.join时候，
 * main线程会获得线程对象t的锁（wait 意味着拿到该对象的锁),调用该对象的wait(等待时间)，
 * 直到该对象唤醒main线程 ，比如退出后。这就意味着main 线程调用t.join时，必须能够拿到线程t对象的锁。
 * <p>
 * 参考网址：<a>http://www.cnblogs.com/techyc/p/3286678.html</a>
 */
@ThreadSafe
public class JoinDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new JoinThread("One"));
        Thread thread2 = new Thread(new JoinThread("Two"));
        thread1.start();
        thread2.start();
        try {
            thread1.join();  //join()方法会调用wait()方法，导致主线程阻塞，过了wait（time）的等待时间，主线程继续执行
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }


    static class JoinThread implements Runnable {

        private String name;

        public JoinThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.printf("%s begins: %s\n", name, new Date());
            try {
                //休眠4秒，保证每个线程都能够运行到这里
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s has finished: %s\n", name, new Date());
        }
    }

}