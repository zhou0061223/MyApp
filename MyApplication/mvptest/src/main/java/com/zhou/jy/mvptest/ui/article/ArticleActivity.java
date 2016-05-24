package com.zhou.jy.mvptest.ui.article;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.zhou.jy.mvptest.C;
import com.zhou.jy.mvptest.R;
import com.zhou.jy.mvptest.base.BaseActivity;
import com.zhou.jy.mvptest.base.util.ImageUtil;
import com.zhou.jy.mvptest.base.util.SpUtil;
import com.zhou.jy.mvptest.base.util.ViewUtil;
import com.zhou.jy.mvptest.data.Pointer;
import com.zhou.jy.mvptest.data.entity.Image;
import com.zhou.jy.mvptest.ui.login.LoginActivity;
import com.zhou.jy.mvptest.view.layout.TRecyclerView;
import com.zhou.jy.mvptest.view.viewholder.ArticleHeaderVH;
import com.zhou.jy.mvptest.view.viewholder.CommentItemVH;


import butterknife.Bind;

public class ArticleActivity extends BaseActivity<ArticlePresenter, ArticleModel> implements ArticleContract.View {
    public static final String TRANSLATE_VIEW = "share_img";
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_comment)
    EditText et_comment;
    @Bind(R.id.bt_comment)
    Button bt_comment;
    @Bind(R.id.lv_comment)
    TRecyclerView lv_comment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void initView() {
        Image mSubject = (Image) getIntent().getSerializableExtra(C.HEAD_DATA);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ImageUtil.loadImg(image, mSubject.image);
        setTitle(mSubject.title);
        ViewCompat.setTransitionName(image, TRANSLATE_VIEW);
        bt_comment.setOnClickListener(v -> {
            if (TextUtils.isEmpty(et_comment.getText().toString())) {
                Snackbar.make(fab, "评论不能为空!", Snackbar.LENGTH_LONG).show();
            } else
                mPresenter.createComment(et_comment.getText().toString(), mSubject, SpUtil.getUser());
        });
        lv_comment.setHeadView(ArticleHeaderVH.class)
                .setView(CommentItemVH.class)
                .setParam("include", "creater")
                .setParam("article", new Gson().toJson(new Pointer(Image.class.getSimpleName(), mSubject.objectId)))
                .setIsRefreshable(false)
                .fetch();
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    public void checkin(View view) {
        Snackbar.make(view, "没啥卵用", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overaction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void commentSuc() {
        lv_comment.reFetch();
        Snackbar.make(fab, "评论成功!", Snackbar.LENGTH_LONG).show();
        ViewUtil.hideKeyboard(this);
    }

    @Override
    public void commentFail() {
        Snackbar.make(fab, "评论失败!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginAction() {
        Snackbar.make(fab, "请先登录!", Snackbar.LENGTH_LONG)
                .setAction("登录", view -> startActivity(new Intent(mContext, LoginActivity.class))).show();
    }
}
