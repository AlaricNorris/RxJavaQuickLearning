package com.alaric.norris.study.mvvm_mvp.biz;
import com.alaric.norris.study.mvvm_mvp.presenters.onSearchListener;
public interface ISearchModel {

    void getIPaddressInfo ( String ipAddress, onSearchListener onSearchListener );
}