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

package com.snow.phoenix.demo.base.java8.lambda.group;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2019/5/3          FXY        Created
 **********************************************
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 启动类
 * <p>参考网址：</p><br/>
 * <a>https://www.cnblogs.com/hahajava/p/9204500.html</a>
 */
public class Main {

    private List<Apple> list = new ArrayList<Apple>() {
        {
            add(new Apple(1, "苹果1", 3.25, 10));
            add(new Apple(1, "苹果2", 1.35, 20));
            add(new Apple(2, "香蕉", 2.89, 30));
            add(new Apple(3, "荔枝", 9.99, 40));
        }
    };//存放apple对象集合

    public static void main(String args[]) {
        new Main().logicOps();
        new Main().filterOps();
        new Main().groupOps();
    }

    /**
     * 基本算术操作
     */
    private void logicOps() {
        System.out.println(list.stream().mapToDouble(value -> {
            return value.getMoney();
        }).sum());//和
        System.out.println(list.stream().mapToDouble(Apple::getMoney).max());//最大
        System.out.println(list.stream().mapToDouble(Apple::getMoney).min());//最小
        System.out.println(list.stream().mapToDouble(Apple::getMoney).average());//平均值
    }

    /**
     * 分组操作
     */
    private void groupOps() {

        //1.1根据某个属性分组计数
        Map<Integer, Long> groupByCount = list.stream().collect(Collectors.groupingBy(Apple::getId, Collectors.counting()));
        System.out.println(groupByCount);

        //List里面的对象元素，以某个属性来分组，例如，以id分组，将id相同的放在一起
        Map<Integer, List<Apple>> groupById = list.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println(groupById);

        //1.2根据整个实体对象分组计数,当其为String时常使用
        Map<Apple, Long> groupByObj = list.stream().collect(Collectors.groupingBy(Function.<Apple>identity(), Collectors.counting()));
        System.out.println(groupByObj);

        //2.分组，并统计其中一个属性值得sum或者avg:id总和
        Map<Integer, Double> groupByLogicResult = list.stream().collect(
                Collectors.groupingBy(Apple::getId, Collectors.summingDouble(Apple::getMoney))
        );
        System.out.println(groupByLogicResult);
    }

    /**
     * 过滤操作
     * 从集合中过滤出来符合条件的元素(map只是覆盖属性，filter根据判断属性来collect宿主bean)
     */
    private void filterOps() {
        List<Apple> filterList = list.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());
        System.out.println("filterList:" + filterList);
    }

}
