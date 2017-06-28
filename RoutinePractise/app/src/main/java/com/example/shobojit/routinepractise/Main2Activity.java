package com.example.shobojit.routinepractise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public  void SAT(View v){
        startActivity(new Intent(getApplicationContext(),SATLIST.class));
    }

    public  void SUN(View v){

    }

    public  void MON(View v){
        startActivity(new Intent(getApplicationContext(),Mon.class));
    }

    public  void TUE(View v){

    }

    public  void WED(View v){

    }

    public  void THU(View v){

    }
}
