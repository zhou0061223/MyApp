package com.zhou.jy.mvptest.ui.article;

import com.zhou.jy.mvptest.base.util.ApiUtil;
import com.zhou.jy.mvptest.base.util.SpUtil;
import com.zhou.jy.mvptest.data.entity.Image;
import com.zhou.jy.mvptest.data.entity._User;

/**
 * Created by baixiaokang on 16/5/4.
 */
public class ArticlePresenter extends ArticleContract.Presenter {
    @Override
    public void createComment(String content, Image article, _User user) {
        if (null == SpUtil.getUser())
            mView.showLoginAction();
        else
            mRxManage.add(mModel
                    .createComment(content,
                            ApiUtil.getPointer(article),
                            ApiUtil.getPointer(user))
                    .subscribe(
                            res -> mView.commentSuc(),
                            e -> mView.commentFail())
            );
    }
}
