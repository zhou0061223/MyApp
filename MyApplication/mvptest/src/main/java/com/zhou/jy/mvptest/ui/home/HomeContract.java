package com.zhou.jy.mvptest.ui.home;


import com.zhou.jy.mvptest.base.BaseModel;
import com.zhou.jy.mvptest.base.BasePresenter;
import com.zhou.jy.mvptest.base.BaseView;
import com.zhou.jy.mvptest.data.entity._User;

public interface HomeContract {
    interface Model extends BaseModel {
        String[] getTabs();
    }


    interface View extends BaseView {
        void showTabList(String[] mTabs);

        void initUserInfo(_User user);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getTabList();

        public abstract void getUserInfo();
    }
}
