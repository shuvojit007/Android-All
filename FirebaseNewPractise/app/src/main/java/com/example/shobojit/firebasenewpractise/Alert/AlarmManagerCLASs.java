package com.example.shobojit.firebasenewpractise.Alert;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import com.example.shobojit.firebasenewpractise.R;
import com.example.shobojit.firebasenewpractise.Utils.ALarmReciver;

import java.util.Calendar;

public class AlarmManagerCLASs extends AppCompatActivity {
    TimePicker timePicker;
    Intent in ;
    AlarmManager alarmManager;
    PendingIntent pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);
        timePicker = (TimePicker) findViewById(R.id.time);
    }

    public void StartAlarm(View view){
        Calendar calendar = Calendar.getInstance();
        if (Build.VERSION.SDK_INT >=23){
            calendar.set(Calendar.HOUR_OF_DAY,timePicker.getHour());
            calendar.set(Calendar.MINUTE,timePicker.getMinute());
        }else {
            calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
        }
        in = new Intent(this, ALarmReciver.class);
        pin = PendingIntent.getBroadcast(this,0,in,0);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),100*60,pin);
    }


    public void StopAlarm(View view){

    }

}
