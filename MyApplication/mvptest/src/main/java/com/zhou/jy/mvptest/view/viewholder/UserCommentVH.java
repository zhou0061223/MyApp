package com.zhou.jy.mvptest.view.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhou.jy.mvptest.C;
import com.zhou.jy.mvptest.R;
import com.zhou.jy.mvptest.base.BaseViewHolder;
import com.zhou.jy.mvptest.base.util.ImageUtil;
import com.zhou.jy.mvptest.data.entity.CommentInfo;
import com.zhou.jy.mvptest.ui.article.ArticleActivity;


/**
 * Created by baixiaokang on 16/5/4.
 */
public class UserCommentVH extends BaseViewHolder<CommentInfo> {
    TextView tv_content,tv_title;
    ImageView im_article;

    public UserCommentVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_user_comment;
    }

    @Override
    public void onBindViewHolder(View view, final CommentInfo mSubject) {
        tv_content.setText(mSubject.content);
        tv_title.setText(mSubject.article.title);
        ImageUtil.loadImg(im_article,mSubject.article.image);
        view.setOnClickListener((v) ->
                ActivityCompat.startActivity((Activity) mContext, new Intent(mContext, ArticleActivity.class).putExtra(C.HEAD_DATA, mSubject.article)
                        , ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, im_article, ArticleActivity.TRANSLATE_VIEW).toBundle())
        );
    }
}
