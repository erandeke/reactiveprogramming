package com.kedar.reactive.concurrent;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Kedar Erande
 * We can achieve custom schedular using ExecutorService
 */
public class CustomSchedular {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Scheduler scheduler = Schedulers.from(executorService);

        Observable<String> src = Observable.just("Hi", "Running", "Thread")
                .subscribeOn(scheduler)
                .doFinally(executorService::shutdown);

        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));

    }

    private static void compute(String value) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Thread name for computation" + "  " + Thread.currentThread().getName() + "  " + "for value" + "  " + value);
    }
}
