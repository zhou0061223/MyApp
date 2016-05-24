package com.zhou.jy.mvptest.ui.user;

import com.zhou.jy.mvptest.base.BaseModel;
import com.zhou.jy.mvptest.base.BasePresenter;
import com.zhou.jy.mvptest.base.BaseView;
import com.zhou.jy.mvptest.data.CreatedResult;
import com.zhou.jy.mvptest.data.entity._User;

import java.io.File;

import rx.Observable;

/**
 * Created by baixiaokang on 16/5/5.
 */
public interface UserContract {
    interface Model extends BaseModel {
        Observable<CreatedResult> upFile(File file);

        Observable upUser(_User user);
    }


    interface View extends BaseView {

        void showMsg(String msg);
       void  initUser(_User user);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void upLoadFace(File f);

        public abstract void upUserInfo(String face);
    }
}
