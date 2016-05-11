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
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.alaric.norris.study.retrofitstudy.ApiService;
import com.alaric.norris.study.retrofitstudy.GetIpInfoResponse;
import com.alaric.norris.study.retrofitstudy.RetrofitActivity;
import com.alaric.norris.study.retrofitstudy.njbbs.applydemo.NJBBSService;
import com.alaric.norris.study.rxjavastudy.RxJavaStudyActivity;
import com.jakewharton.rxbinding.view.RxView;

import java.io.IOException;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;
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
    @InjectView ( R.id.email )
    public AutoCompleteTextView button;
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
        //        RxAndRetrofit();

        Action1< Void > action1 = new Action1< Void >() {

            @Override
            public void call ( Void inView ) {
                Log.i( "tag", "click" );

            }
        };
        RxView.clicks( button ) // 以 Observable 形式来反馈点击事件
              //              .throttleFirst( 3300, TimeUnit.MILLISECONDS )
              .subscribe( action1 );
        njbbsApply();
    }
    private void njbbsApply () {
        Retrofit mRetrofit = new Retrofit.Builder().baseUrl( NJBBSService.NJBBS_VERSION_URL )

                                                   .addConverterFactory(
                                                           GsonConverterFactory.create() )
                                                   .build();
        NJBBSService apiService = mRetrofit.create( NJBBSService.class );
        final Call< Object > model = apiService.checkVersion( "chafang" );
        new Thread() {

            @Override
            public void run () {

                try {
                    Response< Object > response = model.execute();
                    Log.i( "tag", "response checkVersion" + response.body().toString() );
                }
                catch ( IOException inE ) {
                    inE.printStackTrace();
                }
            }
        }.start();
        {
            mRetrofit = new Retrofit.Builder().baseUrl( NJBBSService.CFAPI_URL )
                                              .addConverterFactory( GsonConverterFactory.create() )
                                              .build();
            apiService = mRetrofit.create( NJBBSService.class );
            final HashMap< String, String > mHashMap = new HashMap<>();
            mHashMap.put( "method", "forum.sendAndroidDeviceInfo" );
            mHashMap.put( "api_key", "android" );
            mHashMap.put( "deviceid", "355848066910830" );
            mHashMap.put( "city", "NJ" );
            mHashMap.put( "v", "4.1.0" );
            final Call< Object > a = apiService.sendAndroidDeviceInfo( mHashMap );

            new Thread() {

                @Override
                public void run () {

                    try {
                        Response< Object > response = a.execute();
                        Log.i( "tag", "response sendAndroidDeviceInfo" + response.toString() );
                    }
                    catch ( IOException inE ) {
                        inE.printStackTrace();
                    }
                }
            }.start();
            mHashMap.clear();
            mHashMap.put( "method", "user.getUserInfoById" );
            mHashMap.put( "uid", "1431" );
            final NJBBSService finalApiService = apiService;
            new Thread() {

                @Override
                public void run () {

                    try {
                        Response< Object > response =
                                finalApiService.getUserInfoById( mHashMap ).execute();
                        Log.i( "tag", "response getUserInfoById" + response.toString() );
                    }
                    catch ( IOException inE ) {
                        inE.printStackTrace();
                    }
                }
            }.start();
            mHashMap.clear();
            mHashMap.put("method", "forum.getThreadInfoByID");
            mHashMap.put( "id", "1431" );
            new Thread() {

                @Override
                public void run () {

                    try {
                        Response< Object > response =
                                finalApiService.getThreadInfoByID( mHashMap ).execute();
                        Log.i( "tag", "response getThreadInfoByID" + response.toString() );
                    }
                    catch ( IOException inE ) {
                        inE.printStackTrace();
                    }
                }
            }.start();

        }

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
