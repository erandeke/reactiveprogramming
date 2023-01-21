package com.kedar.reactive.observable;


import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 * <p>
 * Ways of creating observables
 */
public class RxObservableCreation {
    public static void main(String[] args) {
        //Factory method
        Observable<Integer> observable = Observable.create(
                e -> {
                    e.onNext(10);
                    e.onNext(20);
                    e.onComplete();
                }

        );

        observable.subscribe(System.out::println);

        //Just

        Observable<Integer> ob = Observable.just(1, 2, 3);
        ob.subscribe(System.out::println);

        //Iterable
        List<Integer> list = Arrays.asList(1, 2, 3);

        Observable<Integer> obse = Observable.fromIterable(list);

        obse.subscribe(System.out::println);

    }
}
