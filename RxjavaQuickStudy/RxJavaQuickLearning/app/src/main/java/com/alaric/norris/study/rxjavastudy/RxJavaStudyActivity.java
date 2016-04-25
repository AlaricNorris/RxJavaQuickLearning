/**
 *  RxJavaStudyActivity
 *  com.alaric.norris.study.rxjavastudy
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/4/25         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.rxjavastudy;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.alaric.norris.study.rxjava.R;

import java.util.ArrayList;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
/**
 @formatter:off ClassName:      RxJavaStudyActivity
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/4/25    16:23
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class RxJavaStudyActivity extends AppCompatActivity {
    public ImageView imageView = null;
    private String tag = "nrs";
    @Override
    protected void onCreate ( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        Observer< String > observer = new Observer< String >() {

            @Override
            public void onNext ( String s ) {
                Log.d( tag, "observer: " + s );
            }

            @Override
            public void onCompleted () {
                Log.d( tag, "Completed!" );
            }

            @Override
            public void onError ( Throwable e ) {
                Log.d( tag, "Error!" );
            }
        };

        Observable.just( 1, 2, 3, 4 ).subscribeOn( Schedulers.io() ) // 指定 subscribe() 发生在 IO 线程
                  .observeOn( AndroidSchedulers.mainThread() ) // 指定 Subscriber 的回调发生在主线程
                  .subscribe( new Action1< Integer >() {

                      @Override
                      public void call ( Integer number ) {
                          Log.i( tag, "number:" + number );
                      }
                  } );
        Subscriber< String > subscriber = new Subscriber< String >() {

            @Override
            public void onNext ( String s ) {
                Log.d( tag, "subscriber: " + s );
            }

            @Override
            public void onCompleted () {
                Log.d( tag, "Completed!" );
            }

            @Override
            public void onError ( Throwable e ) {
                Log.d( tag, "Error!" );
            }
        };

        Observable observable = Observable.create( new Observable.OnSubscribe< String >() {

            @Override
            public void call ( Subscriber< ? super String > subscriber ) {
                subscriber.onNext( "Hello" );
                subscriber.onNext( "Hi" );
                subscriber.onNext( "Aloha" );
                subscriber.onCompleted();
            }
        } );

        observable.subscribe( observer );
        // 或者：
        observable.subscribe( subscriber );

        Action1< String > onNextAction = new Action1< String >() {

            // onNext()
            @Override
            public void call ( String s ) {
                Log.d( tag, s );
            }
        };
        Action1< Throwable > onErrorAction = new Action1< Throwable >() {

            // onError()
            @Override
            public void call ( Throwable throwable ) {
                // Error handling
            }
        };
        Action0 onCompletedAction = new Action0() {

            // onCompleted()
            @Override
            public void call () {
                Log.d( tag, "completed" );
            }
        };

        // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        observable.subscribe( onNextAction );
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        observable.subscribe( onNextAction, onErrorAction );
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        observable.subscribe( onNextAction, onErrorAction, onCompletedAction );

        String[] names = { "1" , "2" , "3" };
        Observable.from( names ).subscribe( new Action1< String >() {

            @Override
            public void call ( String name ) {
                Log.d( tag, name );
            }
        } );

        Observable.create( new Observable.OnSubscribe< Drawable >() {

            @TargetApi ( Build.VERSION_CODES.LOLLIPOP )
            @Override
            public void call ( Subscriber< ? super Drawable > subscriber ) {
                Drawable drawable =
                        getTheme().getDrawable( R.drawable.abc_ab_share_pack_mtrl_alpha );
                subscriber.onNext( drawable );
                subscriber.onCompleted();
            }
        } ).subscribe( new Observer< Drawable >() {

            @Override
            public void onNext ( Drawable drawable ) {
                imageView.setImageDrawable( drawable );
            }

            @Override
            public void onCompleted () {
            }

            @Override
            public void onError ( Throwable e ) {
                e.printStackTrace();
                Toast.makeText( getApplicationContext(), "Error!", Toast.LENGTH_SHORT ).show();
            }
        } );

        //************************
        ArrayList< Course > course1 = new ArrayList();
        course1.add( new Course( "English" ) );
        course1.add( new Course( "Math" ) );
        course1.add( new Course( "Computer" ) );
        course1.add( new Course( "Physics" ) );
        course1.add( new Course( "Chemical" ) );
        course1.add( new Course( "Biologic" ) );
        ArrayList< Course > course2 = new ArrayList();
        course2.add( new Course( "Gem" ) );
        course2.add( new Course( "Yoga" ) );
        course2.add( new Course( "Ride" ) );
        course2.add( new Course( "Drive" ) );
        course2.add( new Course( "Shoot" ) );
        course2.add( new Course( "Arrow" ) );
        ArrayList< Course > course3 = new ArrayList();
        course3.add( new Course( "Android" ) );
        course3.add( new Course( "iOS" ) );
        course3.add( new Course( "PHP" ) );
        course3.add( new Course( "JAVA" ) );
        course3.add( new Course( ".Net" ) );
        course3.add( new Course( "C#" ) );
        ArrayList< Course > course4 = new ArrayList();
        course4.add( new Course( "Vampire Diary" ) );
        course4.add( new Course( "Spartacus" ) );
        course4.add( new Course( "Game of Thrones" ) );
        course4.add( new Course( "The Big Bang Theory" ) );
        Student[] students = new Student[ 5 ];
        students[ 1 ] = new Student();
        students[ 1 ].setName( "Alaric" );
        students[ 1 ].setCourses( course1 );
        students[ 2 ] = new Student();
        students[ 2 ].setName( "Norris" );
        students[ 2 ].setCourses( course2 );
        students[ 3 ] = new Student();
        students[ 3 ].setName( "School" );
        students[ 3 ].setCourses( course3 );
        students[ 4 ] = new Student();
        students[ 4 ].setName( "Break" );
        students[ 4 ].setCourses( course4 );
        Action1< Course > studentSubscriber = new Action1< Course >() {

            @Override
            public void call ( Course inCourse ) {
                if ( inCourse != null )
                    Log.d( tag, inCourse.getName() );
            }
        };
        Observable.from( students ).flatMap( new Func1< Student, Observable< Course > >() {

            @Override
            public Observable< Course > call ( Student student ) {
                if ( student != null ) {
                    Log.d( tag, "student Name" + student.getName() );
                    return Observable.from( student.getCourses() );
                }
                else
                    return null;
            }
        } ).subscribe( studentSubscriber );
    }
}
