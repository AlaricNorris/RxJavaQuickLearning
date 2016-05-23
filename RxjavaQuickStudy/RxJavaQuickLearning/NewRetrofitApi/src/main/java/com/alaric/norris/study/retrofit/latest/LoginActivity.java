package com.alaric.norris.study.retrofit.latest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks< Cursor > {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello" , "bar@example.com:world"
    };
    Retrofit mRetrofit;
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;
    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        Retrofit retrofit = new Retrofit.Builder()
                //这里建议：- Base URL: 总是以/结尾；- @Url: 不要以/开头
                .baseUrl( "http://www.weather.com.cn/" ).build();
        ApiStores apiStores = retrofit.create( ApiStores.class );
        final Call< ResponseBody > call = apiStores.getWeather( "101010100" );

        // TODO 同步调用
        {
            new Thread() {

                @Override
                public void run () {

                    try {
                        Response< ResponseBody > bodyResponse = call.execute();
                        String body = bodyResponse.body().string();//获取返回体的字符串
                        Log.i( "tag", "body=" + body );
                    }
                    catch ( Exception e ) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        // TODO 异步调用
        {
            Call< ResponseBody > call1 = apiStores.getWeatherr( "202.202.33.33" );
            call1.enqueue( new Callback< ResponseBody >() {

                @Override
                public void onResponse (
                        Call< ResponseBody > call, Response< ResponseBody > response
                ) {
                    try {
                        Log.i( "tag", "response=" + response.body().string() );
                    }
                    catch ( Exception e ) {
                        e.printStackTrace();
                    }

                }
                @Override
                public void onFailure ( Call< ResponseBody > call, Throwable t ) {

                    Log.i( "tag", "onFailure=" + t.getMessage() );
                }
            } );
        }
        getCarType();
        getWeather();
        getWeatherRxjava();

        setContentView( R.layout.activity_login );
        // Set up the login form.
        mEmailView = ( AutoCompleteTextView ) findViewById( R.id.email );
        populateAutoComplete();
        mPasswordView = ( EditText ) findViewById( R.id.password );
        mPasswordView.setOnEditorActionListener( new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction ( TextView textView, int id, KeyEvent keyEvent ) {
                if ( id == R.id.login || id == EditorInfo.IME_NULL ) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        } );

        Button mEmailSignInButton = ( Button ) findViewById( R.id.email_sign_in_button );
        mEmailSignInButton.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick ( View view ) {
                attemptLogin();
            }
        } );

        mLoginFormView = findViewById( R.id.login_form );
        mProgressView = findViewById( R.id.login_progress );
    }

    private void getWeatherRxjava () {
        AppClient.ApiStores apiStores = AppClient.retrofitRX().create( AppClient.ApiStores.class );
        Observable< WeatherJson > observable = apiStores.getWeatherRxjava( "101010100" );
        observable.subscribeOn( Schedulers.io() )
                  .observeOn( AndroidSchedulers.mainThread() )
                  .subscribe( new Subscriber< WeatherJson >() {

                      @Override
                      public void onCompleted () {
                          Log.i( "tag", "onCompleted" );
                      }

                      @Override
                      public void onError ( Throwable e ) {
                          Log.i( "tag", "e=" + e.getMessage() );
                      }

                      @Override
                      public void onNext ( WeatherJson weatherJson ) {
                          Log.i( "tag", "getWeatherinfo=" + weatherJson.getWeatherinfo() );
                      }
                  } );

    }
    private void getCarType () {
        mRetrofit = new Retrofit.Builder().baseUrl( "http://WuXiaolong.me/" )
                                          .addConverterFactory( GsonConverterFactory.create() )
                                          .build();
        ApiStores apiStores = mRetrofit.create( ApiStores.class );
        ApiInfo apiInfo = new ApiInfo();
        ApiInfo.ApiInfoBean apiInfoBean = apiInfo.new ApiInfoBean();
        apiInfoBean.setApiKey( "666" );
        apiInfoBean.setApiName( "WuXiaolong" );
        apiInfo.setApiInfo( apiInfoBean );
        Call< ResponseBody > call = apiStores.getCarType( apiInfo );
        call.enqueue( new Callback< ResponseBody >() {

            @Override
            public void onResponse (
                    Call< ResponseBody > call, Response< ResponseBody > response
            ) {
                String body = null;//获取返回体的字符串
                Log.i( "tag", "getCarType response" + response.code() );
                try {
                    body = response.body().string();
                }
                catch ( Exception e ) {
                    e.printStackTrace();
                }
                Log.i( "tag", "getCarType=" + body );
            }
            @Override
            public void onFailure ( Call< ResponseBody > call, Throwable t ) {

            }

        } );
    }
    private void getWeather () {
        AppClient.ApiStores apiStores = AppClient.retrofit().create( AppClient.ApiStores.class );
        Call< WeatherJson > call = apiStores.getWeather( "101010100" );
        call.enqueue( new Callback< WeatherJson >() {

            @Override
            public void onResponse (
                    Call< WeatherJson > call, Response< WeatherJson > response
            ) {
                Log.i( "tag", "getWeatherinfo=" + response.body().getWeatherinfo() );
            }
            @Override
            public void onFailure ( Call< WeatherJson > call, Throwable t ) {

            }
        } );
    }
    private void populateAutoComplete () {
        if ( ! mayRequestContacts() ) {
            return;
        }

        getLoaderManager().initLoader( 0, null, this );
    }

    private boolean mayRequestContacts () {
        if ( Build.VERSION.SDK_INT < Build.VERSION_CODES.M ) {
            return true;
        }
        if ( checkSelfPermission( READ_CONTACTS ) == PackageManager.PERMISSION_GRANTED ) {
            return true;
        }
        if ( shouldShowRequestPermissionRationale( READ_CONTACTS ) ) {
            Snackbar.make( mEmailView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE )
                    .setAction( android.R.string.ok, new View.OnClickListener() {

                        @Override
                        @TargetApi ( Build.VERSION_CODES.M )
                        public void onClick ( View v ) {
                            requestPermissions(
                                    new String[]{ READ_CONTACTS }, REQUEST_READ_CONTACTS );
                        }
                    } );
        }
        else {
            requestPermissions( new String[]{ READ_CONTACTS }, REQUEST_READ_CONTACTS );
        }
        return false;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult (
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults
    ) {
        if ( requestCode == REQUEST_READ_CONTACTS ) {
            if ( grantResults.length == 1 &&
                    grantResults[ 0 ] == PackageManager.PERMISSION_GRANTED ) {
                populateAutoComplete();
            }
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin () {
        if ( mAuthTask != null ) {
            return;
        }

        // Reset errors.
        mEmailView.setError( null );
        mPasswordView.setError( null );

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if ( ! TextUtils.isEmpty( password ) && ! isPasswordValid( password ) ) {
            mPasswordView.setError( getString( R.string.error_invalid_password ) );
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if ( TextUtils.isEmpty( email ) ) {
            mEmailView.setError( getString( R.string.error_field_required ) );
            focusView = mEmailView;
            cancel = true;
        }
        else if ( ! isEmailValid( email ) ) {
            mEmailView.setError( getString( R.string.error_invalid_email ) );
            focusView = mEmailView;
            cancel = true;
        }

        if ( cancel ) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
        else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress( true );
            mAuthTask = new UserLoginTask( email, password );
            mAuthTask.execute( ( Void ) null );
        }
    }
    private boolean isEmailValid ( String email ) {
        //TODO: Replace this with your own logic
        return email.contains( "@" );
    }

    private boolean isPasswordValid ( String password ) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi ( Build.VERSION_CODES.HONEYCOMB_MR2 )
    private void showProgress ( final boolean show ) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2 ) {
            int shortAnimTime = getResources().getInteger( android.R.integer.config_shortAnimTime );

            mLoginFormView.setVisibility( show ? View.GONE : View.VISIBLE );
            mLoginFormView.animate()
                          .setDuration( shortAnimTime )
                          .alpha( show ? 0 : 1 )
                          .setListener( new AnimatorListenerAdapter() {

                              @Override
                              public void onAnimationEnd ( Animator animation ) {
                                  mLoginFormView.setVisibility( show ? View.GONE : View.VISIBLE );
                              }
                          } );

            mProgressView.setVisibility( show ? View.VISIBLE : View.GONE );
            mProgressView.animate()
                         .setDuration( shortAnimTime )
                         .alpha( show ? 1 : 0 )
                         .setListener( new AnimatorListenerAdapter() {

                             @Override
                             public void onAnimationEnd ( Animator animation ) {
                                 mProgressView.setVisibility( show ? View.VISIBLE : View.GONE );
                             }
                         } );
        }
        else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility( show ? View.VISIBLE : View.GONE );
            mLoginFormView.setVisibility( show ? View.GONE : View.VISIBLE );
        }
    }

    @Override
    public Loader< Cursor > onCreateLoader ( int i, Bundle bundle ) {
        return new CursorLoader( this,
                                 // Retrieve data rows for the device user's 'profile' contact.
                                 Uri.withAppendedPath( ContactsContract.Profile.CONTENT_URI,
                                                       ContactsContract.Contacts.Data.CONTENT_DIRECTORY
                                 ), ProfileQuery.PROJECTION,

                                 // Select only email addresses.
                                 ContactsContract.Contacts.Data.MIMETYPE + " = ?", new String[]{
                ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE
        },

                                 // Show primary email addresses first. Note that there won't be
                                 // a primary email address if the user hasn't specified one.
                                 ContactsContract.Contacts.Data.IS_PRIMARY + " DESC"
        );
    }

    @Override
    public void onLoadFinished ( Loader< Cursor > cursorLoader, Cursor cursor ) {
        List< String > emails = new ArrayList<>();
        cursor.moveToFirst();
        while ( ! cursor.isAfterLast() ) {
            emails.add( cursor.getString( ProfileQuery.ADDRESS ) );
            cursor.moveToNext();
        }

        addEmailsToAutoComplete( emails );
    }

    @Override
    public void onLoaderReset ( Loader< Cursor > cursorLoader ) {

    }
    private void addEmailsToAutoComplete ( List< String > emailAddressCollection ) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter< String > adapter =
                new ArrayAdapter<>( LoginActivity.this, android.R.layout.simple_dropdown_item_1line,
                                    emailAddressCollection
                );

        mEmailView.setAdapter( adapter );
    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS ,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY ,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask< Void, Void, Boolean > {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask ( String email, String password ) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground ( Void... params ) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep( 2000 );
            }
            catch ( InterruptedException e ) {
                return false;
            }

            for ( String credential : DUMMY_CREDENTIALS ) {
                String[] pieces = credential.split( ":" );
                if ( pieces[ 0 ].equals( mEmail ) ) {
                    // Account exists, return true if the password matches.
                    return pieces[ 1 ].equals( mPassword );
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute ( final Boolean success ) {
            mAuthTask = null;
            showProgress( false );

            if ( success ) {
                finish();
            }
            else {
                mPasswordView.setError( getString( R.string.error_incorrect_password ) );
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled () {
            mAuthTask = null;
            showProgress( false );
        }
    }
}

