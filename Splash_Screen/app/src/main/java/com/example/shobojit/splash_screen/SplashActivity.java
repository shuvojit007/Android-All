package com.example.shobojit.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by SHOBOJIT on 6/2/2017.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Handler handler  = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start home activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                // close splash activity
                finish();
            }
        },3000);
    }
}

