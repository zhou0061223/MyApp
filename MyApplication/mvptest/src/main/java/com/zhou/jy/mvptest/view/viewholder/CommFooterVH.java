package com.zhou.jy.mvptest.view.viewholder;


import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhou.jy.mvptest.R;
import com.zhou.jy.mvptest.base.BaseViewHolder;


public class CommFooterVH extends BaseViewHolder<Object> {
    public ProgressBar progressbar;
    public TextView tv_state;
    public static final int LAYOUT_TYPE = R.layout.list_footer_view;

    public CommFooterVH(View view) {
        super(view);
    }

    @Override
    public int getType() {
        return LAYOUT_TYPE;
    }

    @Override
    public void onBindViewHolder(View view, Object o) {
        boolean isHasMore = (o == null ? false : true);
        progressbar.setVisibility(isHasMore ? View.VISIBLE : View.GONE);
        tv_state.setText(isHasMore ? "正在加载" : "已经到底");
    }
}