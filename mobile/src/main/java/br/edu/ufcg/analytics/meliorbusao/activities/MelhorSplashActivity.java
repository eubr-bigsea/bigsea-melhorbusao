package br.edu.ufcg.analytics.meliorbusao.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;

import br.edu.ufcg.analytics.meliorbusao.MeliorBusaoApplication;
import br.edu.ufcg.analytics.meliorbusao.R;


public class MelhorSplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2500;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melior_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient = ((MeliorBusaoApplication) getApplication()).getGoogleApiClientInstance(this);
        mGoogleApiClient.connect();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent i = new Intent(MelhorSplashActivity.this,
                        getLaunchingActivity());
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    public Class getLaunchingActivity(){
        Class activityToLaunch = MelhorLoginActivity.class;
        if (mGoogleApiClient.isConnected()){
            OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
            if (opr.isDone()){
                GoogleSignInResult result = opr.get();
                if (result.getSignInAccount() != null){
                    activityToLaunch = MelhorBusaoActivity.class;
                }

            }
        }
        return activityToLaunch;
    }
}