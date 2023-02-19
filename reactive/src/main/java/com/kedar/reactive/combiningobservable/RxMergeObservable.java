package com.kedar.reactive.combiningobservable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author Kedar Erande
 * mergeWith doesn't maintains the order it will give random op
 */
public class RxMergeObservable {
    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> ob1 = Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.computation());
        Observable<Integer> ob2 = Observable.just(8, 10, 11)
                .subscribeOn(Schedulers.computation());
        
        ob1.mergeWith(ob2)
                .subscribe(e-> System.out.println(e));

        Thread.sleep(10000);

    }
}
