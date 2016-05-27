package com.alaric.norris.cheesefactory.factories;
import com.alaric.norris.cheesefactory.SYSOUtil;
import com.alaric.norris.cheesefactory.biz.SuperMarket;
import com.alaric.norris.cheesefactory.biz.WareHouse;
import com.alaric.norris.cheesefactory.models.Cheese;
import com.alaric.norris.cheesefactory.models.Leaven;
import com.alaric.norris.cheesefactory.models.Milk;
/**
 *  CheeseFactory
 *  com.alaric.norris.cheesefactory.factories
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/5/26         365
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
public class CheeseFactory {
    public static int ProductionCount = 0;
    private static CheeseFactory ourInstance = new CheeseFactory();

    private CheeseFactory () {
    }
    public static CheeseFactory getInstance () {
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
                if ( CheeseFactory.ProductionCount >= SuperMarket.IMPORT_SUMMARY )
                    break;
                mCheeseFactory.produceCheese( null, null );
            }
        }
    }
}
