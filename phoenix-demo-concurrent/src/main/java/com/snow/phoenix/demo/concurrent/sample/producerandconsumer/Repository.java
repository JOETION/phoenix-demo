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


import com.snow.phoenix.demo.concurrent.base.annotation.ThreadSafe;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 仓库
 * <p/>
 * 凡是起仓库作用的，都可以用泛型来保证某个类中存的都是同一类型的变量，省去了强制转换的麻烦
 */
@ThreadSafe
public class Repository<T> {

    //阻塞队列，与ConcurrentLinkedQueue类作用一样，但是BlockingQueue使用的是可重入锁实现的，而ConcurrentLinkedQueue使用的是CAS实现的
    private final BlockingQueue<T> blockingQueue = new LinkedBlockingQueue<T>();

    private Repository() {
    }

    public static <T> Repository<T> createRepository() {
        return new Repository<T>();
    }

    //放入生产的东西
    public void put(T t) throws InterruptedException {
        blockingQueue.put(t);
    }

    //消费生产的东西
    public T get() throws InterruptedException {
        return blockingQueue.take();
    }

    //得到当前队列大小
    public boolean isEmpty() {
        return blockingQueue.isEmpty();
    }

}
