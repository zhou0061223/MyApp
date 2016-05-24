package com.zhou.jy.mvptest.ui.login;

import com.zhou.jy.mvptest.api.Api;
import com.zhou.jy.mvptest.base.util.helper.RxSchedulers;
import com.zhou.jy.mvptest.data.CreatedResult;
import com.zhou.jy.mvptest.data.entity._User;

import rx.Observable;

/**
 * Created by baixiaokang on 16/5/2.
 */
public class LoginModel implements LoginContract.Model {

    @Override
    public Observable<_User> login(String name, String pass) {
        return Api.getInstance().movieService
                .login(name, pass)
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<CreatedResult> sign(String name, String pass) {
        return Api.getInstance().movieService
                .createUser(new _User(name, pass))
                .compose(RxSchedulers.io_main());
    }
}
