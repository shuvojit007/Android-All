package com.example.shobojit.splash_screen;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img ;
    AnimationDrawable animD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);
        if(img==null) throw  new AssertionError();
        img.setBackgroundResource(R.drawable.animaion_loading);
        animD = (AnimationDrawable) img.getBackground();
        animD.start();
    }
}
