package com.example.shobojit.broadcastreciverpractise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by SHOBOJIT on 5/15/2017.
 */

public class MyBroadCastReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Shuvojit Kar", Toast.LENGTH_SHORT).show();

    }
}
