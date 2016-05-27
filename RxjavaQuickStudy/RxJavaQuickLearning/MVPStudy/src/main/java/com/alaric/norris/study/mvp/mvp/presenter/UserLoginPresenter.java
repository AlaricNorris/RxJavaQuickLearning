package com.alaric.norris.study.mvp.mvp.presenter;

import android.os.Handler;

import com.alaric.norris.study.mvp.mvp.bean.User;
import com.alaric.norris.study.mvp.mvp.biz.IUserBiz;
import com.alaric.norris.study.mvp.mvp.biz.OnLoginListener;
import com.alaric.norris.study.mvp.mvp.biz.UserBiz;
import com.alaric.norris.study.mvp.mvp.view.IUserLoginView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by zhy on 15/6/19.
 */
public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter ( IUserLoginView userLoginView ) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login () {
        Observable< String > loginObservable =
                Observable.create( new Observable.OnSubscribe< String >() {

                    @Override
                    public void call ( Subscriber< ? super String > sub ) {
                        sub.onNext( "Hello, world!" );
                        sub.onCompleted();
                    }
                } );
        loginObservable.subscribeOn( Schedulers.io() )
                       .observeOn( AndroidSchedulers.mainThread() )
                       .subscribe( new Action1< String >() {

                           @Override
                           public void call ( String inS ) {

                           }
                       } );
        userLoginView.showLoading();
        userBiz.login(
                userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {

                    @Override
                    public void loginSuccess ( final User user ) {
                        //需要在UI线程执行
                        mHandler.post( new Runnable() {

                            @Override
                            public void run () {
                                userLoginView.toMainActivity( user );
                                userLoginView.hideLoading();
                            }
                        } );

                    }

                    @Override
                    public void loginFailed () {
                        //需要在UI线程执行
                        mHandler.post( new Runnable() {

                            @Override
                            public void run () {
                                userLoginView.showFailedError();
                                userLoginView.hideLoading();
                            }
                        } );

                    }
                } );
    }

    public void clear () {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

}
