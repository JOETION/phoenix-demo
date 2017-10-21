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
 *    2017/10/21          FXY        Created
 **********************************************
 */

import com.snow.phoenix.demo.concurrent.base.annotation.ThreadSafe;

/**
 * Thread.yield()，线程由运行态转为就绪态，仍然有机会执行，作用与sleep()相同，只是不能指定休眠的具体时间，不会释放锁
 * Thread.sleep()，线程由运行态转为就绪态，仍然有机会执行，可以指定具体的休眠时间，会释放锁
 * Thread.join()，线程由运行态转为阻塞态，当前线程等待，释放锁，需要其他线程执行完成才能重新获得锁
 * 参考网址：
 * <br/>
 * <a>http://www.cnblogs.com/lovefeng/p/4675125.html</a>
 */

@ThreadSafe
public class YieldDemo {

    //程序入口
    public static void main(String args[]) {

        //线程一
        new Thread(new YieldThread("t1")).start();

        //线程二
        new Thread(new YieldThread("t2")).start();

    }


    //yield线程
    static class YieldThread implements Runnable {

        private String name;

        public YieldThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 30; i++) {
                System.out.println(name + ":" + i);
                if (("t1").equals(name)) {
                    if (i == 0) {
                        Thread.currentThread().yield();
                    }
                }
            }
        }
    }

}
