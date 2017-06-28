package com.example.shobojit.alarmmanager_practise;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Context cn ;
    TimePicker timePicker;
    Calendar c;
    int hour;
    int min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cn = this;
        timePicker = (TimePicker) findViewById(R.id.timepicker);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                c.setTimeInMillis(System.currentTimeMillis());
                hour = c.get(Calendar.HOUR_OF_DAY);
                min = c.get(Calendar.MINUTE);
                Log.i("Time","Hour And Min "+hour+" ,"+min);
                if(Build.VERSION.SDK_INT >= 23) {
                    hour = timePicker.getHour();
                    min = timePicker.getMinute();
                    SetTime(hour,min);
                }else {
                    hour = timePicker.getCurrentHour();
                    min = timePicker.getCurrentMinute();
                    SetTime02(hour,min);
                }

                checkAlarm(c);
                Intent in = new Intent(cn,Notification_Reciver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(cn,100,in,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
               // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),
                        pendingIntent);
                Toast.makeText(cn, "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void SetTime (int hr,int min){
        c.set(Calendar.HOUR_OF_DAY, hr);
        c.set(Calendar.MINUTE, min);
    }
    void SetTime02(int hr,int min){
        c.set(Calendar.HOUR_OF_DAY,hr);
        c.set(Calendar.MINUTE, min);
    }
    private void checkAlarm(Calendar alarm) {
        Calendar now = Calendar.getInstance();
        if (alarm.before(now)) {
            long alarmForFollowingDay = alarm.getTimeInMillis() + 86400000L;
            alarm.setTimeInMillis(alarmForFollowingDay);
        }
    }



}
