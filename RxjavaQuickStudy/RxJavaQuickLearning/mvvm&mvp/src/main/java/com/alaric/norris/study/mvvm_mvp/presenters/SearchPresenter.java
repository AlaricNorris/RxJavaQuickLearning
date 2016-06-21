package com.alaric.norris.study.mvvm_mvp.presenters;
import android.os.Handler;
import android.os.Looper;

import com.alaric.norris.study.mvvm_mvp.bean.MyIP;
import com.alaric.norris.study.mvvm_mvp.biz.ISearchModel;
import com.alaric.norris.study.mvvm_mvp.biz.SearchModel;
import com.alaric.norris.study.mvvm_mvp.views.ISearchView;
public class SearchPresenter implements ISearchPresenter, onSearchListener {
    ISearchView searchView;
    ISearchModel searchModel;
    Handler handler;
    public SearchPresenter ( ISearchView searchView ) {
        this.searchView = searchView;
        searchModel = new SearchModel();
        handler = new Handler( Looper.getMainLooper() );
    }
    @Override
    public void Search () {
        searchView.showLoad();
        searchModel.getIPaddressInfo( searchView.getIPaddress(), this );
    }
    @Override
    public void onSuccess ( final MyIP myIP ) {
        handler.post( new Runnable() {

            @Override
            public void run () {
                searchView.setMsg( myIP );
                searchView.hideLoad();
            }
        } );
    }
    @Override
    public void onError () {
        handler.post( new Runnable() {

            @Override
            public void run () {
                searchView.setMsg( null );
                searchView.hideLoad();
            }
        } );
    }
}