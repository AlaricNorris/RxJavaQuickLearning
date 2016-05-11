/**
 *  a
 *  com.alaric.norris.study.retrofit.old
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/5/5         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.retrofit.old;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;
/**
 @formatter:off ClassName:      a
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/5/5    10:40
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class IPUtils {
    //eg : http://ip.taobao.com/service/getIpInfo.php?ip=202.202.32.202

    static final String ENDPOINT = "http://ip.taobao.com/service";
    static RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint( ENDPOINT )
                                                              //是否Debug
                                                              .setLogLevel(
                                                                      RestAdapter.LogLevel.FULL )
                                                              .build();
    static public TaobaoIPService taobaoIPService = restAdapter.create( TaobaoIPService.class );

    public interface TaobaoIPService {
        @GET ( "/getIpInfo.php" )
        IP getIp ( @Query ( "ip" ) String ip );

        @GET ( "/getIpInfo.php" )
        void getIp ( @Query ( "ip" ) String ip, Callback< IP > callback );
    }
}
