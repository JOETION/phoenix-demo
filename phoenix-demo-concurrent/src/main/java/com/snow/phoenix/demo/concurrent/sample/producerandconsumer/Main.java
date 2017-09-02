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

package com.snow.phoenix.demo.concurrent.sample.producerandconsumer;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/1          FXY        Created
 **********************************************
 */


/**
 * 程序入口
 */
public class Main {


    public static void main(String args[]) throws InterruptedException {
        Repository<MeatPojo> repository = Repository.createRepository();
        Producer producer = new Producer(repository);
        Producer producer1 = new Producer(repository);
        Producer producer2 = new Producer(repository);
        Consumer consumer = new Consumer(repository);
        Consumer consumer1 = new Consumer(repository);

        DispatchFactory dispatchFactory = DispatchFactory.createDispatchFactory();
        dispatchFactory.add(producer);
        dispatchFactory.add(producer1);
        dispatchFactory.add(producer2);
        dispatchFactory.add(consumer);
        dispatchFactory.add(consumer1);
        dispatchFactory.setRepository(repository);
        dispatchFactory.startAll();
        Thread.currentThread().sleep(10000); //主线程休眠10秒，模拟生产者生产10秒，消费者消费10秒
        dispatchFactory.stop(3);
        dispatchFactory.stop(4);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }
}
