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
 * 黑屋子
 */
public class Observable<T> {

    private OnSubcrible onSubcrible;

    private Observable(OnSubcrible onSubcrible) {
        this.onSubcrible = onSubcrible;
    }
    public void subcrible(Subcrible<? super T> subcrible){
        onSubcrible.call(subcrible);

    }
    public static <T> Observable<T> create(OnSubcrible<T> onSubcrible){
        return new Observable<T>(onSubcrible);
    }

    public <R> Observable<R> map(Func1<? super T,? extends R> func1 ){
        return new Observable<R>(new OnSubcribleLift<T,R>(onSubcrible,func1));
    }

    public Observable<T> subcribleOnIO(){
        return create(new OnSubcribleThread<T>(this));
    }
}
