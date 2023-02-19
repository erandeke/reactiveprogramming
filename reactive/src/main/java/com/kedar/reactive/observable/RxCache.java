package com.kedar.reactive.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * @author Kedar Erande
 * <p>
 * cache is used for caching the values of observers that already subscribed.
 * So eventually when new observer joins it will get the cached values which are already emitted
 */
public class RxCache {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .cache();

        observable.subscribe(e -> System.out.println("Observer 1: " + " " + e));

        Thread.sleep(2000);

        observable.subscribe(e -> System.out.println("Observer 2: " + " " + e));

        Thread.sleep(5000);

    }
}
