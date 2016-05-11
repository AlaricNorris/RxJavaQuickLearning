/**
 *  IP
 *  com.alaric.norris.study.retrofit.old
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/5/5         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.retrofit.old;

/**
 @formatter:off ClassName:      IP
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/5/5    10:32
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class IP {

    private int code;
    private Data data;
    public IP ( int inCode, Data inData ) {
        code = inCode;
        data = inData;
    }
    @Override
    public String toString () {
        return "IP{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
    public int getCode () {

        return code;
    }
    public void setCode ( int inCode ) {
        code = inCode;
    }
    public Data getData () {
        return data;
    }
    public void setData ( Data inData ) {
        data = inData;
    }
}
