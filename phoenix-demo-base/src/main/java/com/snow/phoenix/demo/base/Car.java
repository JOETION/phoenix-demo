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

//车类
public class Car {

    //车牌号
    private int carNum;

    //颜色
    private String color;

    //无参构造方法
    public Car() {

    }

    //带参构造方法
    public Car(int carNum) {
        this.carNum = carNum;
    }

    //带参构造方法
    public Car(int carNum, String color) {
        this.carNum = carNum;
        this.color = color;
    }

    //set和get方法
    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {

        return color;
    }

    public static void main(String[] args) {

        Car carOne = new Car();
        Car carTwo = new Car(15);
        Car carThree = new Car(15, "red");

        carOne.setCarNum(15);
        carOne.setColor("red");
        System.out.println("carNum=" + carOne.getCarNum() + "  color=" + carOne.getColor());

        carTwo.setColor("red");
        System.out.println("carNum=" + carTwo.getCarNum() + "  color=" + carTwo.getColor());

        System.out.println("carNum=" + carThree.getCarNum() + "  color=" + carThree.getColor());


    }


}