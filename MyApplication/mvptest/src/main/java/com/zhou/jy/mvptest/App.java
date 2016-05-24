package com.zhou.jy.mvptest;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.zhou.jy.mvptest.base.util.SpUtil;


/**
 * Created by baixiaokang on 16/4/23.
 */
public class App extends Application {
    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        SpUtil.init(this);
    }

    public static Context getAppContext() {
        return mApp;
    }

    public static Resources getAppResources() {
        return mApp.getResources();
    }

}
