package com.kedar.reactive.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * @author Kedar Erande
 *
 * Hot obervable is like a radio whenever the new subscriber joins for example at line 23
 * it will start listening from that point for the emission
 */
public class RxHotObservable {
    public static void main(String[] args) throws InterruptedException {
        ConnectableObservable<Long> observable = Observable.interval(1,TimeUnit.SECONDS).publish();

        observable.connect();

        observable.subscribe(System.out::println);

        Thread.sleep(1000);

        observable.subscribe(System.out::println);

        Thread.sleep(1000);


    }
}
