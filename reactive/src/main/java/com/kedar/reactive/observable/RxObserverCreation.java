package com.kedar.reactive.observable;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author Kedar Erande
 */
public class RxObserverCreation {
    public static void main(String[] args) {

        Observable<String> observ = Observable.just("Santo","Adinath","Sharvee");

        observ.subscribe(i-> System.out.println(i));
    }
}
