package com.zhou.jy.huzhi.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhou.jy.huzhi.R;
import com.zhou.jy.huzhi.base.BaseFragment;
import com.zhou.jy.huzhi.base.entity.ThemeData;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/6/21.
 */
public class HomeFragment extends BaseFragment{
    List<ThemeData.storie> stories=new ArrayList<>();

    public HomeFragment(){

    }

    @Bind(R.id.RV_home)
    RecyclerView recyclerView;


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(new CommonAdapter<ThemeData.storie>(mContext,R.layout.fragment_home_item,stories){

            @Override
            public void convert(ViewHolder holder, ThemeData.storie storie) {
                holder.getView(R.id.IV_home_item);
                holder.setText(R.id.TV_home_item,storie.title);
            }
        });
    }
}
