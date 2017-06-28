package com.shuvojitkar.alarmmanager.Service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shuvojitkar.alarmmanager.MainActivity;
import com.shuvojitkar.alarmmanager.R;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void StartService(View v){
        Log.i("ServiceDemo", "Main Thread  id :"+Thread.currentThread().getId());
        startService(new Intent(ServiceActivity.this,Service_Practise.class));
    }
}
