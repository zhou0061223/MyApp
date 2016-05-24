package com.zhou.jy.mvptest.data.entity;

import com.zhou.jy.mvptest.C;
import com.zhou.jy.mvptest.api.Api;
import com.zhou.jy.mvptest.base.BaseEntity;
import com.zhou.jy.mvptest.base.util.ApiUtil;
import com.zhou.jy.mvptest.base.util.helper.RxSchedulers;
import com.zhou.jy.mvptest.data.Data;

import rx.Observable;

/**
 * Created by baixiaokang on 16/5/4.
 */
public class CommentInfo extends BaseEntity.ListBean {
    public Image article;
    public String content;
    public _User creater;

    @Override
    public Observable<Data<CommentInfo>> getPageAt(int page) {
        return Api.getInstance().movieService
                .getCommentList(ApiUtil.getInclude(param), ApiUtil.getWhere(param), C.PAGE_COUNT * (page - 1), C.PAGE_COUNT)
                .compose(RxSchedulers.io_main());
    }
}
