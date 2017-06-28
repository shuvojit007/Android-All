package com.example.shobojit.networkingpractise;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shobojit.networkingpractise.Json_parsing_jakir_01.Json_parsing_01;
import com.example.shobojit.networkingpractise.My_practise.MyPractise;
import com.example.shobojit.networkingpractise.TeacherDetail.TeacherData;
import com.example.shobojit.networkingpractise.Volley_tutorial_jakir_01.Volley_Tutorial_01;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Main2Activity.this,TeacherData.class));
                finish();
            }
        },3000);
    }
}
