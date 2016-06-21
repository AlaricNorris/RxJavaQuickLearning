package com.alaric.norris.study.mvvm_mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alaric.norris.study.mvvm_mvp.bean.MyIP;
import com.alaric.norris.study.mvvm_mvp.presenters.SearchPresenter;
import com.alaric.norris.study.mvvm_mvp.views.ISearchView;

public class MainActivity extends AppCompatActivity implements ISearchView {
    private EditText et_ip;
    private Button btn_search;
    private TextView tv_msg;
    private ProgressBar pb_load;
    private SearchPresenter mSearchPresenter = new SearchPresenter( this );

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        et_ip = ( EditText ) findViewById( R.id.et_ip );
        btn_search = ( Button ) findViewById( R.id.btn_search );
        tv_msg = ( TextView ) findViewById( R.id.tv_msg );
        pb_load = ( ProgressBar ) findViewById( R.id.pb_load );

        onClick();
    }

    private void onClick () {
        btn_search.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick ( View v ) {
                mSearchPresenter.Search();
            }
        } );
    }

    @Override
    public String getIPaddress () {
        return et_ip.getText().toString().trim();
    }

    @Override
    public void setMsg ( MyIP myIP ) {
        if ( myIP != null ) {
            tv_msg.setText( myIP.toString() );
        }
        else {
            tv_msg.setText( "获取失败" );
        }
    }

    @Override
    public void hideLoad () {
        pb_load.setVisibility( View.GONE );
    }

    @Override
    public void showLoad () {
        pb_load.setVisibility( View.VISIBLE );
    }
}