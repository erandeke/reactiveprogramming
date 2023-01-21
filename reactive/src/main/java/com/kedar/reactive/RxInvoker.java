package com.kedar.reactive;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author Kedar Erande
 */
public class RxInvoker {
    public static void main(String[] args) {
        Observable<String> src = Observable.create(
                e -> {

                    e.onNext("Hi there");
                    e.onNext("Value 1");
                }

        );

        src.subscribe(e -> System.out.println("Hi I am observer" + e));
    }
}
