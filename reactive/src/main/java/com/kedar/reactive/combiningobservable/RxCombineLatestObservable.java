package com.kedar.reactive.combiningobservable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author Kedar Erande
 */
public class RxCombineLatestObservable {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> src_1 = Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation());
        Observable<Long> src_2 = Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation());

        Observable.combineLatest(src_1, src_2, (e1, e2) -> "src 1: " + e1 + "  " + "src 2" + " " + e2)
                .subscribe(System.out::println);

        Thread.sleep(20000);

    }
}
