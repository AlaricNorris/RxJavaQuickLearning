package com.alaric.norris.study.retrofit.latest;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Call<T> get();必须是这种形式,这是2.0之后的新形式
 * 如果不需要转换成Json数据,可以用了ResponseBody;
 * 你也可以使用Call<GsonBean> get();这样的话,需要添加Gson转换器
 */
public interface ApiStores {
    @GET ( "adat/sk/{cityId}.html" )
    Call< ResponseBody > getWeather ( @Path ( "cityId" ) String cityId );

    @POST ( "client/shipper/getCarType" )
    Call< ResponseBody > getCarType ( @Body ApiInfo apiInfo );

    @GET ( "http://ip.taobao.com/service/getIpInfo.php" )
    Call< ResponseBody > getWeatherr ( @Query ( "ip" ) String ip );
}