package com.example.shobojit.onesignaldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String value=getIntent().getExtras().getString("info");
        TextView tt1 = (TextView) findViewById(R.id.tt1);
        tt1.setText(value);
    }
}
