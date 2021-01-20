package com.snow.phoenix.demo.reactor;

/*
 **********************************************
 *      DATE           PERSON       REASON
 *    2021-01-20          FXY        Created
 **********************************************
 */


import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxDemo {

    public void convertToInteger() {
        Integer integer = Flux.just("123").map(Integer::parseInt).blockFirst();
        System.out.println(integer);
    }

    public void create() {
        Flux.just("123").doOnComplete(System.out::println).subscribe(System.out::println);
        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);

        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe((a) -> System.out.println(Thread.currentThread().getName() + "：" + a));
    }

    public void schedule() {
        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
                .publishOn(Schedulers.single())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .publishOn(Schedulers.elastic())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .subscribeOn(Schedulers.parallel())
                .toStream()
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
//        new FluxDemo().convertToInteger();
//        new FluxDemo().create();
        new FluxDemo().schedule();
    }

}
