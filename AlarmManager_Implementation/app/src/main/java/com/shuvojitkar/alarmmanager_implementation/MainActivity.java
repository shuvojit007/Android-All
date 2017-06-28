package com.shuvojitkar.alarmmanager_implementation;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.CalendarContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    AlarmManager alarm;
    TimePicker timer;
    PendingIntent pin;
    TextView alarmSetTextView;
    Spinner spinner;
    Context cin;
    Calendar calendar;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cin = this;
        init();
    }

    void init(){
        alarmSetTextView = (TextView) findViewById(R.id.alarmText);
        timer =(TimePicker) findViewById(R.id.tp);
        calendar = Calendar.getInstance();

        // Get the alarm manager service
        alarm= (AlarmManager) getSystemService(ALARM_SERVICE);

        //spinner creation
        spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dawkins_sounds, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        in = new Intent(this,AlarmReciver.class);

    }

    public void startTimer(View v){
        final int hour;
        final int minute;
        calendar.setTimeInMillis(System.currentTimeMillis());
        if(Build.VERSION.SDK_INT >= 23) {
            calendar.set(Calendar.HOUR_OF_DAY, timer.getHour());
            calendar.set(Calendar.MINUTE, timer.getMinute());
            hour = timer.getHour();
            minute = timer.getMinute();;
        }else {
            calendar.set(Calendar.HOUR_OF_DAY, timer.getCurrentHour());
            calendar.set(Calendar.MINUTE, timer.getCurrentMinute());
            hour = timer.getCurrentHour();
            minute = timer.getCurrentMinute();
        }
        String minute_string = String.valueOf(minute);
        String hour_string = String.valueOf(hour);

        if (minute < 10) {
            minute_string = "0" + String.valueOf(minute);
        }

        if (hour > 12) {
            hour_string = String.valueOf(hour - 12) ;
        }
        alarmSetTextView.setText("Alarm set to " + hour_string + ":" + minute_string);
        pin = PendingIntent.getBroadcast(MainActivity.this, 120, in, PendingIntent.FLAG_UPDATE_CURRENT);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pin);

    }


    public void cancelTimer(View v){
        alarm.cancel(pin);
        alarmSetTextView.setText("Alarm canceled");
    }
}
