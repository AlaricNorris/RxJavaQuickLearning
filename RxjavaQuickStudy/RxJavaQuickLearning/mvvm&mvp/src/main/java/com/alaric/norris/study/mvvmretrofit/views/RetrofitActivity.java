/**
 *  RetrofitActivity
 *  com.alaric.norris.study.mvvmretrofit.views
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/6/7         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.mvvmretrofit.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alaric.norris.study.mvvmretrofit.beans.Movie;
import com.alaric.norris.study.mvvmretrofit.retrofitservices.MovieService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 @formatter:off ClassName:      RetrofitActivity
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/6/7    16:52
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        Retrofit retrofit = new Retrofit.Builder().baseUrl( "https://api.douban.com/v2/movie/" )
                                                  .addConverterFactory(
                                                          GsonConverterFactory.create() )
                                                  .build();

        MovieService movieService = retrofit.create( MovieService.class );
        Call< Movie > topMovie = movieService.getTopMovie();
        excute( topMovie );
    }

    private void excute ( final Call< Movie > inTopMovie ) {
        new Thread() {

            @Override
            public void run () {
                Response< Movie > m;
                try {
                    m = inTopMovie.execute();
                    Log.i( "tag", "" + m.body().toString() );
                    m.message();
                }
                catch ( IOException inE ) {
                    inE.printStackTrace();
                }
            }
        }.start();
    }
}
