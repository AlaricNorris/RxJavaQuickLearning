package com.alaric.norris.study.mvp.mvp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alaric.norris.study.mvp.R;
import com.alaric.norris.study.mvp.mvp.bean.User;
import com.alaric.norris.study.mvp.mvp.presenter.UserLoginPresenter;
import com.alaric.norris.study.mvp.mvp.view.IUserLoginView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class UserLoginActivity extends ActionBarActivity implements IUserLoginView {
    @InjectView ( R.id.id_et_username )
    EditText mEtUsername;
    @InjectView ( R.id.id_et_password )
    EditText mEtPassword;
    @InjectView ( R.id.id_pb_loading )
    ProgressBar mPbLoading;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter( this );
    @OnClick ( R.id.id_btn_clear )
    public void onClickClear ( View v ) {
        mUserLoginPresenter.clear();
    }
    @OnClick ( R.id.id_btn_login )
    public void onClickLogin ( View v ) {
        mUserLoginPresenter.login();
    }
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_user_login );
        ButterKnife.inject( this );
    }

    @Override
    public String getUserName () {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword () {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName () {
        mEtUsername.setText( "" );
    }

    @Override
    public void clearPassword () {
        mEtPassword.setText( "" );
    }

    @Override
    public void showLoading () {
        mPbLoading.setVisibility( View.VISIBLE );
    }

    @Override
    public void hideLoading () {
        mPbLoading.setVisibility( View.GONE );
    }

    @Override
    public void toMainActivity ( User user ) {
        Toast.makeText(
                this, user.getUsername() + " login success , to MainActivity", Toast.LENGTH_SHORT )
             .show();
    }

    @Override
    public void showFailedError () {
        Toast.makeText( this, "login failed", Toast.LENGTH_SHORT ).show();
    }
}
