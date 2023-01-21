package com.kedar.reactive.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class RxFlatmap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hi","Kedar","Erande");

        Observable.fromIterable(list)
                .flatMap(e -> Observable.fromArray(e.split(""))) //flattens the string
                .subscribe(System.out::println);

    }
}
