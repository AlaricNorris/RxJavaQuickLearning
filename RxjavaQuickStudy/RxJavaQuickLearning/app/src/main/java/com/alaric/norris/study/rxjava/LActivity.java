/**
 *  LActivity
 *  com.alaric.norris.study.rxjava
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/4/22         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.alaric.norris.study.retrofitstudy.ApiService;
import com.alaric.norris.study.retrofitstudy.GetIpInfoResponse;
import com.alaric.norris.study.retrofitstudy.RetrofitActivity;
import com.alaric.norris.study.rxjavastudy.RxJavaStudyActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
/**
 @formatter:off ClassName:      LActivity
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/4/22    14:52
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 http://gank.io/post/560e15be2dca930e00da1083#toc_4
 */
public class LActivity extends AppCompatActivity {

    public ImageView imageView = null;
    private String tag = "tag";
    @OnClick ( R.id.email_sign_in_button )
    public void jumpRetrofit () {
        startActivity( new Intent( getApplicationContext(), RetrofitActivity.class ) );
    }
    @OnClick ( R.id.password )
    public void jumpRxJava () {
        startActivity( new Intent( getApplicationContext(), RxJavaStudyActivity.class ) );
    }
    @Override
    public void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        ButterKnife.inject( this );
        RxAndRetrofit();
    }

    public void RxAndRetrofit () {

        Retrofit retrofit = new Retrofit.Builder().baseUrl( "http://ip.taobao.com" )
                                                  .addConverterFactory(
                                                          GsonConverterFactory.create() )
                                                  .addCallAdapterFactory(
                                                          RxJavaCallAdapterFactory.create() )
                                                  .build();
        ApiService apiService = retrofit.create( ApiService.class );
        apiService.getRXIpInfo( "63.223.108.42" )
                  .doOnNext( new Action1< GetIpInfoResponse >() {

                      @Override
                      public void call ( GetIpInfoResponse inGetIpInfoResponse ) {
                          processIP();
                      }
                  } )
                  .subscribeOn( Schedulers.io() )

                  .observeOn( AndroidSchedulers.mainThread() )
                  .subscribe( new Subscriber< GetIpInfoResponse >() {

                      @Override
                      public void onCompleted () {
                      }

                      @Override
                      public void onError ( Throwable e ) {
                          Log.d( "tag", "getRXIpInfo" + e.getMessage() );
                      }

                      @Override
                      public void onNext ( GetIpInfoResponse getIpInfoResponse ) {
                          Log.d( "tag", "getRXIpInfo" + getIpInfoResponse.data );
                      }
                  } );
    }
    private void processIP () {
    }

}
