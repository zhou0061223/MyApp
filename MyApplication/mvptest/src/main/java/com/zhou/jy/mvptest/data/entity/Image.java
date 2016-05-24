package com.zhou.jy.mvptest.data.entity;


import com.zhou.jy.mvptest.C;
import com.zhou.jy.mvptest.api.Api;
import com.zhou.jy.mvptest.base.BaseEntity;
import com.zhou.jy.mvptest.base.util.ApiUtil;
import com.zhou.jy.mvptest.base.util.helper.RxSchedulers;
import com.zhou.jy.mvptest.data.Data;

import rx.Observable;

/**
 * Created by Administrator on 2016/4/7.
 */
public class Image extends BaseEntity.ListBean {
    public String image;
    public String createdAt;
    public String article;
    public String author;
    public String title;
    public String type;

    @Override
    public Observable<Data<Image>> getPageAt(final int page) {
        return Api.getInstance().movieService
                .getAllImages(ApiUtil.getWhere(param),"-createdAt", C.PAGE_COUNT * (page - 1), C.PAGE_COUNT)
                .compose(RxSchedulers.io_main());
    }
}
