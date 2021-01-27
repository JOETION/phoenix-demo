package com.snow.phoenix.demo.rxjava;

/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2021-01-27          FXY        Created
 **********************************************
 */


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class RxjavaDemo {

    /**
     * 创建被观察者方式
     * 被观察者相当于java8中的stream
     * 但是java8中没有观察者的概念，得到被观察者的结果后只能自己处理逻辑
     *
     * @return
     */
    public Observable createObservable() {
        Observable<Object> observableOne = Observable.create(e -> {
            System.out.println("observable-currentThread：" + Thread.currentThread().getName());
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
            e.onComplete();
        });
        //创建被观察者方式二
        Observable<Integer> observableTwo = Observable.just(1, 2, 3);
        //创建被观察者方式三
        Observable<Integer> observableThree = Observable.fromArray(new Integer[]{1, 2, 3});
        //创建被观察者方式四
        Observable<Integer> observableFour = Observable.fromCallable(() -> 1);
        //创建被观察者方式五
        Observable<Integer> observableFive = Observable.fromFuture(new FutureTask<Integer>(() -> 1));
        //创建被观察者方式六
        Observable<Integer> observableSix = Observable.fromIterable(Arrays.asList(1, 2, 3));
        //创建被观察者方式七
        Observable<Integer> observableSeven = Observable.defer(() -> Observable.just(1));
        //创建被观察者方式八
        Observable<Long> observableEight = Observable.timer(2, TimeUnit.SECONDS);
        //创建被观察者方式九
        Observable<Long> observableNine = Observable.interval(4, TimeUnit.SECONDS);
        //创建被观察者方式十
        Observable<Long> observableTen = Observable.intervalRange(2, 5, 2, 1, TimeUnit.SECONDS);
        //创建被观察者方式十一
        Observable<Integer> observableEleven = Observable.range(2, 5);
        //创建被观察者方式十二
        Observable<Long> observableTwelve = Observable.rangeLong(2, 5);
        //创建被观察者方式十三
        Observable<Object> observableThirteen = Observable.empty();
        //创建被观察者方式十四
        Observable<Object> observableFourteen = Observable.never();
        //创建被观察者方式十五
        Observable<Object> observableFifteen = Observable.error(new NullPointerException());
        return observableOne;
    }

    //创建被观察者
    public Observer createObserver() {
        return new Observer() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("=============>>>OnSubscribe：" + disposable);
            }

            @Override
            public void onNext(Object o) {
                System.out.println("=============>>>OnNext：" + o);
                System.out.println("=============>>>Observer-currentThread：" + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("=============>>>OnError：" + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("=============>>>OnComplete");
            }
        };

    }

    /**
     * 建立观察者与被观察者之间的映射关系
     *
     * @param observable 被观察者
     * @param observer   观察者
     */
    public void OnSubscribe(Observable observable, Observer observer) {
        observable.subscribe(observer);
    }

    /**
     * 转换操作符
     *
     * @return 被观察者
     */
    public Observable mapOperation(Observable observable) {
        Observable observableOne = observable.map(a -> Integer.parseInt(String.valueOf(a)));
        return observableOne;
        //flatMap()，concatMap(),buffer(),groupBy(),san(),window(),
    }

    /**
     * 组合操作符
     *
     * @param
     */
    public Observable composeOperation(Observable<Integer> observable) {
        //concat(),concatArray(),merge(),concatArrayDelayError(),mergeArrayDelayError(),zip()
        //combineLatest(),combineLatestDelayError(),reduce(),collect(),startWith(),startWithArray(),count()
        Integer sum = observable.reduce(0, (a, b) -> a + b).blockingGet();
        return observable.startWith(sum).collect(() -> new ArrayList<Integer>(), (a, b) -> a.add(b)).flatMapObservable(a -> Observable.fromIterable(a));
    }

    /**
     * 功能操作符
     *
     * @param observable 被观察者
     * @return
     */
    public Observable functionOperation(Observable<Integer> observable) {
        //delay(),doOnEach(),doOnNext(),doAfterNext(),doOnComplete(),doOnError()
        //doOnSubscribe(),doOnDispose(),doOnLifecycle(),doOnTerminate(),doAfterTerminate()
        //doFinally(),OnErrorReturn(),OnErrorResumeNext(),OnExceptionResumeNext(),retry()
        //retryUntil(),retryWhen(),repeat(),repeatWhen(),subscribeOn(),observeOn()
        return observable.doOnNext(a -> System.out.println("开始执行OnNext方法，当前被观察者发射的对象为：" + a)).observeOn(Schedulers.newThread()).subscribeOn(Schedulers.computation());
    }

    /**
     * 过滤操作符
     *
     * @param observable 被观察者
     */
    public Observable filterOperation(Observable<Integer> observable) {
        //filter(),ofType(),skip(),distinct(),distinctUntilChanged(),take(),debounce()
        //firstElement(),lastElement(),elementAt(),elementAtOnError()
        return observable.filter(a -> a % 2 == 0).distinct().take(2);
    }

    /**
     * 条件操作符
     *
     * @param observable 被观察者
     * @return
     */
    public Observable predictOperation(Observable<Integer> observable) {
        //all(),takeWhile(),skipWhile(),takeUntil(),skipUntil(),sequenceEqual()
        //contains(),isEmpty(),amd(),defaultIfEmpty()
        return observable.takeWhile(a -> a % 2 == 0).defaultIfEmpty(4).all(a -> a % 2 == 0).contains(6).toObservable();
    }

    public static void main(String[] args) {
        RxjavaDemo rxjavaDemo = new RxjavaDemo();
        Observable observable = rxjavaDemo.createObservable();
        Observer observer = rxjavaDemo.createObserver();
        Observable mapAfterObservable = rxjavaDemo.mapOperation(observable);
        Observable composeAfterObservable = rxjavaDemo.composeOperation(mapAfterObservable);
        Observable functionAfterObservable = rxjavaDemo.functionOperation(composeAfterObservable);
        Observable filterAfterObservable = rxjavaDemo.filterOperation(functionAfterObservable);
        Observable predictAfterObservable = rxjavaDemo.predictOperation(filterAfterObservable);
        rxjavaDemo.OnSubscribe(predictAfterObservable, observer);
        //为了防止线程未执行完成就结束了
        new Scanner(System.in).nextInt();
    }

}
