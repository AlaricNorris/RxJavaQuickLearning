/**
 *  Milk
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
@formatter:off ClassName:      Milk
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
public class Milk implements Serializable {
    public static long serialNumber = 11011200000L;

    private long Serial = serialNumber;
    public Milk () {
        serialNumber++;
        this.Serial = serialNumber;
    }
    @Override
    public String toString () {
        return "{Milk(Serial:" + Serial + ")}";
    }
}
