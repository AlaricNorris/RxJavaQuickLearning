package com.alaric.norris.study.mvvmretrofit.retrofitservices;
import com.alaric.norris.study.mvvmretrofit.beans.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface MovieService {
    @GET ( "top250" )
    Call< Movie > getTopMovie ( @Query ( "start" ) int start, @Query ( "count" ) int count );

    @GET ( "top250" )
    Call< Movie > getTopMovie ();
}