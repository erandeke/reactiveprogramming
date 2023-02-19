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
public class RxObserverables {
    public static void main(String[] args) {


        Observable<String> bs = new ObservableCreate<String>(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                try {
                    emitter.onNext("Test"); // for emissions from observable
                    emitter.onNext("Test-1");
                    emitter.onComplete(); //no more emissions. All the emissions are complete
                } catch (Exception ex) {
                    emitter.onError(ex); //on error when  called then the flow will never reach to onComplete
                }
            }
        });

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("Subscribed" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        bs.subscribe(observer);
    }
}