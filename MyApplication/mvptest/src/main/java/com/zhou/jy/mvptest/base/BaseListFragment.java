package com.zhou.jy.mvptest.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhou.jy.mvptest.C;
import com.zhou.jy.mvptest.base.util.TUtil;
import com.zhou.jy.mvptest.view.layout.TRecyclerView;


public class BaseListFragment extends Fragment {
    private TRecyclerView mXRecyclerView;

    /**
     * @param vh 传入VH的类名
     * @return
     */
    public static BaseListFragment newInstance(Class<? extends BaseViewHolder> vh,String type) {
        Bundle arguments = new Bundle();
        arguments.putString(C.VH_CLASS, vh.getCanonicalName());
        arguments.putString("type",type);
        BaseListFragment fragment = new BaseListFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mXRecyclerView = new TRecyclerView(getContext()).setParam("type",getArguments().getString("type"))
                .setView(TUtil.forName(getArguments().getString(C.VH_CLASS)));
        return mXRecyclerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mXRecyclerView != null) mXRecyclerView.fetch();
    }
}
