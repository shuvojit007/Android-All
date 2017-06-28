package com.shuvojitkar.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TimePicker time;
    Button btn;
    AlarmManager alarm;
    Calendar clndr;
    Context cin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = (TimePicker) findViewById(R.id.tp);
        btn = (Button) findViewById(R.id.btn);
        cin = this;
        clndr =Calendar.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    clndr.set(Calendar.HOUR_OF_DAY,time.getHour());
                    clndr.set(Calendar.MINUTE,time.getMinute());
                    clndr.set(Calendar.SECOND,0);
                }else {

                    clndr.set(Calendar.HOUR_OF_DAY,time.getCurrentHour());
                    clndr.set(Calendar.MINUTE,time.getCurrentMinute());
                    clndr.set(Calendar.SECOND,0);
                }

                    alarm = (AlarmManager) cin.getSystemService(Context.ALARM_SERVICE);
                    Intent in = new Intent(cin,WakeUpReciver.class);

                    //The second parameter is unique to this PendingIntent,
                    //if you want to make more alarms,
                    //make sure to change the 0 to another integer
                    PendingIntent alarmIntent = PendingIntent.getBroadcast(cin, 100, in, PendingIntent.FLAG_UPDATE_CURRENT);

               /*     clndr.set(Calendar.HOUR_OF_DAY,hour);
                    clndr.set(Calendar.MINUTE,minute);
                    clndr.set(Calendar.SECOND,0);*/
                   /* //Add a day if alarm is set for before current time, so the alarm is triggered the next day
                    if (clndr.before(Calendar.getInstance())) {
                        clndr.add(Calendar.DAY_OF_MONTH, 1);
                    }*/
                  //  alarm.set(AlarmManager.RTC_WAKEUP, clndr.getTimeInMillis(),alarmIntent);
                    alarm.setRepeating(AlarmManager.RTC_WAKEUP, clndr.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
                    Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
