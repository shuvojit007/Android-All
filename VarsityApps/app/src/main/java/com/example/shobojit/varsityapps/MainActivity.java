package com.example.shobojit.varsityapps;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shobojit.varsityapps.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.tt1.setText("Shuvojit Kar");
        binding.tt2.setText("Shuvojit Kar");
        binding.tt3.setText("Shuvojit Kar");
        binding.tt4.setText("Shuvojit Kar");

    }
}
