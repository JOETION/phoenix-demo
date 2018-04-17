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

package com.snow.phoenix.demo.base;

//时间类
public class MyTime {
    private int hour;
    private int minute;
    private int second;

    //无参构造方法
    public MyTime() {
        super();
    }

    //带参构造方法
    public MyTime(int hour, int minute, int second) {
        super();
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //重写toString()方法
    @Override
    public String toString() {
        return "hour=" + hour + " minute=" + minute + " second=" + second;
    }

    //重写equals()方法
    @Override
    public boolean equals(Object obj) {
        MyTime myTime = (MyTime) obj;
        return myTime.getHour() == hour && myTime.getMinute() == minute && myTime.getSecond() == second;
    }

    //时间加
    public MyTime timeAdd(MyTime myTime) {
        MyTime result = new MyTime();

        //取得总的秒数
        int secondSum = myTime.getSecond() + second;
        //取得总的分钟数
        int minuteSum = myTime.getMinute() + minute;
        //取得总的小时数
        int hourSum = myTime.getHour() + hour;

        //设置时间，自动进位
        result.setSecond(secondSum % 60);
        result.setMinute((minuteSum + secondSum / 60) % 60);
        result.setHour((hourSum + minuteSum / 60) % 60);
        return result;
    }


    //主函数
    public static void main(String[] args) {
        MyTime timeOne = new MyTime(10, 20, 30);
        MyTime timeTwo = new MyTime(40, 50, 60);
        MyTime timeThree = new MyTime(21, 21, 42);
        System.out.println(timeOne.toString());
        System.out.println(timeOne.equals(timeTwo));
        System.out.println(timeThree.timeAdd(timeTwo).toString());
    }

    //set和get方法
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

}
