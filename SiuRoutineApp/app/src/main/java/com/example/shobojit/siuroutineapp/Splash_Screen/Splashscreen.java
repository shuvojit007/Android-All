package com.example.shobojit.siuroutineapp.Splash_Screen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shobojit.siuroutineapp.MainActivity;
import com.example.shobojit.siuroutineapp.Model.Sharedpreference_model;
import com.example.shobojit.siuroutineapp.R;
import com.example.shobojit.siuroutineapp.Util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splashscreen extends AppCompatActivity {
    @BindView(R.id.splashimg)ImageView img;
    private FirebaseAnalytics mFirebaseAnalytics;

    Context cn;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splashscreen);
        preferences = getSharedPreferences("RoutineData",MODE_PRIVATE);
        cn = this;
        ButterKnife.bind(this);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Initialization();
        StartAlgo();
    }

    void Initialization(){
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.fadein);
        img.setAnimation(anim);

    }

    void StartAlgo(){

        if(CheckDpt()){
           // StartRoutineActivity();
            StartMainActivity();
        }else {
            StartMainActivity();
        }
    }

    void StartMainActivity(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splashscreen.this,MainActivity.class));
                finish();
            }
        },1500);
    }

    void StartRoutineActivity(){

    }
    //Check the internet
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    boolean CheckDpt(){
    String result = preferences.getString("dpt","null");
        if (!result.equals("null")){
            new Sharedpreference_model().setDpt(result);
            return  true;
        }
        return false;
    }



/*    void getDataFromNet(){
        dptname = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dptname.clear();
                for (DataSnapshot i : dataSnapshot.getChildren()){
                    if(i!=null){
                        for (DataSnapshot user : i.getChildren()){
                            String value = user.getValue().toString();
                            dptname.add(value);
                        }
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }*/
}
