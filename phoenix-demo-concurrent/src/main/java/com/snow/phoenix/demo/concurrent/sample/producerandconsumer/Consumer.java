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
 * 消费者往从仓库里面消费东西
 */
public class Consumer extends Thread {

    private Repository repository;

    public Consumer(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                MeatPojo meatPojo = (MeatPojo) repository.get();
                System.out.println("消费者消费了：" + meatPojo.getWeight() + " 斤 " + meatPojo.getType());
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("消费者从仓库里面消费东西失败，原因：" + e);
                break;
            }
        }
    }


    //不是最优雅的停止方式，可以另开一个线程专门用来控制生产者和消费者的调度策略
 /*   @Override
    public void interrupt() {
        while (true) {
            if (repository.isEmpty())
                break;
        }
        super.interrupt();
    }*/

}
