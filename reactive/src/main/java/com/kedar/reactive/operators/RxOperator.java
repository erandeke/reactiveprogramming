package com.kedar.reactive.operators;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author Kedar Erande
 */
public class RxOperator {

    public static void main(String[] args) {
         Observable.just(90,70,100,40)
                 .filter(e->e > 60)
                 .sorted()
                 .subscribe(e -> System.out.println(e));
    }

}
