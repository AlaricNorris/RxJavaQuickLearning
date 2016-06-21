package com.alaric.norris.study.mvvm_mvp.presenters;
import com.alaric.norris.study.mvvm_mvp.bean.MyIP;
public interface onSearchListener {

    void onSuccess ( MyIP myIP );

    void onError ();
}