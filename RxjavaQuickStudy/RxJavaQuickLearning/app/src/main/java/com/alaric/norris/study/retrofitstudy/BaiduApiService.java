/**
 *  BaiduApiService
 *  com.alaric.norris.study.retrofitstudy
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/4/26         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.retrofitstudy;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
/**
 @formatter:off ClassName:      BaiduApiService
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/4/26    17:03
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public interface BaiduApiService {
    //http://baidu.com/s?wd=1
    @GET ( "/s" )
    Call< Object > onekey ( @Query ( "wd" ) String wdvalue );

    @GET ( "/s" )
    Call< Object > manykey ( @QueryMap Map< String, String > options );

}
