package com.alaric.norris.study.mvp.mvp.biz;

import com.alaric.norris.study.mvp.mvp.bean.User;
/**
 * Created by zhy on 15/6/19.
 */
public interface OnLoginListener {
    void loginSuccess ( User user );

    void loginFailed ();
}
