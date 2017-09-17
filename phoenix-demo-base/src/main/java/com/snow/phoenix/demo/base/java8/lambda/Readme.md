总结

1：Java中内部类以及Lambda表达式中也不允许修改外部类中的变量，
这是为了避免多线程情况下的race condition

2：Lambda中变量以及this关键字，Lambda中定义的变量与外部类中的变量作用域相同，
即外部类中定义了，Lambda就不能再重复定义了，同时在Lambda表达式使用的this关键字，
指向的是外部类

3：Stream的分类
中间流（返回Stream）：
map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
终端流（返回你所期望的类型）：
forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
短路流（返回Stream）：
anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit

4：Stream中reduce的用法
参考网址：http://blog.csdn.net/io_field/article/details/54971679

5：Optional介绍
  
  Optional是Java8新加入的一个容器，这个容器只存1个或0个元素，它用于防止出现NullpointException，它提供如下方法：
  
  isPresent() 
  判断容器中是否有值。
  ifPresent(Consume lambda) 
  容器若不为空则执行括号中的Lambda表达式。
  T get() 
  获取容器中的元素，若容器为空则抛出NoSuchElement异常。
  T orElse(T other) 
  获取容器中的元素，若容器为空则返回括号中的默认值。