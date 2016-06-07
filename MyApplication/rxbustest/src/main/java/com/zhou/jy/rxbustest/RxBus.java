package com.zhou.jy.rxbustest;

import android.support.annotation.NonNull;

import java.util.Vector;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by Administrator on 2016/6/3.
 */
public class RxBus {
    private static RxBus instance;
    private Vector<Subject> subjects=new Vector<>();


    private RxBus(){
    }

    public static synchronized  RxBus getInstance(){
        if(null==instance){

            instance=new RxBus();
        }
        return  instance;
    }

    public synchronized  <T>Observable<T> register(@NonNull Object objects){
        Subject<T,T> subject= PublishSubject.create();
        subjects.add(subject);
        return  subject;
    }

    public synchronized  void unregister(Object objects){
        subjects.remove(objects);
    }

    public void post(@NonNull Object content){
        synchronized (this){
            for(Subject subject:subjects){
                  if(subject!=null){
                     subject.onNext(content);
                  }
            }
        }
    }



}
