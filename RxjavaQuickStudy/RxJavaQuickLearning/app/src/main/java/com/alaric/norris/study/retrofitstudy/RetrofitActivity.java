/**
 *  RetrofitActivity
 *  com.alaric.norris.study.rxjava.retrofitstudy
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/4/25         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.retrofitstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/**
 @formatter:off ClassName:      RetrofitActivity
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/4/25    15:14
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class RetrofitActivity extends AppCompatActivity {
    @Override
    protected void onCreate ( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        Retrofit retrofitt = new Retrofit.Builder().baseUrl( "https://api.github.com" )
                                                   .addConverterFactory(
                                                           GsonConverterFactory.create() )
                                                   .build();
        GitApiService services = retrofitt.create( GitApiService.class );
        Call< GitModel > model = services.getFeed( "AlaricNorris" );
        model.enqueue( new Callback< GitModel >() {

            @Override
            public void onResponse (
                    Call< GitModel > call, Response< GitModel > response
            ) {
                Log.e( "tag", "onResponse: " + response.message() + response.body().toString() );
            }
            @Override
            public void onFailure (
                    Call< GitModel > call, Throwable t
            ) {
                Log.e( "tag", "onFailure: " + t.getMessage() );
            }
        } );

        {
            Retrofit retrofit = new Retrofit.Builder().addConverterFactory(
                    GsonConverterFactory.create( new Gson() ) )
                                                      .baseUrl( "https://api.github.com/" )
                                                      .build();

            GitHubService service = retrofit.create( GitHubService.class );
            Call< List< Repo > > repos = service.listRepos( "AlaricNorris" );
            repos.enqueue( new Callback< List< Repo > >() {

                @Override
                public void onResponse (
                        Call< List< Repo > > call, Response< List< Repo > > response
                ) {
                    Log.i( "tag", "" + response.body().toString() );
                }
                @Override
                public void onFailure (
                        Call< List< Repo > > call, Throwable t
                ) {

                }
            } );
        }
        {
            Retrofit rretrofit = new Retrofit.Builder().baseUrl( "http://ip.taobao.com" )
                                                       .addConverterFactory(
                                                               GsonConverterFactory.create() )
                                                       .build();
            ApiService apiService = rretrofit.create( ApiService.class );

            Call< GetIpInfoResponse > call = apiService.getIpInfo( "63.223.108.42" );
            call.enqueue( new Callback< GetIpInfoResponse >() {

                @Override
                public void onResponse (
                        Call< GetIpInfoResponse > call, Response< GetIpInfoResponse > response
                ) {

                    GetIpInfoResponse getIpInfoResponse = response.body();
                    Log.d( "tag", "" + getIpInfoResponse.data );
                }
                @Override
                public void onFailure (
                        Call< GetIpInfoResponse > call, Throwable t
                ) {
                    Log.e( "tag", "" + t.getMessage() );
                }
            } );
            Retrofit RXretrofit = new Retrofit.Builder().baseUrl( "http://ip.taobao.com" )
                                                        .addConverterFactory(
                                                                GsonConverterFactory.create() )
                                                        .addCallAdapterFactory(
                                                                RxJavaCallAdapterFactory.create() )
                                                        .build();
            apiService = RXretrofit.create( ApiService.class );
            apiService.getRXIpInfo( "63.223.108.42" )
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
    }
}
