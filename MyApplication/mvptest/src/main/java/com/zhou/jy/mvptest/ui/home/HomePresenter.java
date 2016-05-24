package com.zhou.jy.mvptest.ui.home;


import com.zhou.jy.mvptest.C;
import com.zhou.jy.mvptest.base.util.SpUtil;
import com.zhou.jy.mvptest.data.entity._User;

/**
 * Created by baixiaokang on 16/4/22.
 */
public class HomePresenter extends HomeContract.Presenter {

    @Override
    public void getTabList() {
        mView.showTabList(mModel.getTabs());
    }

    @Override
    public void getUserInfo() {
        _User user = SpUtil.getUser();
        if (user != null)
            mView.initUserInfo(user);
    }

    @Override
    public void onStart() {
        getTabList();
        getUserInfo();
        mRxManage.on(C.EVENT_LOGIN, arg -> mView.initUserInfo((_User) arg));
    }
}
