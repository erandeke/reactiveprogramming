package com.kedar.reactive.observable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

/**
 * @author Kedar Erande
 */
public class RxObservable {
    public static void main(String[] args) {
        Observable<Integer> src = new ObservableCreate<>(emitter -> {
            emitter.onNext(10);
            emitter.onNext(20);
            emitter.onNext(30);
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed to observable src");
            }

            @Override
            public void onNext(@NonNull Integer type) {
                System.out.println("Emiited item" + type);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.getMessage();
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };

        src.subscribe(observer);
    }
}
