/**
 *  CheeseSystem
 *  com.alaric.norris.cheesefactory
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/5/26         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.cheesefactory;

import com.alaric.norris.cheesefactory.biz.SuperMarket;
import com.alaric.norris.cheesefactory.biz.TransportCar;
import com.alaric.norris.cheesefactory.biz.WareHouse;
import com.alaric.norris.cheesefactory.factories.CheeseFactory;
/**
 @formatter:off ClassName:      CheeseSystem
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/5/26    14:27
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class CheeseSystem {
    public static void main ( String[] args ) {
        WareHouse wareHouse = WareHouse.getInstance();
        CheeseFactory cheeseFactory = CheeseFactory.getInstance();
        SuperMarket superMarket = SuperMarket.getInstance();
        TransportCar transportCar = new TransportCar();

        new Thread( CheeseFactory.ProduceThread.newInstance( cheeseFactory ) ).start();
        new Thread( TransportCar.TransportThread.newInstance( transportCar, wareHouse,
                                                              superMarket
        ) ).start();

    }
}
