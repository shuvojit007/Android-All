package com.shuvojitkar.alarmmanager_implementation.Alarm02;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shuvojitkar.alarmmanager_implementation.AlarmReciver;
import com.shuvojitkar.alarmmanager_implementation.R;

import java.util.Calendar;

public class Alarm02 extends AppCompatActivity {
    AlarmManager am ;
    PendingIntent pendingIntent;
    Intent in;
    Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm02);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c= Calendar.getInstance();
                c.setTimeInMillis(System.currentTimeMillis());
                in = new Intent(getApplicationContext(), AlarmReciver.class);
                pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,in,0);
                if(Build.VERSION.SDK_INT <Build.VERSION_CODES.LOLLIPOP){
                    if (Build.VERSION.SDK_INT <Build.VERSION_CODES.KITKAT){
                        am.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis()+5000,pendingIntent);
                    }else {
                        am.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis()+5000,pendingIntent);
                    }
                }else{

                }
            }
        });

        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
