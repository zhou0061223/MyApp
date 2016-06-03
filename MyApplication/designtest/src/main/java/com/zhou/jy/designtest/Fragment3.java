package com.zhou.jy.designtest;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Fragment3 extends BaseFragment{

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public int getContentView() {
        return R.layout.fragment3;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void init() {
        List<String> strs=new ArrayList<>();
        for(int i=0;i<20;i++){
            strs.add("zhooooooou"+i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(new CommonAdapter<String>(mContext,R.layout.item,strs) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.tv_name,s);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                List<String> strs=new ArrayList<>();
                for(int i=0;i<20;i++){
                    strs.add("yyyyyyyyyyyyyyyy"+i);
                }
                recyclerView.setAdapter(new CommonAdapter<String>(mContext,R.layout.item,strs) {
                    @Override
                    public void convert(ViewHolder holder, String s) {
                        holder.setText(R.id.tv_name,s);
                    }
                });
                swipeRefreshLayout.setRefreshing(false);

            }
        });
    }


}
