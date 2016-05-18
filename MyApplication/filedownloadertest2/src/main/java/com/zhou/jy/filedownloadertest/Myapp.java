package com.zhou.jy.filedownloadertest;

import android.app.Application;

import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by Administrator on 2016/4/22.
 */
public class Myapp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.init(getApplicationContext());
    }
}
