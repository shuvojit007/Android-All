package com.example.shobojit.broadcastreciverpractise;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MyBroadCastReciver myBroadCastReciver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBroadCastReciver = new MyBroadCastReciver();
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Intent in = new Intent("android.provider.Telephony.SMS_RECEIVED");
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(myBroadCastReciver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadCastReciver);
    }
}
