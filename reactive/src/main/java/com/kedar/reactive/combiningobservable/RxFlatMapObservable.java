package com.kedar.reactive.combiningobservable;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author Kedar Erande
 * Flat map returns the observable
 */
public class RxFlatMapObservable {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Hi", "hello", "team");
        observable.flatMap(e -> Observable.fromArray(e.split(","))).subscribe(e -> System.out.println(e));

    }

}
