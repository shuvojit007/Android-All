package com.shuvojitkar.alarmmanager_implementation.Calender;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.shuvojitkar.alarmmanager_implementation.R;

import java.util.Calendar;

public class Calender extends AppCompatActivity {
    TimePicker ct;
    Button btn;
    TextView tt;
    Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        ct = (TimePicker) findViewById(R.id.ctimer);
        btn = (Button) findViewById(R.id.btn);
        tt = (TextView) findViewById(R.id.tt);
        c =Calendar.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= 23) {
                    c.set(Calendar.HOUR_OF_DAY, ct.getHour());
                    c.set(Calendar.HOUR,12);
                    c.set(Calendar.MINUTE, ct.getMinute());
                    Log.i("Time","Date : "+c.getTime());
                    Log.i("Time","Time in Millis :"+c.getTimeInMillis());
                    Log.i("Time","TimeZone : "+c.getTimeZone());

                }else {
                    c.set(Calendar.HOUR_OF_DAY, ct.getCurrentHour());
                    c.set(Calendar.MINUTE, ct.getCurrentMinute());
                    Log.i("Time ","Date : "+c.getTime());
                   Log.i("Time","Time in Millis :"+c.getTimeInMillis());
                   Log.i("Time","TimeZone : "+c.getTimeZone());

                }
            }
        });
    }
}
