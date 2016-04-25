/**
 *  a
 *  com.alaric.norris.study.rxjava.retrofitstudy
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/4/25         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.retrofitstudy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
/**
 @formatter:off ClassName:      a
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/4/25    13:50
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public interface GitHubService {
    @GET ( "users/{user}/repos" )
    Call< List< Repo > > listRepos ( @Path ( "user" ) String user );
}