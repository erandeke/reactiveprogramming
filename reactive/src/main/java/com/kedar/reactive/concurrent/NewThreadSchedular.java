package com.kedar.reactive.concurrent;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author Kedar Erande
 */
public class NewThreadSchedular {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Take", "Home", "Salary")
                .subscribeOn(Schedulers.newThread()); //here thread dies once the task is done cant be reused
        src.subscribe(e -> compute(e));
        Thread.sleep(1000);
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));

        Thread.sleep(10000);


    }

    private static void compute(String value) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Thread name for computation" + "  " + Thread.currentThread().getName() + "  " + "for value" + "  " + value);
    }
}
