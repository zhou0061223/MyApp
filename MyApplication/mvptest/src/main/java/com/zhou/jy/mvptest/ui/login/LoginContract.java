package com.zhou.jy.mvptest.ui.login;

import com.zhou.jy.mvptest.base.BaseModel;
import com.zhou.jy.mvptest.base.BasePresenter;
import com.zhou.jy.mvptest.base.BaseView;
import com.zhou.jy.mvptest.data.CreatedResult;
import com.zhou.jy.mvptest.data.entity._User;

import rx.Observable;

/**
 * Created by baixiaokang on 16/4/29.
 */
public interface LoginContract {
    interface Model extends BaseModel {
        Observable<_User> login(String name, String pass);
        Observable<CreatedResult> sign(String name, String pass);
    }

    interface View extends BaseView {
        void loginSuccess();
        void signSuccess();
        void showMsg(String msg);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void login(String name, String pass);
        public abstract void sign(String name, String pass);
        @Override
        public void onStart() {}
    }
}
