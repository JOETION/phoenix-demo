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


import java.util.ArrayList;
import java.util.List;

/**
 * 调度器工厂
 */
public class DispatchFactory<T extends Thread> {

    private final List<T> threads = new ArrayList<T>();

    private Repository repository;

    private DispatchFactory() {
    }

    public static DispatchFactory createDispatchFactory() {
        return new DispatchFactory();
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void add(T t) {
        threads.add(t);
    }

    public T get(int index) {
        return threads.get(index);
    }

    public void remove(int index) {
        stop(index);
        threads.remove(index);
    }

    public void startAll() {
        for (Thread thread : threads)
            thread.start();
    }

    public void stopAll() {
        //停止所有生产者
        for (Thread thread : threads) {
            if (thread instanceof Producer) {
                thread.interrupt();
            }
        }
        //等待仓库里面的东西被消费者消费完
        while (true) {
            if (repository.isEmpty())
                break;
        }
        //停止所有消费者
        for (Thread thread : threads) {
            if (thread instanceof Consumer && thread.isInterrupted() == false) {
                thread.interrupt();
            }
        }


    }

    public void start(int index) {
        threads.get(index).start();
    }


    public void stop(int index) {

        int consumerCount = 0;
        int producerCount = 0;
        for (Thread thread1 : threads) {
            if (thread1 instanceof Consumer && thread1.isInterrupted() == false) {
                consumerCount++;
            } else if (thread1 instanceof Producer && thread1.isInterrupted() == false) {
                producerCount++;
            }
        }

        Thread thread = threads.get(index);
        if (thread == null)
            return;

        //如果是生产者,生产者个数大于1个，则直接停掉，如果小于等于一个，则停掉所有生产者和消费者
        if (thread instanceof Producer && producerCount > 1) {
            thread.interrupt();
        } else if (thread instanceof Producer && producerCount <= 1) {
            stopAll();
        }

        //如果是消费者，则先判断是否只有一个消费者，如果只有一个消费者，则需要等待仓库为空，如果不止一个消费者且至少一个生产者，则直接停掉即可
        if (thread instanceof Consumer && consumerCount > 1 && producerCount >= 1) {
            thread.interrupt();
        } else if (thread instanceof Consumer && consumerCount <= 1) {
            stopAll();
        } else {
            stopAll();
        }

    }

}
