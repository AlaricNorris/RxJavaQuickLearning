/**
 *  WareHouse
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
import java.util.List;
/**
 @formatter:off ClassName:      WareHouse
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
public class WareHouse {
    public static final int MAX_VOLUMN = Constants.WAREHOUSE_VOLUMN;

    public static WareHouse instance = new WareHouse();
    public static boolean isWareHouseFull = false;
    private ArrayList< Cheese > storedCheese = new ArrayList< Cheese >();
    public static WareHouse getInstance () {
        return instance;
    }
    /**
     * 奶酪入库
     * @param inCheese
     */
    public synchronized void storeCheese ( Cheese inCheese ) {
        while ( storedCheese.size() >= MAX_VOLUMN ) {
            SYSOUtil.println( "\t#" + getClass().getSimpleName() + "#\t" +
                                      "!!!!!!!!\t\tWareHouse is full, waiting!\t\t!!!!!!!" );
            isWareHouseFull = true;
            try {
                wait();
            }
            catch ( InterruptedException inE ) {
                inE.printStackTrace();
            }
        }
        storedCheese.add( inCheese );// 储存奶酪
        SYSOUtil.println( "\t#" + getClass().getSimpleName() + "#\t" + "Stored:" +
                                  inCheese.toString() +
                                  "|\tCurrent Storage:\t" +
                                  storedCheese.size() );
        synchronized ( WareHouse.class ) {
            if ( storedCheese.size() >= MAX_VOLUMN ) {
                isWareHouseFull = true;
            }
            else
                isWareHouseFull = false;
        }
        notify();// 唤醒阻塞队列的某线程到就绪队列
    }

    /**
     *  奶酪出库
     * @param inTransportCar
     * @return
     */
    public synchronized ArrayList< Cheese > popupCheese ( TransportCar inTransportCar ) {

        while ( storedCheese.size() < TransportCar.CAR_VOLUMN ) {
            try {
                wait();
            }
            catch ( InterruptedException inE ) {
                inE.printStackTrace();
            }
        }
        ArrayList< Cheese > popup = new ArrayList< Cheese >();
        List< Cheese > sub = storedCheese.subList( 0, TransportCar.CAR_VOLUMN );
        popup.addAll( sub );
        storedCheese.removeAll( sub );
        SYSOUtil.println( "\t#" + getClass().getSimpleName() + "#\t" + "Popup:" + popup.size() +
                                  "Cheese|\t\tCurrent Storage:\t" +
                                  storedCheese.size() );
        synchronized ( WareHouse.class ) {
            isWareHouseFull = false;
        }
        notify();// 唤醒阻塞队列的某线程到就绪队列
        return popup;
    }
}
