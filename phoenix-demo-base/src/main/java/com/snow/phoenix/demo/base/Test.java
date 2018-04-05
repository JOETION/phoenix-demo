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

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/3/26          FXY        Created
 **********************************************
 */


import java.util.Scanner;

/**
 * 1：打印99乘法表
 * 2：打印素数
 * 3：打印金字塔
 */
public class Test {

    //99乘法表
    public void chengfaFor99() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i);
                System.out.print("  ");
            }
            System.out.println();
        }
    }


    //1000000以内素数
    public void Susu() {
        boolean isSUsu;
        for (int i = 2; i <= 1000000; i++) {

            isSUsu = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isSUsu = false;
                    break;
                }
            }

            if (isSUsu) {
                System.out.println(i);
            }
        }
    }


    //输出金字塔
    public void goldTower() {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入金字塔层数：");
        n = scanner.nextInt();//外层循环控制层数
        for (int i = 1; i <= n; i++) {
            //根据外层行号，输出星号左边空格
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");//根据外层行号，输出星号个数
            }
            for (int j = 0; j < i; j++) {
                if (i % 2 == 0) {
                    System.out.print("2 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String args[]) {
        new Test().goldTower();
    }


}

