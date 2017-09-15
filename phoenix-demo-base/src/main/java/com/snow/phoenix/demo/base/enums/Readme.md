知识总结

1：枚举中构造函数修饰符均为：private，不能为public

2：用switch语句判断枚举分支时，分支语句的判断条件只能为枚举，不能为枚举值，例如：

switch(xxx.getColor){

case RED: System.out.println("红色"); break;  //不能用case Color.RED

case BLUE: System.out.println("蓝色"); break; //不能用case Color.BLUE

}

3:EnumMap<Enum,value> 比HashMap效率略高，因为内部是直接使用数组数据结构，数组中
直接使用Enum的序号来做key，免去了用hashcode来计算或查找key的步骤


4：EnumSet<Enum> 效率比普通的HashSet略高，因为内部使用了一个64bit的数组(或许不是)
其初始化时，将整个数组全部值初始化为0，将枚举的序号与数组的下标做个对应关系，比如
某个枚举的序号为3，那么这个枚举就将对应数组中下标为3的位置，然后将此下标中对应的值
设置为1，以表示有值，具体请参考一下网址：
http://www.cnblogs.com/accessking/p/4200000.html

5：枚举类中的每一个枚举都是该类的一个实例（重要）



