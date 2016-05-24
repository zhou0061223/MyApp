package com.zhou.jy.mvptest.ui.user;

import com.zhou.jy.mvptest.C;
import com.zhou.jy.mvptest.base.util.SpUtil;
import com.zhou.jy.mvptest.data.entity._User;

import java.io.File;

/**
 * Created by baixiaokang on 16/5/5.
 */
public class UserPresenter extends UserContract.Presenter {


    @Override
    public void upLoadFace(File file) {
        mRxManage.add(mModel.upFile(file).subscribe(
                res -> upUserInfo(res.url),
                e -> mView.showMsg("上传失败!")));
    }

    @Override
    public void upUserInfo(String face) {
        _User user = SpUtil.getUser();
        user.face = face;
        mRxManage.add(mModel.upUser(user).subscribe(
                res -> {
                    SpUtil.setUser(user);
                    mRxManage.post(C.EVENT_LOGIN, user);
                    mView.showMsg("更新成功!");
                },
                e -> mView.showMsg("更新失败!")));
    }

    @Override
    public void onStart() {
        mRxManage.on(C.EVENT_LOGIN, user -> mView.initUser((_User) user));
    }
}
