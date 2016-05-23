package com.alaric.norris.study.retrofit.latest;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
public class AppClient {
    static Retrofit mRetrofit;

    public static Retrofit retrofit () {
        if ( mRetrofit == null ) {
            mRetrofit = new Retrofit.Builder().baseUrl( "http://www.weather.com.cn/" )
                                              .addConverterFactory( GsonConverterFactory.create() )
                                              .build();
        }
        return mRetrofit;
    }
    public static Retrofit retrofitRX () {
        return new Retrofit.Builder().baseUrl( "http://api.nuuneoi.com/base/" )
                                     .addConverterFactory( GsonConverterFactory.create() )
                                     .addCallAdapterFactory(
                                             RxJavaCallAdapterFactory.create() )
                                     .build();
    }

    public interface ApiStores {
        @GET ( "adat/sk/{cityId}.html" )
        Call< WeatherJson > getWeather ( @Path ( "cityId" ) String cityId );

        @GET ( "adat/sk/{cityId}.html" )
        Observable< WeatherJson > getWeatherRxjava ( @Path ( "cityId" ) String cityId );
    }
}