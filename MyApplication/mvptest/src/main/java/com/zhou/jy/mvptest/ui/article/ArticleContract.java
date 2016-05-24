package com.zhou.jy.mvptest.ui.article;

import com.zhou.jy.mvptest.base.BaseModel;
import com.zhou.jy.mvptest.base.BasePresenter;
import com.zhou.jy.mvptest.base.BaseView;
import com.zhou.jy.mvptest.data.Pointer;
import com.zhou.jy.mvptest.data.entity.Image;
import com.zhou.jy.mvptest.data.entity._User;

import rx.Observable;


/**
 * Created by baixiaokang on 16/4/22.
 */
public interface ArticleContract {
    interface Model extends BaseModel {
        Observable createComment(String content, Pointer article, Pointer user);
    }


    interface View extends BaseView {
        void commentSuc();
        void commentFail();
        void showLoginAction();
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void createComment(String content, Image article, _User user);
        @Override
        public void onStart() {}
    }
}

