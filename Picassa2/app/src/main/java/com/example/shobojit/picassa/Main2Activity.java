package com.example.shobojit.picassa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12,iv13,iv14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2= (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);
        iv5 = (ImageView) findViewById(R.id.iv5);
        iv6 = (ImageView) findViewById(R.id.iv6);
        iv7= (ImageView) findViewById(R.id.iv7);
        iv8 = (ImageView) findViewById(R.id.iv8);
        iv9 = (ImageView) findViewById(R.id.iv9);
        iv10 = (ImageView) findViewById(R.id.iv10);
        iv11 = (ImageView) findViewById(R.id.iv11);
        iv12= (ImageView) findViewById(R.id.iv12);
        iv13 = (ImageView) findViewById(R.id.iv13);
        iv14 = (ImageView) findViewById(R.id.iv14);

        Picasso.with(getApplicationContext()).load(R.drawable.s2).into(iv1);
        Picasso.with(getApplicationContext()).load(R.drawable.s3).into(iv2);
        Picasso.with(getApplicationContext()).load(R.drawable.s4).into(iv3);
        Picasso.with(getApplicationContext()).load(R.drawable.s5).into(iv4);
        Picasso.with(getApplicationContext()).load(R.drawable.s6).into(iv5);
        Picasso.with(getApplicationContext()).load(R.drawable.n1).into(iv6);
        Picasso.with(getApplicationContext()).load(R.drawable.n2).into(iv7);
        Picasso.with(getApplicationContext()).load(R.drawable.n3).into(iv8);
        Picasso.with(getApplicationContext()).load(R.drawable.n4).into(iv9);
        Picasso.with(getApplicationContext()).load(R.drawable.n5).into(iv10);
        Picasso.with(getApplicationContext()).load(R.drawable.n6).into(iv11);
        Picasso.with(getApplicationContext()).load(R.drawable.n7).into(iv12);
        Picasso.with(getApplicationContext()).load(R.drawable.n8).into(iv13);
        Picasso.with(getApplicationContext()).load(R.drawable.n9).into(iv14);

    }
}
