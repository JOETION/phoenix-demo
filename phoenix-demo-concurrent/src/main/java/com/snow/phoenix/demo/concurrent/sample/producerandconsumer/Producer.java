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
 * 生产者往仓库里面生产东西
 */
public class Producer extends Thread {


    private Repository repository;


    public Producer(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            MeatPojo meatPojo = new MeatPojo();
            meatPojo.setWeight(10);
            meatPojo.setType("猪肉");
            try {
                repository.put(meatPojo);
                System.out.println("生产者生产了：" + meatPojo.getWeight() + " 斤 " + meatPojo.getType());
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("生产者生产的东西放入仓库失败！原因：" + e);
                break;
            }
        }

    }

}
