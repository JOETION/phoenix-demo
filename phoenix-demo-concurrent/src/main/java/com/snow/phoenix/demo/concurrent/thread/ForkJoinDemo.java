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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin案列
 * <p>
 * Fork/Join框架是Java7提供了的一个用于并行执行任务的框架， 是一个把大任务分割成若
 * 干个小任务，最终汇总每个小任务结果后得到大任务结果的框架。
 * <p>
 * 参考网址：<a>http://www.infoq.com/cn/articles/fork-join-introduction</a>
 */
@ThreadSafe
public class ForkJoinDemo {

    //函数入口
    public static void main(String args[]) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 30);  //求前五个数的和
        ForkJoinTask<Integer> task = forkJoinPool.submit(countTask); //继承了future，封装了一些其他特性，比如异常信息等
        try {
            //抛出异常异常结束
            if (task.isCompletedAbnormally()) {
                System.out.println(task.getException().getMessage());
            } else {
                System.out.println(task.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.err.println("所有线程已正常关闭，JVM即将退出");
            }
        }));

    }

    //计数任务
    static class CountTask extends RecursiveTask<Integer> {

        private static final int THRESHOLD = 2; //阈值

        private int start;
        private int end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }


        //调用fork函数时，会调用这个函数
        @Override
        protected Integer compute() {
            int sum = 0;
            //如果任务足够小就计算任务
            boolean canCompute = (end - start) <= THRESHOLD;
            if (canCompute) {
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                //如果任务大于阈值，就分成两个任务计算
                int middle = (start + end) / 2;
                CountTask leftTask = new CountTask(start, middle);
                CountTask rightTask = new CountTask(middle + 1, end);
                //执行子任务
                leftTask.fork();
                rightTask.fork();
                //等待子任务执行完成
                int leftResult = leftTask.join();
                int rightResult = rightTask.join();

                sum = leftResult + rightResult;

            }

            return sum;
        }
    }

}
