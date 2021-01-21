package com.snow.phoenix.demo.base.java8.lambda;

/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2021-01-21          FXY        Created
 **********************************************
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Optional容器案列
 */
public class OptionalDemo {

    //optional容器案列
    public void option() throws Exception {
        //将抛空指针异常
        Optional<Object> optionalOne = Optional.of(null);
        //将返回nul，不会抛异常，此方法一般用的比较多
        Optional<Object> optionalTwo = Optional.ofNullable(null);

        Optional<List<String>> optionalList = Optional.ofNullable(Arrays.asList("123", "234", "345"));

        //如果容器不为空
        if (optionalList.isPresent()) {
            //取得容器中的值
            List<String> list = optionalList.get();
            //也可以在容器有值时进行一些其他操作，有值时以同步的方式输出链表中的数据
            optionalList.ifPresent(a->a.stream().forEach(System.out::println));
        } else {
            //可以以传统形式设置容器为空时的默认值
            List<String> customList = optionalList.orElse(new ArrayList<>());

            //也可以以lambda表达式设置当容器为空时返回一个默认值
            List<String> lambdaList = optionalList.orElseGet(ArrayList::new);

            //亦可以抛出异常
            List<String> exceptionOrList = optionalList.orElseThrow(Exception::new);
        }
    }

    public static void main(String[] args) {
        try {
            new OptionalDemo().option();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
