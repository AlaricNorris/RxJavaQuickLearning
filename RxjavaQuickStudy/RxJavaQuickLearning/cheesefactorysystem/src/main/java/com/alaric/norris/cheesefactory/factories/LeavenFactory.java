/**
 *  LeavenFactory
 *  com.alaric.norris.cheesefactory.factories
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/5/26         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.cheesefactory.factories;

import com.alaric.norris.cheesefactory.SYSOUtil;
import com.alaric.norris.cheesefactory.biz.SuperMarket;
import com.alaric.norris.cheesefactory.biz.WareHouse;
import com.alaric.norris.cheesefactory.models.Cheese;
import com.alaric.norris.cheesefactory.models.Leaven;
import com.alaric.norris.cheesefactory.models.Milk;
/**
 @formatter:off ClassName:      LeavenFactory
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/5/26    11:20
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class LeavenFactory {

    public static int ProductionCount = 0;
    private static LeavenFactory ourInstance = new LeavenFactory();

    private LeavenFactory () {
    }
    public static LeavenFactory getInstance () {
        return ourInstance;
    }
    public synchronized Cheese produceCheese ( Milk[] twoMilk, Leaven oneLeaven ) {
        Cheese product = new Cheese();
        SYSOUtil.println(
                "[" + getClass().getSimpleName() + "]" + " Produced:\t" + product.toString() );
        WareHouse.getInstance().storeCheese( product );
        ProductionCount++;
        return product;
    }
    public static class ProduceThread implements Runnable {

        public static ProduceThread mInstance;
        CheeseFactory mCheeseFactory;
        private ProduceThread ( CheeseFactory inCheeseFactory ) {
            mCheeseFactory = inCheeseFactory;
        }
        public static ProduceThread newInstance ( CheeseFactory inCheeseFactory ) {
            if ( mInstance == null ) {
                mInstance = new ProduceThread( inCheeseFactory );
            }
            return mInstance;
        }
        @Override
        public void run () {
            while ( true ) {
                if ( CheeseFactory.ProductionCount >= SuperMarket.IMPORT_SUMMARY ) {
                    return;
                }
                mCheeseFactory.produceCheese( null, null );
            }
        }
    }
}
