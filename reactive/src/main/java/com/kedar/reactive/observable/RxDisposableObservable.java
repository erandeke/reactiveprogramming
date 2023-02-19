package com.kedar.reactive.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * @author Kedar Erande
 */
public class RxDisposableObservable {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> obs = Observable.interval(1, TimeUnit.SECONDS);

        Disposable d = obs.subscribe(e -> System.out.println("Observable 1" + " " + e));

        Thread.sleep(1000);

        d.dispose();

        obs.subscribe(e -> System.out.println("Observable 2" + " " + e));

        Thread.sleep(10000);


    }
}
