package com.alaric.norris.study.mvvm_mvp.viewmodel;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.alaric.norris.study.mvvm_mvp.bean.IPAddress;
import com.alaric.norris.study.mvvm_mvp.databinding.ActivityHomeBinding;
import com.alaric.norris.study.mvvm_mvp.model.SearchModel;
import com.alaric.norris.study.mvvm_mvp.onSearchListener;
public class MainViewModel implements onSearchListener {

    private ActivityHomeBinding binding;
    private SearchModel searchModel = new SearchModel();
    private Handler handler;

    public MainViewModel ( ActivityHomeBinding binding ) {
        this.binding = binding;
        handler = new Handler( Looper.getMainLooper() );
    }

    public void search ( View view ) {
        binding.pbLoad.setVisibility( View.VISIBLE );
        searchModel.getIPaddressInfo( binding.etIp.getText().toString().trim(), this );
    }

    @Override
    public void onSuccess ( final IPAddress ipAddress ) {
        handler.post( new Runnable() {

            @Override
            public void run () {
                binding.pbLoad.setVisibility( View.GONE );
                binding.tvMsg.setText( ipAddress.toString() );
            }
        } );
    }
    @Override
    public void onError () {

        handler.post( new Runnable() {

            @Override
            public void run () {
                binding.pbLoad.setVisibility( View.GONE );
                binding.tvMsg.setText( "查询失败" );
            }
        } );
    }
}