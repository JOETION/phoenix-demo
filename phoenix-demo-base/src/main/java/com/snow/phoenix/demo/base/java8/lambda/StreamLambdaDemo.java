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


import com.alibaba.fastjson.JSONObject;
import sun.util.resources.cldr.ga.LocaleNames_ga;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Predication noun.论断  Predicate verb.断言，断定
 * <p/>
 * 流Lambda表达式案例，这个主要用于List和Set
 * <p/>
 * 中间流：
 * map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
 * 终端流：
 * forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
 * 短路流（或属于中间流或属于终端流，主要用于缩小查找范围）：
 * anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
 * <p/>
 * lambda调用方法：
 * 容器::方法名
 * 类名::静态方法名
 * 类名::实例方法名
 * 构造函数::new
 */
public class StreamLambdaDemo {


    /**
     * 中间流案列
     */
    public static class IntermediateStreamLambdaDemo {

        //转换案例
        //将链表或数组中的每个元素进行某个批量操作，所有元素合在一起返回数组或链表
        //主要用来根据链表或数组中的数据来封装pojo
        public void mapOfStream() {

            //将String数组转换为Integer链表
            String[] strings = new String[]{"1", "2", "3", "4", "5"};
            //String[] copyOfStrings = Arrays.copyOf(strings, strings.length + 1);  复制数组数据到新的数组中
            List<Integer> integers = Stream.of(strings).map(string -> Integer.parseInt(string)).collect(Collectors.toList());
            for (Integer integer : integers) {
                System.out.println(integer);
            }

            System.out.println("=========================================");

            //将数组中的每个数据添加一个加号
            String[] array = Stream.of(strings).map(s -> {
                return s + "+";
            }).toArray(String[]::new);

            for (String s : array) {
                System.out.println(s);
            }


        }

        /**
         * 扁平化转换案例
         * 进行某种函数转换，将二维数组转换为一维数组
         */
        public void flatMapOfStream() {

            //将二维数组转换为一维数组
            String[][] strings = new String[][]{{"fang"}, {"xiao"}, {"yong"}, {"is"}, {"best"}};
            //先获取二维数组中子项的流，即一维数组，再获取一维数组中子项的流，即每个元素
            List<String> stringList = Arrays.stream(strings)
                    .flatMap(a -> Arrays.stream(a)).collect(Collectors.toList()); //将二维数组转换为一维数组

            stringList.stream().forEachOrdered(a -> {
                System.out.println(a);
            });

            //将一维数组转换为二维数组，遍历方法省略
            List<String> list = Arrays.asList("fang", "xiao", "yong");
            List<String[][]> collect = list.stream().map(a -> new String[][]{{a}}).collect(Collectors.toList());

        }

        /**
         * 过滤案例
         * 要求匿名函数返回值为boolean
         */
        public void filterOfStream() {

            //取出数组中的偶数
            Integer[] integers = new Integer[]{1, 2, 3, 4, 5};
            Integer[] array = Stream.of(integers).filter(a -> a % 2 == 0).toArray(Integer[]::new); //filter中的匿名函数返回值为boolean
            for (Integer integer : array) {
                System.out.println(integer);
            }

            System.out.println("=======================================");

            List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
            //filter方法会去调用Predicate中的test方法
            //filter((a) -> a % 2 == 0)和filter(a -> a > 0) 箭头前面是参数，后面的是返回值，只有一个参数时可以省略参数的括号
            List<Integer> collect = integerList.stream().filter((a) -> a % 2 == 0).filter(a -> a > 0).collect(Collectors.toList());
            for (Integer integer : collect) {
                System.out.println(integer);
            }
        }

        //去重案例
        public void distinctOfStream() {

            //留下长度大于等于3，去重后的数据
            List<String> list = Arrays.asList("fang", "cai", "huang", "he", "gou", "li", "gou", "fang", "he");
            List<String> collect = list.stream().filter(a -> a.length() >= 3).distinct().collect(Collectors.toList());
            for (String s : collect) {
                System.out.println(s);
            }

        }

        //排序案例
        public void sortedOfStream() {

            //先去重，由大到小排序
            List<Integer> list = new ArrayList<Integer>() {
                {
                    add(2);
                    add(1);
                    add(5);
                    add(6);
                    add(7);
                    add(1);
                }
            };

            List<Integer> collect = list.stream().distinct().sorted((a, b) -> a > b ? -1 : 1).collect(Collectors.toList());
            for (Integer integer : collect) {
                System.out.println(integer);
            }

        }

        //peek案例
        public void peekOfStream() {

            //peek不是终结操作，不会将流consume掉
            List<String> collect = Stream.of("one", "two", "three", "four")
                    .peek(e -> System.out.println("Peeked value: " + e))
                    .map(String::toUpperCase)
                    .peek(e -> System.out.println("Mapped value: " + e))
                    .collect(Collectors.toList());
            for (String s : collect) {
                System.out.println(s);
            }
        }

        //限制案例
        public void limitOfStream() {

            //先去重，再排序，最后限制条数
            List<Integer> list = Arrays.asList(1, 4, 3, 4, 3, 6, 3, 2);
            List<Integer> collect = list.stream().distinct().sorted((a, b) -> a > b ? 1 : -1).limit(3).collect(Collectors.toList());
            for (Integer integer : collect) {
                System.out.println(integer);
            }

        }

        //跳过案例
        public void skipOfStream() {

            //过滤出小于200的，然后由小到大排序，最后跳过前3位数
            //skip是跳过的个数，而不是跳过某个数
            List<Integer> list = Arrays.asList(1, 34, 23, 245, 4, 2, 5, 6, 7);
            List<Integer> collect = list.stream().filter(a -> a < 200).sorted((a, b) -> a > b ? -1 : 1).skip(3).collect(Collectors.toList());
            for (Integer integer : collect) {
                System.out.println(integer);
            }
        }

    }

    /**
     * 终端流案列 接收Consumer接口的参数
     */
    public static class TerminalStreamLambdaDemo {

        //遍历案例，并行遍历，不能保证遍历顺序
        public void forEachOfStream() {
            List<String> list = Arrays.asList("hello world", "hello java", "hello c#", "hello git", "hello php");

            System.out.println("开始遍历输出链表数据...");
            list.stream().forEach(s -> {
                System.out.println(s);
            });
            System.out.println("遍历输出链表数据完成...");


            Map<String, Integer> map = new ConcurrentHashMap<>();
            map.put("fang", 100);
            map.put("xiao", 200);
            map.put("yong", 300);
            map.forEach((key, value) -> {
                System.out.println("key： " + key + " value： " + value);
            });

        }

        //按顺序遍历案例，属于串行遍历，效率不如foreach快，foreach是并行遍历，但是不能保证遍历顺序
        public void forEachOrderedOfStream() {
            List<Integer> list = Arrays.asList(1, 2, 3, 54, 43, 1, 4324, 0, 34, 33);
            System.out.println("开始遍历输出链表数据...");
            list.stream().forEachOrdered(a -> System.out.println(a));
            System.out.println("遍历输出链表数据完成...");

            Map<String, Integer> map = new HashMap<>();
            map.put("fang", 100);
            map.put("xiao", 200);
            map.put("yong", 300);
            map.forEach((key, value) -> {
                System.out.println("key： " + key + " value： " + value);
            });


        }

        //转换为数组案例
        public void toArrayOfStream() {
            List<String> list = Arrays.asList("1", "2", "3", "3", "5");
            String[] strings = list.stream().distinct().toArray(String[]::new);
            Stream.of(strings).forEachOrdered(a -> {
                System.out.println(a);
            });

        }

        //减少案例
        public void reduceOfStream() {

            //reduce()函数接收两个参数{上一次计算结果,stream中的项}，返回optional接口
            // 三个参数时，{初始值，{上一次计算结果,stream中的项}}，返回reduce中指定的类型

            List<Integer> list = Arrays.asList(21, 43, 234, 5, 7, 8, 1, 0);

            //两个参数实现累加操作
            Optional<Integer> optional = list.stream().filter(a -> a != 0).distinct().reduce((result, item) -> {
                //result初始值为stream中的第一个数据，item初始值为第二数据
                return result + item;
            });
            System.out.println("用两个参数的方法计算数组累加的和为：" + optional.get());

            //三个参数实现累加操作
            Integer sum = list.stream().filter(a -> a != 0).distinct().reduce(0, (result, item) -> {
                //result初始值为前面个指定的参数，即0，item初始值为stream中的第一个参数
                return result + item;
            });
            System.out.println("用三个参数的方法计算数组累加的和是：" + sum);

            //直接调用函数实现累加，根据业务逻辑来调用自定义的函数
            Optional<Integer> integerOptional = list.stream().filter(a -> a != 0).distinct().reduce(Integer::sum);
            Integer integer = list.stream().filter(a -> a != 0).distinct().reduce(0, Integer::sum);
            System.out.println("调用函数求累加和：" + integerOptional.get() + "--->" + integer);
        }

        //集合案例
        public void collectOfStream() {
            String[] strings = new String[]{"123", "23", "432"};
            List<String> collect = Stream.of(strings).collect(Collectors.toList());
            collect.stream().forEachOrdered(a -> {
                System.out.println(a);
            });

            //或者，如果需要输出某些对象的属性，需要用花括号来分开写
            collect.stream().forEachOrdered(System.out::println);
        }

        //最小案例
        public void minOfStream() {
            List<Integer> integers = Arrays.asList(2, 3, 1, 5, 0, -1, 324, -43);
            //lambda专用的比较接口
            Optional<Integer> min = integers.stream().min(Comparator.comparing(num -> num));
            System.out.println("最小的值为：" + min.get());
        }

        //最大案例
        public void maxOfStream() {
            List<Integer> integers = Arrays.asList(2, 3, 1, 5, 0, -1, 324, -43);
            //lambda专用的比较接口
            Optional<Integer> min = integers.stream().max(Comparator.comparing(num -> num));
            System.out.println("最大的值为：" + min.get());
        }

        //数量案例
        public void countOfStream() {
            List<Integer> integers = Arrays.asList(1, 23, 4, 5, 6);
            System.out.println(integers.stream().count());

        }

        //全匹配案例
        public void allMatchOfStream() {
            List list = Arrays.asList(23, "343", "45645");
            boolean allMatch = list.stream().allMatch(a -> judgeConditions(a));
            boolean anyMatch = list.stream().anyMatch(a -> judgeConditions(a));
            boolean noneMatch = list.stream().noneMatch(a -> judgeConditions(a));
            System.out.println(allMatch);
            System.out.println(anyMatch);
            System.out.println(noneMatch);
        }

        //匹配条件
        private boolean judgeConditions(Object o) {
            return o instanceof String ? true : false;
        }

        //找到第一条案例
        public void findFirstOfStream() {
            List<Integer> integers = Arrays.asList(1, 23, 4, 5, 6);
            Optional<Integer> optional = integers.stream().findFirst();
            System.out.println("数组中的第一个元素是：" + optional.get());
        }

        //迭代器案例
        public void iteratorOfStream() {
            List<String> list = Arrays.asList("fang", "xiao", "yong");
            Iterator<String> iterator = list.stream().skip(1).iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

    }


    /**
     * lambda表达式综合案列
     */
    public void multipleLambdaDemo() {
        List<UserPojo> userPojos = new ArrayList<>();
        userPojos.add(new UserPojo("fang", "12345", "100"));
        userPojos.add(new UserPojo("xiao", "23456", "200"));
        userPojos.add(new UserPojo("yong", "34567", "300"));
        userPojos.stream().distinct().reduce(new UserPojo("null", "null", "null"), (result, item) -> {
            Integer integer = Integer.parseInt(item.getBalance());
            if (integer < 300) {
                item.setBalance(String.valueOf(integer * 2));
                return item;
            }
            return item;
        });

        //第一种方式遍历计算结果
        userPojos.stream().sorted((a, b) -> {
            return Integer.parseInt(a.getBalance()) > Integer.parseInt(b.getBalance()) ? 1 : -1;
        }).forEachOrdered(a -> {
            System.out.println("名字： " + a.getName() + " 密码： " + a.getPwd() + " 余额： " + a.getBalance());
        });

        System.out.println("=========================================");

        //第二种方式遍历计算结果
        userPojos.stream().sorted((a, b) ->
                        Integer.parseInt(a.getBalance()) > Integer.parseInt(b.getBalance()) ? 1 : -1
        ).forEachOrdered(a -> {
            System.out.println("名字： " + a.getName() + " 密码： " + a.getPwd() + " 余额： " + a.getBalance());
        });

    }

    public static void main(String args[]) {
//        new StreamLambdaDemo.IntermediateStreamLambdaDemo().mapOfStream();
//        new StreamLambdaDemo.IntermediateStreamLambdaDemo().flatMapOfStream();
//        new StreamLambdaDemo.IntermediateStreamLambdaDemo().filterOfStream();
//        new StreamLambdaDemo.IntermediateStreamLambdaDemo().distinctOfStream();
//        new StreamLambdaDemo.IntermediateStreamLambdaDemo().sortedOfStream();
//        new StreamLambdaDemo.IntermediateStreamLambdaDemo().peekOfStream();
//        new StreamLambdaDemo.IntermediateStreamLambdaDemo().limitOfStream();
//        new StreamLambdaDemo.IntermediateStreamLambdaDemo().skipOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().forEachOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().forEachOrderedOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().toArrayOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().reduceOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().collectOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().minOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().maxOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().allMatchOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().countOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().findFirstOfStream();
//        new StreamLambdaDemo.TerminalStreamLambdaDemo().iteratorOfStream();
        new StreamLambdaDemo().multipleLambdaDemo();
    }

    /**
     * Predicate案列
     * <p>参考网址：<a href="https://blog.csdn.net/nwpu_geeker/article/details/80927844">java函数式编程之Predicate</a></p>
     */
    public static class PredicateDemo {

        //Predicate是逻辑表达式的引用，里面有个test()方法，在lambda表达式中，当传入了逻辑表达式的引用，如filter()等，会自动调用test()方法进行验证
        public static void main(String args[]) {
            Predicate<Integer> boolValue = x -> x > 5;
            System.out.println(boolValue.test(1) + "");
            System.out.println(boolValue.test(6) + "");
        }
    }


    /**
     * java8中的冒号表达式案例
     * <p>参考网址：</p>
     * <p><a href="http://toulezu.com/2019/05/14/understand-Java-8-method-reference/">Java 8 中双冒号(method reference)的用法</a></p>
     * <p><a href="https://blog.csdn.net/neweastsun/article/details/82937659">java 8 双冒号操作</a></p>
     * 冒号的作用主要有：<br/>
     * 静态方法引用(Reference to a static method)<br/>
     * 语法：ContainingClass::staticMethodName<br/>
     * 例如：Person::getAge<br/>
     * 对象的实例方法引用(Reference to an instance method of a particular object)<br/>
     * 语法：containingObject::instanceMethodName<br/>
     * 例如：System.out::println<br/>
     * 特定类型的任意对象实例的方法(Reference to an instance method of an arbitrary object of a particular type)<br/>
     * 语法：(ContainingType::methodName)<br/>
     * 例如：String::compareToIgnoreCase<br/>
     * 类构造器引用语法(Reference to a constructor)<br/>
     * 语法：ClassName::new<br/>
     * 例如：ArrayList::new<br/>
     * <br/>
     * 备注：双冒号表达式返回的是一个 函数式接口对象（用 @FunctionalInterface 注解的 interface 类型）的实例
     */
    public static class ColonDemo {

        //用于测试冒号表达式调用静态方法
        public static class StringUtils {
            public static void toUpperCase(String str) {
                System.out.println(str.toUpperCase());
            }
        }

        //用于测试冒号表达式调用成员方法
        public class IntegerUtils {
            public void toInt(Long data) {
                System.out.println(data.intValue());
            }
        }


        /**
         * 测试冒号表达式实例化对象
         */
        @FunctionalInterface
        public interface ITool {
            JSONTool create(String name);
        }

        @FunctionalInterface
        public interface InterfaceComputer {
            Object create();
        }

        //三个参数以上的构造函数的函数式接口，仿照Function接口即可
        @FunctionalInterface
        interface TriFunction<A, B, C, R> {
            R apply(A a, B b, C c);

            default <V> TriFunction<A, B, C, V> andThen(Function<? super R, ? extends V> after) {
                Objects.requireNonNull(after);
                return (A a, B b, C c) -> after.apply(apply(a, b, c));
            }
        }

        public static class JSONTool {

            private String name;

            public JSONTool(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            private static JSONObject parseJSON(JSONTool jsonTool) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(jsonTool.getName(), jsonTool.getName());
                return jsonObject;
            }

            public static String getJSONString(String name, ITool iTool) {
                return parseJSON(iTool.create(name)).toJSONString();
            }

        }

        //测试调用方法
        public void ColonTest() {

            //静态方法调用
            List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
            list.forEach(StringUtils::toUpperCase);

            //成员方法调用
            List<Long> list1 = Arrays.asList(111L, 222L, 333L);
            list1.forEach(new ColonDemo.IntegerUtils()::toInt);

            //特定类型的任意对象实例的方法
            String[] stringArray = {"Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda"};
            Arrays.sort(stringArray, String::compareToIgnoreCase);
            for (int i = 0; i < stringArray.length; i++) {
                System.out.println(stringArray[i]);
            }

            //对象实例化，注意冒号表达式属于lambda表达式的一种，只是定义了new这种操作，最终的new操作是在函数接口里面调用函数方法实例化的
            //如此处先调用JSONTool::new定义了new这种操作，得到ITool函数式接口，然后函数式接口自动调用里面参数匹配的方法执行new操作
            System.out.println(JSONTool.getJSONString("a", JSONTool::new));
            System.out.println(JSONTool.getJSONString("a", t -> new JSONTool(t)));

            //其实和上面一种实例化方法是一样的，只不过上一个把函数式接口里面的create()方法封装进类方法里了
            InterfaceComputer c = Object::new;
            Object object = c.create();

            //有两个参数的构造函数实例化，将此处Object换为有两个参数的构造函数的类即可
//            BiFunction<Integer, String, Object> c4Function = Object::new;
//            Object c4 = c4Function.apply(2013, "white");

            //三个即以上参数的构造方法实例化，将此处Object换为有两个参数的构造函数的类即可
//            TriFunction<Integer, String, Integer, Object> c6Function = Object::new;
//            Object c3 = c6Function.apply(2008, "black", 90);


            //生成5个对象数组
            Function<Integer, Object[]> computerCreator = Object[]::new;
            Object[] computerArray = computerCreator.apply(5);
        }


    }
}
