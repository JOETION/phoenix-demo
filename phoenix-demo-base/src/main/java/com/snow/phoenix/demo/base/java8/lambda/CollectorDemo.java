package com.snow.phoenix.demo.base.java8.lambda;

/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2020-11-09          FXY        Created
 **********************************************
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * Collector案列
 *
 */
public class CollectorDemo {

    //普通集合收集器
    private void normalCollector(){
        //初始化链表
        List<String> strings = Arrays.asList("fang", "xiao", "yong", "go", "!");
        //过滤掉叹号的字符串，并用List进行收集
        List<String> list = strings.stream().filter(a -> a.equals("!")).collect(Collectors.toList());
        //将链表进行反序操作，然后用Set进行收集
        Set<String> set = strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toSet());
    }

    //map收集器
    private void mapCollector(){
        //初始化列表
        List<Pojo> pojos = Arrays.asList(new Pojo("123", "fang"), new Pojo("456", "xiao"), new Pojo("123", "yong"));
        //转换为map，key为id,value为对象，如果出现两个key相同的情况，以第一个为准
        Map<String, Pojo> id2MapOne = pojos.stream().collect(Collectors.toMap(a -> a.getId(), b -> b,(c, d)->c));
        //方式二
        Map<String, Pojo> id2MapTwo = pojos.stream().collect(Collectors.toMap(Pojo::getId, a -> a, (b, c) -> b));
    }

    //分组收集器
    private void groupCollector(){
        //初始化列表
        List<Pojo> pojos = Arrays.asList(new Pojo("123", "fang"), new Pojo("456", "xiao"), new Pojo("123", "yong"));

        //方式一，默认分组收集器为List
        Map<String, List<Pojo>> groupByIdOne = pojos.stream().collect(Collectors.groupingBy(Pojo::getId));

        //方式二，自定义分组收集器
        Map<String, Set<Pojo>> groupByIdTwo = pojos.stream().collect(Collectors.groupingBy(a -> a.getId(), Collectors.toSet()));

        //方式三，自定义分组收集器，且用指定的map进行分组，可以保留原map中的数据
        Map<String, List<Pojo>> groupByThree = pojos.stream().collect(Collectors.groupingBy(Pojo::getId, Collections::emptyMap, Collectors.toList()));

    }
    //分区收集器
    private void partitionCollector(){
        //初始化列表
        List<Pojo> pojos = Arrays.asList(new Pojo("123", "fang"), new Pojo("456", "xiao"), new Pojo("123", "yong"));
        //用id进行分区，满足条件的在一个true区，不满足条件的在false区
        Map<Boolean, List<Pojo>> partitionByIdOne = pojos.stream().collect(Collectors.partitioningBy(a -> a.getId().equals("123")));
        //用id进行分区，并指定下级流收集器，满足条件的true区，不满足条件的在false区
        Map<Boolean, Set<Pojo>> partitonByIdTwo = pojos.stream().collect(Collectors.partitioningBy(a -> a.getId().equals("123"), Collectors.toSet()));
    }

    //数据统计收集器
    private void summingCollector(){
        //数据统计收集器
        IntSummaryStatistics intSummaryStatistics = Arrays.asList(123, 123, 678, 890, 200).stream().collect(Collectors.summarizingInt(a -> a));
        //取得平均值
        double average = intSummaryStatistics.getAverage();
        //取得数据个数
        long count = intSummaryStatistics.getCount();
        //取得最大数
        int max = intSummaryStatistics.getMax();
        //取得最小数
        int min = intSummaryStatistics.getMin();
        //取得总和
        long sum = intSummaryStatistics.getSum();
    }

    private static class Pojo{
        private String id;
        private String name;

        public Pojo(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }
    }

}
