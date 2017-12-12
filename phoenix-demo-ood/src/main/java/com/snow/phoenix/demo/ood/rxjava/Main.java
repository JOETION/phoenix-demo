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

package com.snow.phoenix.demo.ood.rxjava;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/12/9          FXY        Created
 **********************************************
 */

/**
 * 程序入口
 */
public class Main {

    public static void main(String args[]) {
//        new Main().verifySubcribe();
        new Main().verifyMap();


    }

    public static void verifySubcribe() {
        Observable.create(new OnSubcrible<String>() {
            public void call(Subcrible<? super String> subcrible) {
                subcrible.onNext("男生，走，看电影去");
            }
        }).subcrible(new Subcrible<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
                System.out.println("女生，可以，那就一起去看电影吧");
            }
        });
    }

    public void verifyMap() {

        Observable.create(new OnSubcrible<String>() {
            public void call(Subcrible<? super String> subcrible) {
                subcrible.onNext("男生，走，看电影去");
            }
        }).map(new Func1<String, String>() {
            public String call(String s) {
                s += ",ok?";
                return s;
            }
        }).subcribleOnIO().subcrible(new Subcrible<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
                System.out.println("女生，可以，那就一起去看电影吧");
            }
        });
    }

}
