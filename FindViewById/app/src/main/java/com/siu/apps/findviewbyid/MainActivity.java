package com.siu.apps.findviewbyid;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloWorldBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.hell.setText("Hello World");
    }
}
