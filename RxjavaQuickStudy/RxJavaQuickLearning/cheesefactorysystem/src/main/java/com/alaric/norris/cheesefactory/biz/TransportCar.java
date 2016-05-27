/**
 *  TransportCar
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
 @formatter:off ClassName:      TransportCar
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/5/26    11:10
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class TransportCar {

    public static final int CAR_VOLUMN = Constants.VEHICLE_VOLUMN;

    private ArrayList< Cheese > cheeseList = new ArrayList< Cheese >();
    public ArrayList< Cheese > getTransportingCheese () {
        return cheeseList;
    }
    /**
     * 装货
     * @param inArrayList
     */
    public synchronized void reloading ( ArrayList< Cheese > inArrayList ) {
        SYSOUtil.println( "@@Vehicle@@" + "\t\tReloading..." );
        cheeseList.clear();
        cheeseList.addAll( inArrayList );
        SYSOUtil.println( "@@Vehicle@@" + "\t\tFull loaded!" );
    }

    /**
     * 卸货
     * @param inSuperMarket
     */
    public synchronized void unloading ( SuperMarket inSuperMarket ) {
        cheeseList.clear();
        SYSOUtil.println( "@@Vehicle@@" + "\t\tUnloaded..." );
    }

    /**
     * transportCheeseFromWareHouseToSuperMarket
     */
    public synchronized void transportCheese ( WareHouse inWareHouse, SuperMarket inSuperMarket ) {
        reloading( inWareHouse.popupCheese( this ) );
        try {
            // 模拟运输
            SYSOUtil.println( "@@Vehicle@@" + "|--\tTransporting towards SuperMarket..." );
            Thread.sleep( 100 );
        }
        catch ( InterruptedException inE ) {
            inE.printStackTrace();
        }
        if ( inSuperMarket.importCheese( this ) ) {
            cheeseList.clear();
        }
        else {
        }
        try {
            // 模拟运输
            SYSOUtil.println( "@@Vehicle@@" + "|--\tTransporting back towards WareHouse..." );
            Thread.sleep( 100 );
        }
        catch ( InterruptedException inE ) {
            inE.printStackTrace();
        }
    }

    /**
     * 运输线程
     */
    public static class TransportThread implements Runnable {
        public static TransportThread mInstance;
        private TransportCar mTransportCar;
        private WareHouse mWareHouse;
        private SuperMarket mSuperMarket;
        private TransportThread (
                TransportCar inTransportCar, WareHouse inWareHouse, SuperMarket inSuperMarket
        ) {
            mTransportCar = inTransportCar;
            mWareHouse = inWareHouse;
            mSuperMarket = inSuperMarket;
        }
        public static TransportThread newInstance (
                TransportCar inTransportCar, WareHouse inWareHouse, SuperMarket inSuperMarket
        ) {
            if ( mInstance == null )
                mInstance = new TransportThread( inTransportCar, inWareHouse, inSuperMarket );
            return mInstance;
        }
        @Override
        public void run () {
            while ( true ) {
                if ( SuperMarket.isMarketFull )
                    return;
                mTransportCar.transportCheese( mWareHouse, mSuperMarket );
            }
        }
    }

}
