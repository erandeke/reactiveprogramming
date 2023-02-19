package com.kedar.reactive.observable;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author Kedar Erande
 */
public class RxObserverCreation {
    public static void main(String[] args) {

     Observable<String> obs = Observable.just("Hi","Kedar","How","Are","You");

       obs.subscribe(System.out::println);
    }
}
