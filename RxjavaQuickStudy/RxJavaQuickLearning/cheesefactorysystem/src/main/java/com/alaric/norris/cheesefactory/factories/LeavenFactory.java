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
import com.alaric.norris.cheesefactory.models.Leaven;
/**
 @formatter:off ClassName:      LeavenFactory
 @formatter:off Function:       发酵剂
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
    public synchronized Leaven produceLeaven () {
        Leaven product = new Leaven();
        SYSOUtil.println(
                "[" + getClass().getSimpleName() + "]" + " Produced:\t" + product.toString() );
        ProductionCount++;
        return product;
    }
    /**
     * 生产线程
     */
    public static class ProduceThread implements Runnable {

        public static ProduceThread mInstance;
        LeavenFactory mCheeseFactory;
        private ProduceThread ( LeavenFactory inCheeseFactory ) {
            mCheeseFactory = inCheeseFactory;
        }
        public static ProduceThread newInstance ( LeavenFactory inCheeseFactory ) {
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
                mCheeseFactory.produceLeaven();
            }
        }
    }
}
