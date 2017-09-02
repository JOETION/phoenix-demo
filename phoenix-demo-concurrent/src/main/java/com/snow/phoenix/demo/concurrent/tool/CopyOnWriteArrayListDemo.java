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

package com.snow.phoenix.demo.concurrent.tool;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/3          FXY        Created
 **********************************************
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写拷贝链表案列
 * <p/>
 * 写拷贝链表，多线程下一边遍历一边移除不会报错，可以放心使用
 * 普通链表，多线程下一边遍历一边移除会报并发修改错误，需使用同步机制
 *
 * @NotNull 用于标注某个参数，某个变量，某个方法不为空
 * @Nullable 用于标注某个参数，某个变量，某个方法可以为空
 */
public class CopyOnWriteArrayListDemo {

    //TODO 此处存在bug，存在并发问题

    //写拷贝链表
    private final List<Integer> arrayList = new CopyOnWriteArrayList() {{
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);
    }};

    //普通链表
    private final List<Integer> integers = new ArrayList<Integer>() {{
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);
    }};

    private volatile boolean running = true;

    //验证CopyOnWriteArrayList
    private void verifyCopyOnWriteArrayList() {

        /**
         *  这两处都一边遍历，一边移除，但不会报错，因为每次都会去读链表的大小
         *  如果将链表大小设为固定的变量值，就会报数组下标越界异常
         *  如：
         *  int size=arrayList.size();
         *  for(int i=0;i<size;i++)
         *  {
         *         if (i == 1)
         arrayList.remove(i);
         System.out.println("arrayList：index：" + i + " value：" + arrayList.get(i));
         *  }
         *  就会报错
         *
         */

    /*    System.err.println("开始验证写拷贝链表");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 4)
                arrayList.remove(i);
            else
                System.out.println("arrayList：index：" + i + " value：" + arrayList.get(i));
        }

        for (int i = 0; i < integers.size(); i++) {
            if (i == 4)
                integers.remove(i);
            else
                System.out.println("integers：index：" + i + " value：" + integers.get(i));
        }
*/


        //多线程环境测试写拷贝链表
   /*     new Thread(new Runnable() {
            public void run() {
                while (running) {
                    for (Integer integer : arrayList)
                        System.out.println("线程id：" + Thread.currentThread().getId() + " 得到的值为：" + integer);
                }
            }
        }).start();*/

        //保证所有线程的正常发布，模拟每次请求的时间间隔，事实上每次请求都有时间间隔的，线上环境可以直接去掉
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断，原因：" + e);
        }


        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    arrayList.remove(finalI);
                    Iterator iterator = arrayList.iterator();
                    while (iterator.hasNext()) {
                        System.out.println("线程Id：" + Thread.currentThread().getId() + "得到的值为：" + iterator.next());
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


       /* try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断了，原因：" + e);
        }

        running = false;
        for (int i = 0; i < arrayList.size(); i++)
            System.out.println("得到的结果值为：" + arrayList.get(i));
*/






  /*      //多线程环境测试普通链表
        running = true;
        new Thread(new Runnable() {
            public void run() {
                while (running) {
                    for (Integer integer : integers)
                        System.out.println("线程id：" + Thread.currentThread().getId() + " 得到的值为：" + integer);
                }
            }
        }).start();


        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    integers.remove(finalI);
                }
            }).start();
        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断了，原因：" + e);
        }
        running = false;
        for (Integer integer : integers)
            System.out.println("多线程操作后的结果：" + integer);*/


    }


    public static void main(String args[]) {

        new CopyOnWriteArrayListDemo().verifyCopyOnWriteArrayList();
        //添加jvm关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }

}
