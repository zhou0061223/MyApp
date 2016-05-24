package com.zhou.jy.mvptest.ui.login;

import com.zhou.jy.mvptest.C;
import com.zhou.jy.mvptest.base.util.SpUtil;

/**
 * Created by baixiaokang on 16/4/29.
 */
public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void login(String name, String pass) {
        mRxManage.add(mModel.login(name, pass).subscribe(user -> {
                    SpUtil.setUser(user);
                    mRxManage.post(C.EVENT_LOGIN, user);
                    mView.loginSuccess();
                }, e -> mView.showMsg("登录失败!")
        ));
    }

    @Override
    public void sign(String name, String pass) {
        mRxManage.add(mModel.sign(name, pass)
                .subscribe(res -> mView.signSuccess(),
                        e -> mView.showMsg("注册失败!")));
    }
}
