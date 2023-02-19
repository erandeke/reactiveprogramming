package com.kedar.reactive.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

/**
 * @author Kedar Erande
 * <p>
 * Replaying helps in getting the data right from start of emission to the connected observers
 * using autoConnect()
 * Here Observer 2 has joined after pause of 2 seconds but still it will receive the data from
 * observable right from the start
 */
public class RxReplaying {
    public static void main(String[] args) throws InterruptedException {

        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .replay()
                .autoConnect();

        observable.subscribe(e -> System.out.println("Observer 1" + " " + e));

        Thread.sleep(2000);

        observable.subscribe(e -> System.out.println("Observer 2" + "  " + e));

        Thread.sleep(5000);

    }
}
