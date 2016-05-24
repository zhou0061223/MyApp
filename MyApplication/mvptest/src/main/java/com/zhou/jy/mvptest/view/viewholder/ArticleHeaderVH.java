package com.zhou.jy.mvptest.view.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.zhou.jy.mvptest.R;
import com.zhou.jy.mvptest.base.BaseViewHolder;
import com.zhou.jy.mvptest.data.entity.Image;


/**
 * Created by baixiaokang on 16/5/4.
 */
public class ArticleHeaderVH extends BaseViewHolder<Image> {
    TextView tv_article;

    public ArticleHeaderVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_article;
    }

    @Override
    public void onBindViewHolder(View view, Image obj) {
        String article = obj.article.replace("<br>", "\n").replaceAll(" ", "").replaceAll("//", "");
        if (!TextUtils.isEmpty(article)) {
            article = article.substring(article.indexOf("&gt;") + 4, article.length());
            tv_article.setText(article);
        }
    }
}
