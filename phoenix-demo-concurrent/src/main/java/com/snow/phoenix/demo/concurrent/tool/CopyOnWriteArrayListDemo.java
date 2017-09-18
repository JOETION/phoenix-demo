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
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写拷贝链表案列
 * <p>
 * 写拷贝链表，多线程下一边遍历一边移除不会报错，可以放心使用
 * 普通链表，多线程下一边遍历一边移除会报并发修改错误，需使用同步机制
 *
 * @NotNull 用于标注某个参数，某个变量，某个方法不为空
 * @Nullable 用于标注某个参数，某个变量，某个方法可以为空
 * <p>
 * CopyOnWriteArrayList原理：
 * 内部维护了一个名为array的实例变量，用于储存集合的各个元素。
 * 在集合中添加了一个元素的时候，会生成一个新的数组，并将集合中现有的元素复制到新的数组中，
 * 然后将新的数组的最后一个元素设置为要添加的元素。这个新的数组会直接赋值给array实例变量。
 * <p>
 * CopyOnWriteArrayList适合使用在读操作远远大于写操作的场景里，比如缓存。
 * @see <a>http://blog.csdn.net/samjustin1/article/details/52259330</a>
 */


public class CopyOnWriteArrayListDemo {

    //写拷贝链表，可以直接构造一个普通链表为CopyOnWriteArrayList
    private final List<Integer> copyOfList = new CopyOnWriteArrayList() {{
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);
    }};

    //普通链表
    private final List<Integer> list = new ArrayList<Integer>() {{
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);
    }};

    //可见的状态变量
    private volatile boolean running = true;


    //验证ArrayList，此处主要与CopyOnWriteArrayList做比较，此处线程不安全
    public void verifyArrayList() {
        //多线程环境测试普通链表
        running = true;
        new Thread(new Runnable() {
            public void run() {
                while (running) {
                    for (Integer integer : list)
                        System.out.println("线程id：" + Thread.currentThread().getId() + " 得到的值为：" + integer);
                }
            }
        }).start();

        //一秒钟之后开始删除数据
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断了，原因：" + e);
        }

        //随机移除一个数
        list.remove(1);

        //一秒钟之后结束遍历
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断了，原因：" + e);
        }
        running = false;
        for (Integer integer : list)
            System.out.println("多线程操作后的结果：" + integer);
    }


    //验证CopyOnWriteArrayList，线程安全
    private void verifyCopyOnWriteArrayList() {
        running = true;
        //多线程环境测试写拷贝链表
        new Thread(new Runnable() {
            public void run() {
                while (running) {
                    for (Integer integer : copyOfList)
                        System.out.println("线程id：" + Thread.currentThread().getId() + " 得到的值为：" + integer);
                }
            }
        }).start();

        //1秒钟之后开始删除数据
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断，原因：" + e);
        }

        //随机移除一个数
        copyOfList.remove(1);

        //1秒钟之后停止遍历
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("阻塞中的线程被中断了，原因：" + e);
        }
        running = false;

        for (int i = 0; i < copyOfList.size(); i++)
            System.out.println("得到的结果值为：" + copyOfList.get(i));


    }


    public static void main(String args[]) {

        new CopyOnWriteArrayListDemo().verifyCopyOnWriteArrayList();
//        new CopyOnWriteArrayListDemo().verifyArrayList();

        //添加jvm关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));
    }

}
