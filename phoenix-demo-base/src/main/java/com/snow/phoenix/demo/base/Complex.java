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

//复数类
public class Complex {

    //实部
    private double realPart;
    //虚部
    private double imaginPart;


    //无参构造函数
    public Complex() {
        this.realPart = 0;
        this.imaginPart = 0;
    }

    //带参构造函数
    public Complex(double realPart, double imaginPart) {
        super();
        this.realPart = realPart;
        this.imaginPart = imaginPart;
    }

    //验证，用于判断格式的输出
    private String validate() {
        if (realPart == 0 && imaginPart == 0) {
            return "0";
        } else if (realPart == 0 && imaginPart != 0) {
            return imaginPart + "i";
        } else if (realPart != 0 && imaginPart == 0) {
            return "" + realPart;
        } else if (imaginPart < 0) {
            if (imaginPart == -1) {
                return realPart + "-" + "i";
            }
            return realPart + "" + imaginPart + "i";
        } else {
            if (imaginPart == 1) {
                return realPart + "+" + "i";
            }
            return realPart + "+" + imaginPart + "i";
        }
    }

    //重写toString()方法
    @Override
    public String toString() {
        return validate();
    }

    //重写equals()方法
    @Override
    public boolean equals(Object obj) {
        Complex complex = (Complex) obj;
        return complex.getRealPart() == realPart && complex.getImaginPart() == imaginPart;
    }

    //主函数入口
    public static void main(String[] args) {
        //数据输入验证
        System.out.println("数据验证：");
        System.out.println(new Complex(3, 2).toString());
        System.out.println(new Complex(3, -2).toString());
        System.out.println(new Complex(4, 1).toString());
        System.out.println(new Complex(4, -1).toString());
        System.out.println(new Complex(1, 0).toString());
        System.out.println(new Complex(0, 0).toString());
        System.out.println(new Complex(0, -2).toString());
        System.out.println(new Complex(0, 1).toString());
        System.out.println(new Complex(0, -1).toString());

        System.out.println("复数运算：");
        //复数运算
        System.out.println(new Complex(3, 2).complexAdd(new Complex(3, 2))); //加
        System.out.println(new Complex(3, 2).complexSub(new Complex(3, 2))); //减
        System.out.println(new Complex(3, 2).complexMulti(new Complex(3, 2))); //乘
        System.out.println(new Complex(3, 2).complexDiv(new Complex(3, 2))); //除
    }


    //复数相加
    public Complex complexAdd(Complex a) {
        Complex complex = new Complex();
        complex.setRealPart(a.getRealPart() + this.realPart);
        complex.setImaginPart(a.getImaginPart() + this.imaginPart);
        return complex;
    }

    //复数相减
    public Complex complexSub(Complex a) {
        Complex complex = new Complex();
        complex.setRealPart(this.realPart - a.getRealPart());
        complex.setImaginPart(this.imaginPart - a.getImaginPart());
        return complex;
    }

    //复数相乘
    public Complex complexMulti(Complex a) {
        Complex complex = new Complex();
        complex.setRealPart((this.realPart * a.getRealPart()) - (this.getImaginPart() * a.getImaginPart()));
        complex.setImaginPart((this.imaginPart * a.getRealPart()) + (this.realPart * a.getImaginPart()));
        return complex;
    }

    //复数相除
    public Complex complexDiv(Complex a) {
        if (a.getImaginPart() == 0 && a.getRealPart() == 0) {
            System.out.println("复数相除，实部和虚部不能同时为0");
            return null;
        }
        Complex complex = new Complex();
        double realPart = ((this.realPart * a.getRealPart()) + (a.imaginPart * a.getImaginPart())) / (Math.pow(a.getRealPart(), 2) + Math.pow(a.getImaginPart(), 2));
        double imaginPart = ((this.imaginPart * a.getRealPart()) - (this.realPart * a.getImaginPart())) / (Math.pow(a.getRealPart(), 2) + Math.pow(a.getImaginPart(), 2));
        complex.setRealPart(realPart);
        complex.setImaginPart(imaginPart);
        return complex;
    }


    //set和get方法
    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginPart() {
        return imaginPart;
    }

    public void setImaginPart(double imaginPart) {
        this.imaginPart = imaginPart;
    }


}
