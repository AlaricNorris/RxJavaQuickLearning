/**
 *  HomeActi
 *  com.alaric.norris.study.mvvm_mvp
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/6/6         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.mvvm_mvp.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alaric.norris.study.mvvm_mvp.R;
import com.alaric.norris.study.mvvm_mvp.databinding.ActivityHomeBinding;
import com.alaric.norris.study.mvvm_mvp.viewmodel.MainViewModel;
/**
 @formatter:off ClassName:      HomeActi
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/6/6    15:17
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        ActivityHomeBinding binding =
                DataBindingUtil.setContentView( this, R.layout.activity_home );
        binding.setViewModel( new MainViewModel( binding ) );
    }
}