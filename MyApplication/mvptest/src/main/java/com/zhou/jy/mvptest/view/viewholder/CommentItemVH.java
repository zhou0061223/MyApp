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
import com.zhou.jy.mvptest.ui.user.UserActivity;


/**
 * Created by baixiaokang on 16/5/4.
 */
public class CommentItemVH extends BaseViewHolder<CommentInfo> {
    TextView tv_content;
    ImageView im_user;

    public CommentItemVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_comment;
    }

    @Override
    public void onBindViewHolder(View view, final CommentInfo mSubject) {
        tv_content.setText(mSubject.content);
        ImageUtil.loadRoundImg(im_user,mSubject.creater.face);
        im_user.setOnClickListener(v ->
                ActivityCompat.startActivity((Activity) mContext, new Intent(mContext, UserActivity.class).putExtra(C.HEAD_DATA, mSubject.creater)
                        , ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, im_user, ArticleActivity.TRANSLATE_VIEW).toBundle())
        );
    }
}
