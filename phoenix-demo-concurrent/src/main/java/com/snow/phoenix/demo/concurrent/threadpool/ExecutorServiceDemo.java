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

package com.snow.phoenix.demo.concurrent.threadpool;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/1          FXY        Created
 **********************************************
 */


import com.snow.phoenix.demo.concurrent.base.annotation.GuardedBy;
import com.snow.phoenix.demo.concurrent.base.annotation.ThreadSafe;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 线程池案列
 */
@ThreadSafe
public class ExecutorServiceDemo {

    /**
     * 工厂方法初始化，拥有一个私有的无参构造函数和一个静态的生产本类的方法
     */
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    private final Map<Long, Integer> map = new ConcurrentHashMap<Long, Integer>();

    private final Object lock = new Object();

    //final意味着不能再重新赋值
    @GuardedBy(lock = "lock")
    private int resourceValue = 0;


    //验证线程池
    private void verifyExecutorService() {

        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            Future<Long> longFuture = executorService.submit(new Callable<Long>() {
                public Long call() throws Exception {
                    synchronized (lock) {
                        resourceValue++;
                    }
                    map.put(Thread.currentThread().getId(), resourceValue);

                    //第50个任务，让它休眠1秒钟，以便可以取消，让它非正常结束
                    if (finalI == 50) {
                        Thread.currentThread().sleep(1000);
                    }
                    return Thread.currentThread().getId();
                }
            });

            if (i == 50) {
                longFuture.cancel(true);
            }

            try {

                if (longFuture.isCancelled()) {
                    System.out.println("第 " + i + " 个任务被强制取消了");
                } else {
                    //get为阻塞函数，如果没有取得值，就会一直阻塞在这里
                    try {
                        System.out.println(map.get(longFuture.get(1, TimeUnit.SECONDS)));
                    } catch (TimeoutException e) {
                        System.out.println("获取第 " + i + " 个任务执行结果时超时");
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("第 " + i + " 个阻塞中的线程被中断了，原因：" + e);
            } catch (ExecutionException e) {
                System.out.println("执行第 " + i + " 个任务时发生错误，原因：" + e);
            }
        }

        //关闭线程池
        executorService.shutdownNow();

    }


    public static void main(String args[]) {
        new ExecutorServiceDemo().verifyExecutorService();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }


}
