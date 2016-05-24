package com.zhou.jy.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {


    rx.Observable<String> observable= rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello, world!");
            subscriber.onCompleted();
        }
    });

    Subscriber<String> subscriber=new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            Log.i("aaaaaaaaaaaaaaaaaa",s);
        }
    };


  /*  Observable.just("Hello, world!")
            .subscribe(new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println(s);
        }
    });*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

      //  observable.subscribe(subscriber);
     /*   Observable.just("hellohellohello").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i("aaaaaaaaaaaaaaaaaa",s);
            }
        });*/


      Observable.just("zhou aaaaaaa")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s+"hello";
                    }
                })
                .map(new Func1<String, Double>() {
                    @Override
                    public Double call(String s) {
                        return 0.1;
                    }
                })
                .map(new Func1<Double, String>() {
                    @Override
                    public String call(Double aFloat) {
                        return "zhou";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("aaaaaaaaaa",s);
                    }
                });


        Observable.just("hello world!!")
                .map(s1 -> test())
                .subscribe(s->Log.i("aaaaaaaaaa",s));

    }
    private String test(){


        return "HEllo World";
    }
}
