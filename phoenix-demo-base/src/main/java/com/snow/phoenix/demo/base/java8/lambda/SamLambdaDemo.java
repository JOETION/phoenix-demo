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

package com.snow.phoenix.demo.base.java8.lambda;

/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/17          FXY        Created
 **********************************************
 */


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Single Abstract Method 单一抽象方法lambda案列
 * 见名知意，只有一个抽象方法的接口
 * 请将jdk版本，和编译器版本设置为1.8或以上
 */
public class SamLambdaDemo {

    private void stream() {
        //获取字符串的流
        Stream<String> stringStream = Stream.of("111", "222");
        //获取整形数据的流
        Stream<Integer> integerStream = Stream.of(222);
        //获取链表的流
        Stream<List<String>> listStream = Stream.of(Arrays.asList("123", "235"));
        //获取链表中数据的流
        Stream<String> listContentStream = Arrays.asList("123", "235").stream();
        //获取到的是集合里面数据的流，比如此处集合中的数据是字符串，此处获取到的就是Stream<String>而不是Stream<List<String>>
        Stream<String> stream = Arrays.stream(new String[]{"123", "234"});
    }

    //新开线程
    public void newRunnableLambda() {
        new Thread(() -> {
            System.out.println("用lambda表达式代替匿名内部类");
        }).start();
    }

    //比较大小
    public void newComparatorLambda() {
        //第一种，数组的lambda表达式的使用
        String[] datas = new String[]{"peng", "zhao", "li"};
        Arrays.sort(datas, (v1, v2) -> Integer.compare(v1.length(), v2.length()));
        Stream.of(datas).forEach(param -> System.out.println(param));


        //第二种，链表的lambda表达式的使用
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.sort((a, b) -> a > b ? 1 : 0);
        Stream.of(list).forEach(param -> System.out.println(param));
    }

    public static void main(String args[]) {
        SamLambdaDemo samLambdaDemo = new SamLambdaDemo();
        samLambdaDemo.newRunnableLambda();
        samLambdaDemo.newComparatorLambda();
    }
}
