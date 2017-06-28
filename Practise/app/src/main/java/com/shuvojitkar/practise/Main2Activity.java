package com.shuvojitkar.practise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tt1,tt2,tt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tt1 = (TextView) findViewById(R.id.tt1);
        tt2 = (TextView) findViewById(R.id.tt2);
        tt3 = (TextView) findViewById(R.id.tt3);
        Adapter a = getIntent().getParcelableExtra("Data");
        tt1.setText(a.getName());
        tt2.setText(a.getPhn());
        tt3.setText(a.getAddr());
    }
}
