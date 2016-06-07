package com.zhou.jy.rxjavatest;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
            Log.i("aaaaa三十多分aaaaaaaaaaaaa",s);
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
        RxJavaCommon();
        RxJavaOperator();

        Observable.just("Hello, world!")
                .map(s -> "")
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                              Log.i("aaaaaaa",e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {

                    }
                });




    }




   //RxJava 基础用法
    private void  RxJavaCommon(){
        //第一种
        observable.subscribe(subscriber);

        //第二种
     /*   Observable.just("hellohellohello").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i("aaaaaaaaaaaaaaaaaa",s);
            }
        });*/
        Observable.just("hellohellohello").subscribe(s ->  Log.i("aaaaaaaaaaaaaaaaaa",s) );


    }




   //rxjava操作符
    private void  RxJavaOperator(){
        //操作符map  用来把一个事件转换为另一个事件
        Observable.just("hello world!!")
                .map(s1 -> test())
                .subscribe(s->Log.i("aaaaaaaaaa",s));

      //操作符flatMap 接收一个Observable的输出作为输入，同时输出另外一个Observable。
        query("aaaaa").subscribe(urls->{

            //旧遍历用法
            for (String url : urls) {
                Log.i("aaaaaaaaaaaaas",url);
            }

            //from的用法==遍历
            Observable.from(urls).subscribe(url-> Log.i("aaaaaaaaaaaaafrom",url));

        });

/*        query("hehehe")
                .flatMap(new Func1<List<String>, Observable<?>>() {
                    @Override
                    public Observable<?> call(List<String> strings) {
                        return  Observable.from(strings);
                    }
                })
                .subscribe(url->Log.i("aaaaaaaaaaaaflatMap", (String) url));*/

         query("hehehe")
                .flatMap(urls-> Observable.from(urls))
                .subscribe(url->Log.i("aaaaaaaaaaaaflatMap", (String) url));


        //其他操作符
        query("Hello, world!")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .filter(title -> title != null)//过滤
                .take(5)//最多输出5个。
                .subscribe(title -> Log.i("aaaaaaaaaaaafilter",title));


    }

    //调度器
    private void RxJavaSchedulers(){
        query("Hello, world!")
                .subscribeOn(Schedulers.io())//Subscriberd的代码I/O线程中运行
                .observeOn(AndroidSchedulers.mainThread())//Observable对象在主线程执行
                .flatMap(urls-> Observable.from(urls))
                .subscribe(url->Log.i("aaaaaaaaaaaaflatMap", (String) url));

    }

    private void RxJavaSubscriptions(){
        Subscription subscription = Observable.just("Hello, World!")
                .subscribe(s -> System.out.println(s));

        subscription.unsubscribe();
        System.out.println("Unsubscribed=" + subscription.isUnsubscribed());
    }






    Observable<List<String>> query(String text) {
  /*      return  Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                List<String>  urls=new ArrayList<String>();
                urls.add("aaaaaaaa");
                urls.add("ccccccccc");
                urls.add("bbbbbbbb");
                subscriber.onNext(urls);

            }
        });*/
        //使用lambda
        return Observable.create(subscriber->{
            List<String>  urls=new ArrayList<String>();
            urls.add("aaaaaaaa");
            urls.add("ccccccccc");
            urls.add("bbbbbbbb");
            subscriber.onNext(urls);
        });
    }

    private  Observable<String> getTitle( String url){
         String[] s = {url};
        return Observable.create(subscriber1 -> {
            s[0] +="zhou";
            subscriber1.onNext(s[0]);
        });
    }

    private String test(){
        return "HEllo World";
    }
}
