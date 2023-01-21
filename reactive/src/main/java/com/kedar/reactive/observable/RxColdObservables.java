package com.kedar.reactive.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 * <p>
 * Cold observables get the data even after they are subscribed .
 * They changed the state
 */
public class RxColdObservables {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Observable<Integer> ob = Observable.fromIterable(list);

        ob.subscribe(System.out::println);

        list = getData(list);

        ob.subscribe(System.out::println);


    }

    private static List<Integer> getData(List<Integer> list) {
        list.add(20);
        return list;
    }
}
