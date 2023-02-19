package com.kedar.reactive.concurrent;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author Kedar Erande
 *
 * Demonstration of observe on that will honor here the newThread over Schedulers.Computation()
 */
public class RxObserveOn {

    public static void main(String[] args) throws InterruptedException {

        Observable.just("Hi", "hello", "How", "Are", "You")
                .subscribeOn(Schedulers.computation())
                .map(e -> e.toUpperCase())
                .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .filter(e -> e.startsWith("H"))
                .subscribe(e -> System.out.println(e + "  " + " printed by" + Thread.currentThread().getName()));

        Thread.sleep(20000);
    }

}
