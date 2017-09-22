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

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * exchanger案列
 * 只要用于两个线程之间交换数据，类似于PipeWriter，PipeReader（管道流）
 * <br>
 * 参考网址： <a>https://www.2cto.com/kf/201209/157884.html</a>
 */
@ThreadSafe
public class ExchangerDemo {


    /**
     * 两个线程都有各自String类型的data，并且各自的sleep时间都不一样。
     * 类中定义了一个Exchanger对象，作为两个线程交换数据的通道，
     * 当其中一个线程运行exchanger.exchange()；方法时，由于没有另外一个线程
     * 还没有开始执行这个交换方法，所以就需要等到另外一个线程也提出交换时，
     * 两个线程才可以完成信息的交换
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Exchanger exchanger = new Exchanger();
        service.execute(new Runnable() {
            public void run() {
                try {
                    String sendName = "fxy";
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "正在把数据" + sendName + "换出去");
                    Thread.sleep((long) (Math.random() * 10000));
                    String getName = (String) exchanger.exchange(sendName);
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "换回的数据为" + getName);
                } catch (Exception e) {
                }
            }
        });
        service.execute(new Runnable() {
            public void run() {
                try {
                    String sendName = "flz";
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "正在把数据" + sendName + "换出去");
                    Thread.sleep((long) (Math.random() * 10000));
                    String getName = (String) exchanger.exchange(sendName);
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "换回的数据为" + getName);
                } catch (Exception e) {
                }
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }

}
