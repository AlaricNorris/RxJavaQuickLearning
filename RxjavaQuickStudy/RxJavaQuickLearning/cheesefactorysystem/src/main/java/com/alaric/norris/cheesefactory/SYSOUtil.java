/**
 *  SYSOUtil
 *  com.alaric.norris.cheesefactory
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/5/27         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.cheesefactory;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 @formatter:off ClassName:      SYSOUtil
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/5/27    15:54
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class SYSOUtil {
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT =
            new SimpleDateFormat( "HH:mm:ss.SSS" );

    public static void println ( String inString ) {
        SIMPLE_DATE_FORMAT.format( new Date() );
        System.out.println( "[" + SIMPLE_DATE_FORMAT.format( new Date() ) + "]\t" + inString );
    }
}
