package com.zhou.jy.designtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Fragment1 extends BaseFragment{
    @Bind(R.id.btn_fra1_coll)
    Button btn;


    @OnClick(R.id.btn_fra1_coll)
    void toCollActivity(View view){
        Intent intent=new Intent(this.getActivity(),CollActivity.class);
        startActivity(intent);
    }
    @Override
    public int getContentView() {
        return R.layout.fragment1;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void init() {

    }


}
