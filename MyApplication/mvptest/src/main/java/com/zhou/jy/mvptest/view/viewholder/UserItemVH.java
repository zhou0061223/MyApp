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
import com.zhou.jy.mvptest.data.entity._User;
import com.zhou.jy.mvptest.ui.article.ArticleActivity;
import com.zhou.jy.mvptest.ui.user.UserActivity;

/**
 * Created by baixiaokang on 16/5/4.
 */
public class UserItemVH extends BaseViewHolder<_User> {
    TextView tv_content;
    ImageView im_user;

    public UserItemVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_user;
    }

    @Override
    public void onBindViewHolder(View view, final _User user) {
        tv_content.setText(user.username);
        ImageUtil.loadRoundImg(im_user,user.face);
        im_user.setOnClickListener(v ->
                ActivityCompat.startActivity((Activity) mContext, new Intent(mContext, UserActivity.class).putExtra(C.HEAD_DATA, user)
                        , ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, im_user, ArticleActivity.TRANSLATE_VIEW).toBundle())
        );
    }
}
