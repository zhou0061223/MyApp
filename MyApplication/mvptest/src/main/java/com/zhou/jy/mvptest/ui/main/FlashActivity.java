package com.zhou.jy.mvptest.ui.main;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;


import com.zhou.jy.mvptest.R;
import com.zhou.jy.mvptest.base.BaseActivity;
import com.zhou.jy.mvptest.base.util.AnimationUtil;
import com.zhou.jy.mvptest.base.util.StatusBarUtil;
import com.zhou.jy.mvptest.ui.home.HomeActivity;
import com.zhou.jy.mvptest.view.widget.FireView;

import butterknife.Bind;

/**
 * Created by baixiaokang on 16/4/28.
 */
public class FlashActivity extends BaseActivity {

    @Bind(R.id.fl_main)
    FrameLayout fl_main;
    @Bind(R.id.view)
    View view;


    @Override
    public int getLayoutId() {
        return R.layout.activity_flash;
    }

    @Override
    public void initView() {
        StatusBarUtil.setTranslucentBackground(this);
        FireView mFireView = new FireView(this);
        fl_main.addView(mFireView,
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));

        AlphaAnimation anim = new AlphaAnimation(0.8f, 0.1f);
        anim.setDuration(5000);
        view.startAnimation(anim);
        AnimationUtil.setAnimationListener(anim, () -> {
            startActivity(new Intent(mContext, HomeActivity.class));
            finish();
        });
    }

    @Override
    public void initPresenter() {
    }
}
