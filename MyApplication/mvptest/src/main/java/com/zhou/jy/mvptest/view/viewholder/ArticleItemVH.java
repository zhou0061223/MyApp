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
import com.zhou.jy.mvptest.data.entity.Image;
import com.zhou.jy.mvptest.ui.article.ArticleActivity;

/**
 * Created by baixiaokang on 16/4/23.
 */
public class ArticleItemVH extends BaseViewHolder<Image> {

    ImageView image;
    TextView tv_title, tv_des, tv_info, tv_time;

    public ArticleItemVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_card_main;
    }

    @Override
    public void onBindViewHolder(View view, final Image mSubject) {
        ImageUtil.loadImg(image, mSubject.image);
        tv_title.setText(mSubject.title);
        tv_des.setText(mSubject.author);
        tv_info.setText(mSubject.type);
        tv_time.setText(mSubject.createdAt);
        view.setOnClickListener((v) ->
                ActivityCompat.startActivity((Activity) mContext, new Intent(mContext, ArticleActivity.class).putExtra(C.HEAD_DATA, mSubject)
                        , ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, image, ArticleActivity.TRANSLATE_VIEW).toBundle())
        );
    }
}
