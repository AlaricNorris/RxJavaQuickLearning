/**
 *  SuperMarket
 *  com.alaric.norris.cheesefactory
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/5/26         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.cheesefactory.biz;

import com.alaric.norris.cheesefactory.Constants;
import com.alaric.norris.cheesefactory.SYSOUtil;
import com.alaric.norris.cheesefactory.models.Cheese;

import java.util.ArrayList;
/**
 @formatter:off ClassName:      SuperMarket
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/5/26    11:14
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class SuperMarket {
    public static final int IMPORT_SUMMARY = Constants.SUPERMARKET_VOLUMN;
    public static boolean isMarketFull = false;
    private static SuperMarket ourInstance = new SuperMarket();
    private ArrayList< Cheese > cheeseList = new ArrayList< Cheese >();

    private SuperMarket () {
    }
    public static SuperMarket getInstance () {
        return ourInstance;
    }

    /**
     * 进货
     * @param inTransportCar
     */
    public synchronized boolean importCheese ( TransportCar inTransportCar ) {

        while ( cheeseList.size() >= IMPORT_SUMMARY ) {
            synchronized ( SuperMarket.class ) {
                isMarketFull = true;
            }
            return false;
        }
        ArrayList< Cheese > unloadingCheese = inTransportCar.getTransportingCheese();
        this.cheeseList.addAll( unloadingCheese );
        SYSOUtil.println(
                "{" + getClass().getSimpleName() + "}" + "\tImported: " + unloadingCheese.size() +
                        " Cheese" );
        SYSOUtil.println(
                "{" + getClass().getSimpleName() + "}" + "\tCurrent Storage: " + cheeseList.size() );
        inTransportCar.unloading( this );
        synchronized ( SuperMarket.class ) {
            if ( cheeseList.size() >= IMPORT_SUMMARY ) {
                isMarketFull = true;
                SYSOUtil.println( "{SuperMarket} Total: \n" + cheeseList.toString() );
            }
            else {
                isMarketFull = false;
            }
        }
        return true;
    }
}
