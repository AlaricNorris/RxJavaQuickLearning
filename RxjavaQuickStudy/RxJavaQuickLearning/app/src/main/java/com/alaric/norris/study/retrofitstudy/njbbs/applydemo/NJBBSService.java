/**
 *  NJBBSService
 *  com.alaric.norris.study.retrofitstudy
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/4/26         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.retrofitstudy.njbbs.applydemo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
/**
 @formatter:off ClassName:      NJBBSService
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/4/26    17:22
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public interface NJBBSService {
    //http://xqbmp.house365.com/api/?v=4.1.0&api_key=android&method=index.model_layout&deviceid=355848066910830&local_updatetime=1439452766&city=nj&belong_to=2
    //http://app.house365.com/ver.php
    public static final String NJBBS_URL = "http://xqbmp.house365.com";
    public static final String CFAPI_URL = "http://cfapi.house365.com";
    public static final String NJBBS_VERSION_URL = "http://app.house365.com";

    @GET ( "/ver.php" )
    Call< Object > checkVersion ( @Query ( "app" ) String appId );

    @GET ( "/cf/index.php" )
    Call< Object > sendAndroidDeviceInfo ( @QueryMap Map< String, String > params );

    @GET ( "/cf/index.php" )
    Call< Object > getUserInfoById ( @QueryMap Map< String, String > params );

    @GET ( "/cf/index.php" )
    Call< Object > getThreadInfoByID ( @QueryMap Map< String, String > params );

    @GET ( "/s" )
    Call< Object > manykey ( @QueryMap Map< String, String > options );
}
