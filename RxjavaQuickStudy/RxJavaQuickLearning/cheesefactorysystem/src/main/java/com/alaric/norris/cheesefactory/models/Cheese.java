/**
 *  Cheese
 *  com.alaric.norris.cheesefactory.models
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/5/26         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.cheesefactory.models;

import java.io.Serializable;
/**
 @formatter:off ClassName:      Cheese
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/5/26    11:04
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class Cheese implements Serializable {
    public static long serialNumber = 13854900000L;

    private long Serial = serialNumber;
    public Cheese () {
        serialNumber++;
        this.Serial = serialNumber;
    }
    @Override
    public String toString () {
        return "{Cheese(Serial:" + Serial + ")}";
    }
}
