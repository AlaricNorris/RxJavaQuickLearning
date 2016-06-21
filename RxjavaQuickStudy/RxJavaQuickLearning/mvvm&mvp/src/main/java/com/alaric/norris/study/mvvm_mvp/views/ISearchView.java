package com.alaric.norris.study.mvvm_mvp.views;
import com.alaric.norris.study.mvvm_mvp.bean.MyIP;
public interface ISearchView {
    String getIPaddress ();

    void setMsg ( MyIP myIP );

    void hideLoad ();

    void showLoad ();
}