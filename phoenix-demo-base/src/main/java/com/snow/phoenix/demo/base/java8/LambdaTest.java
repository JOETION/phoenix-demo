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

package com.snow.phoenix.demo.base.java8;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2020/3/20          FXY        Created
 **********************************************
 */


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest implements EventListener {

    public static class IntermdiateStreamLambda {

        public void mapOfStream() {
            String[] a = new String[]{"1", "2", "3", "4", "5"};
            //Stream.of(a);//而这里面仅仅是一个数组，而数组中有仅仅有一个流，故获得的是String 流
            List<Integer> collect = Stream.of(a).map(Integer::parseInt).collect(Collectors.toList());
            //Stream.of(collect);//list有个流，Integer有个流，stream.of()会获得全部的流
            for (Integer integer : collect) {
                System.out.println(integer);
            }

            Integer[] integers = Stream.of(a).map(b -> {
                return Integer.parseInt(b);
            }).toArray(Integer[]::new);

            for (Integer integer : integers) {
                System.out.println(integer);
            }

        }

        public void flatMapOfStream() {
            String[][] a = new String[][]{{"fang"}, {"xiao"}, {"yong"}};
            List<String> collect = Stream.of(a).flatMap(b -> Stream.of(b)).collect(Collectors.toList());
            collect.stream().forEach(c -> {
                System.out.println(c);
            });

            List<String> list = Arrays.asList("fang", "xiao", "yong");
            List<String[][]> collect1 = list.stream().map(b -> new String[][]{{b}}).collect(Collectors.toList());//这句很重要，注意查看参数和返回值
// Stream.of(list).map(b -> new String[][]{{b}}).collect(Collectors.toList());//注意区分这句
        }

        public void filterOfSteam() {
            Integer integers[] = new Integer[]{1, 2, 3, 4, 5};
            List<Integer> collect = Stream.of(integers).filter(a -> a % 2 == 0).collect(Collectors.toList());
            collect.stream().forEachOrdered(a -> {
                System.out.println(a);
            });

            List<Integer> collect1 = Arrays.stream(integers).filter(a -> a % 2 == 0).filter(a -> a > 0).collect(Collectors.toList());
            for (Integer integer : collect1) {
                System.out.println(integer);
            }
        }

        public void distinctOfStream() {
            List<String> list = Arrays.asList("fang", "xiao", "yong", "li");
            List<String> collect = list.stream().filter(a -> a.length() > 2).distinct().collect(Collectors.toList());
            collect.stream().forEach(a -> {
                System.out.println(a);
            });


        }

        public void sortedOfStream() {
            List<Integer> a = new ArrayList<Integer>() {{
                add(2);
                add(1);
                add(5);
                add(6);
                add(7);
                add(1);
            }};

            List<Integer> collect = a.stream().sorted(Comparator.<Integer>naturalOrder()).collect(Collectors.toList());
            for (Integer integer : collect) {
                System.out.println(integer);
            }

        }

        public void peekOfStream() {
            List<String> collect = Stream.of("one", "two", "three", "four")
                    .peek(e -> System.out.println(e))
                    .map(String::toUpperCase)
                    .peek(e -> System.out.println(e))
                    .collect(Collectors.toList());
            for (String s : collect) {
                System.out.println(s);
            }
        }

        public void limitOfStream() {
            List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 3, 7, 2, 1);
            List<Integer> collect = list.stream().distinct().sorted(Comparator.<Integer>naturalOrder()).limit(3).collect(Collectors.toList());
            for (Integer integer : collect) {
                System.out.println(integer);
            }
        }

        public void skipOfStream() {
            List<Integer> list = Arrays.asList(1, 2, 43, 21, 456, 123);
            //skip不是指跳过索引位置的值，而是指跳过的条数
            List<Integer> collect = list.stream().filter(a -> a < 100).sorted(Comparator.<Integer>naturalOrder()).skip(1).collect(Collectors.toList());
            collect.stream().forEach(a -> System.out.println(a));
        }

    }


    public static class TerminalStreamLambda {

        //接口上标注@FunctionalInterface可以自己编写lambda表达式
        //并行遍历流
        public void foreachOfStream() {
            Map<String, Integer> map = new HashMap<String, Integer>() {{
                put("fang", 100);
                put("xiao", 200);
                put("yong", 300);
            }};
            map.forEach((key, value) -> {
                System.out.println("key: " + key + " value: " + value);
            });
        }

        //集合分组操作
        public void groupOfStream() {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2, 5);
            Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
            collect.forEach((key, value) -> {
                System.out.println("关键字：" + key + " 有：" + value + " 个");
            });
        }

        //链表转换为数组案例
        public void toArrayOfStream() {
            List<String> list = Arrays.asList("1", "2", "3", "4");
            Integer[] integers = list.stream().map(a -> Integer.parseInt(a)).toArray(Integer[]::new);
            Stream.of(integers).forEach(a -> System.out.println(a));
        }


        public void reduceOfStream() {
            List<Integer> list = Arrays.asList(21, 123, 12, 424);
            Integer integer = list.stream().reduce((result, item) -> {
                return result + item;
            }).get();
            System.out.println("和为：" + integer);

            Integer reduce = list.stream().reduce(0, (result, item) -> {
                return result + item;
            });
            System.out.println("和为：" + reduce);

            //使用自定义的实例方法，不能通过静态的方式来访问，若将此处sum方法改为静态的，不是在lambda表达式中可以正常访问，但是在lambada表达式中不能正常访问，此处有点小问题
            Integer reduce1 = list.stream().reduce(0, new TerminalStreamLambda()::sum);
//            Integer reduce2 = list.stream().reduce(0, Integer::sum);
            System.out.println("和为：" + reduce1);

            //使用集合函数进行运算
            int sum = list.stream().mapToInt(a -> a).sum();
            System.out.println("和为：" + sum);
        }

        int sum(int a, int b) {
            return a + b;
        }

        public void maxOrMinOfStream() {
            List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 6, 7, 5, 7);
            Integer min = list.stream().min(Comparator.comparing(a -> a)).get();
            System.out.println("最小的值为:" + min);
            Integer max = list.stream().max(Comparator.comparing(a -> a)).get();//max请求的comparator,而Comparator.comparing()返回的是一个comparator,max根据comparator来选择值
//lambda表达式中，箭头源是参数，箭头目的是返回值，若有多个参数，用括号表示，若返回值需要进行处理，需要用花括号处理语句
            System.out.println("最大的值为:" + max);
        }

        public void countOfSteam() {
            List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 6, 7, 5, 7);
            long count = list.stream().count();
            System.out.println("长度为：" + count);
        }

        //predicate 谓语，也就是我们所说的逻辑表达式，为true或者false，带上泛型表示该类型的逻辑的表达式
        public void allMatchOfStream() {
            List<Integer> list = Arrays.asList(12, 32, 453, 23, 234);
            boolean allMatch = list.stream().allMatch(a -> a > 0);//传入一个predicate,然后allMatch会自动调用里面test()方法
            boolean anyMatch = list.stream().anyMatch(a -> a > 20);
            boolean noneMatch = list.stream().noneMatch(a -> a < 12);
            System.out.println("allMatch: " + allMatch);
            System.out.println("anyMatch: " + anyMatch);
            System.out.println("noneMatch: " + noneMatch);
        }


        //predicate 谓语，也就是我们所说的逻辑表达式，为true或者false，带上泛型表示该类型的逻辑的表达式
        public void predicateOfStream() {
            Predicate<Integer> boolValue = x -> x > 5;//1.
            System.out.println(boolValue.test(1) + "");//2.
            System.out.println(boolValue.test(6) + "");//3.
        }

        public void findFirstOfStream() {
            List<Integer> list = Arrays.asList(1, 23, 324, 23);
            Integer integer = list.stream().filter(a -> a > 1).distinct().findFirst().get();
            System.out.println("筛选后数组中的第一个元素是：" + integer);
        }

        public void iteratorOfStream() {
            List<Integer> list = Arrays.asList(1, 23, 234, 4523);
            //Spliterator<Integer> spliterator = list.stream().spliterator();
            //Spliterator主要是用于并行遍历，而Iterator一般用于串行变量
            list.stream().iterator().forEachRemaining(a -> {
                System.out.println(a);
            });


            //双冒号（::）是 Java 8 引入 Lambda 表达式后的一种用法，表示方法引用（method reference），可以更加简洁的实例化接口
            // 双冒号表达式返回的是一个 函数式接口对象（用 @FunctionalInterface 注解的 interface 类型）的实例，
            //函数式接口表示该接口是一个包含函数引用的接口，里面的每个方法都是从调用方传过来的一个函数引用，调用该接口里面的方法，意味着
            //就会调用传过来的方法
            list.stream().iterator().forEachRemaining(System.out::println);
        }


    }

    public static void main(String args[]) {
//        new TerminalStreamLambda().groupOfStream();
        //第三个参数是并发操作时对顺序不用的两个结果集进行处理的逻辑，如果是并行操作则第三个参数没用，始终要注意一点，Collector是对于集合的流进行的操作，每一个流都是
        //集合中的一个元素
//        Integer length = Arrays.asList("123", "12432").stream().collect(Collector.of(() -> new int[1], (result, item) -> result[0] += item.length(), (result, result1) -> {
//            result[0] += result1[0];
//            return result;
//        }, a -> a[0]));
//        IntSummaryStatistics intSummaryStatistics = Arrays.asList("123", "23543", "ascac", "1233", "324").stream().collect(Collectors.summarizingInt(a -> Integer.parseInt(a)));
//        Map<String, String> stringMap = Arrays.asList("23423", "r42fs").stream().collect(Collectors.groupingBy(a -> a, Collectors.joining(",", "-", "m")));
//        Optional<String> maxString = Arrays.asList("safs", "dsvsd", "adsd213").stream().collect(Collectors.maxBy(Comparator.comparing(a -> a.length(), Comparator.comparingInt(a -> a))));
//        Map<Boolean, List<Integer>> collect = Arrays.asList("asda", "asfsdf", "dffgb").stream().collect(Collectors.partitioningBy(a -> a.startsWith("a"), Collectors.mapping(a -> a.length(), Collectors.toList())));
//        Integer firstNum = Arrays.asList("232", "123").stream().collect(Collectors.mapping(a -> Integer.parseInt(a), Collectors.collectingAndThen(Collectors.toList(), a -> a.get(0))));
//        ArrayList<String> listString = Arrays.asList("assd", "csd", "23432").stream().collect(Collectors.toCollection(ArrayList::new));
        String s = Arrays.asList("sdc", "csd", "3242").stream().collect(Collectors.reducing("=====", a -> a.toUpperCase(),(a,b)->a+b ));
        Integer sum = Arrays.asList("213", "123123", "3112").stream().collect(Collectors.reducing(10345000, a -> Integer.parseInt(a), (a, b) -> a + b));
        Map<Character, String> charMap = Arrays.asList("123", "ffe", "dvvs").stream().collect(Collectors.toMap(a -> a.charAt(0), a -> a));
        Arrays.asList("232","23sss","2432").stream().peek(System.out::println).close();
        Integer max = Arrays.asList("2142", "3r43r").stream().collect(Collectors.collectingAndThen(Collectors.summarizingInt(a -> Integer.parseInt(a)), a -> a.getMax()));
        System.out.println(s);
        System.out.println(sum);
        System.out.println(max);

    }
}
