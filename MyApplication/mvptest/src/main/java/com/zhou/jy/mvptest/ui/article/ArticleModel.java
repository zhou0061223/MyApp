package com.zhou.jy.mvptest.ui.article;


import com.zhou.jy.mvptest.api.Api;
import com.zhou.jy.mvptest.base.util.helper.RxSchedulers;
import com.zhou.jy.mvptest.data.CreatedResult;
import com.zhou.jy.mvptest.data.Pointer;
import com.zhou.jy.mvptest.data.entity.Comment;

import rx.Observable;

/**
 * Created by baixiaokang on 16/5/4.
 */
public class ArticleModel implements ArticleContract.Model {

    @Override
    public Observable<CreatedResult> createComment(String content, Pointer article, Pointer user) {
        return Api.getInstance().movieService
                .createComment(new Comment(article, content, user))
                .compose(RxSchedulers.io_main());
    }
}