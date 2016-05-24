package com.zhou.jy.mvptest.data.entity;

import com.zhou.jy.mvptest.C;
import com.zhou.jy.mvptest.api.Api;
import com.zhou.jy.mvptest.base.BaseEntity;
import com.zhou.jy.mvptest.base.util.helper.RxSchedulers;

import rx.Observable;

/**
 * Created by baixiaokang on 16/4/29.
 */
public class _User extends BaseEntity.ListBean {
    public String username;
    public String password;
    public String face;
    public String sessionToken;

    public _User() {
    }

    public _User(String name, String pass) {
        this.username = name;
        this.password = pass;
    }

    @Override
    public Observable getPageAt(int page) {
        return Api.getInstance().movieService.getAllUser(C.PAGE_COUNT * (page - 1), C.PAGE_COUNT).compose(RxSchedulers.io_main());
    }
}
