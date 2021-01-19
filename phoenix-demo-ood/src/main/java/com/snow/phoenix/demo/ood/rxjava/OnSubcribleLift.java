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


public class OnSubcribleLift<T, R> implements OnSubcrible<R> {

    OnSubcrible<T> boy;

    Func1<? super T, ? extends R> transformer;

    public OnSubcribleLift(OnSubcrible<T> boy, Func1<? super T, ? extends R> transformer) {
        this.boy = boy;
        this.transformer = transformer;
    }

    public void call(Subcrible<? super R> subcrible) {
        Subcrible<? super T> wifi = new OperateChange(subcrible,transformer);
        boy.call(wifi);
    }

    class OperateChange extends Subcrible<T> {
        Subcrible<? super R> actual;
        private Func1<? super T, ? extends R> transform;

        public OperateChange(Subcrible<? super R> actual, Func1<? super T, ? extends R> transform) {
            this.actual = actual;
            this.transform = transform;
        }

        @Override
        public void onNext(T t) {
            R r = this.transform.call(t);
            actual.onNext(r);
        }
    }
}
