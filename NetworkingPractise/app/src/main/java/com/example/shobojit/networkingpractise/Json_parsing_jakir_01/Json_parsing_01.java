package com.example.shobojit.networkingpractise.Json_parsing_jakir_01;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.shobojit.networkingpractise.R;

public class Json_parsing_01 extends AppCompatActivity {
    Button jsnbtn;
    ProgressBar pgbar;
    String url = "http://jakir.me/files/breakfast_menu.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsing_01);
        jsnbtn = (Button) findViewById(R.id.jsnbtn);
        pgbar = (ProgressBar) findViewById(R.id.pgbar);
        pgbar.setVisibility(View.GONE);
        jsnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IsOnline()) {
                    pgbar.setVisibility(View.VISIBLE);
                    BackgroundTask backgroundTask = new BackgroundTask(Json_parsing_01.this);
                    backgroundTask.execute(url);
                }else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection ",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    public boolean IsOnline (){
        ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cn.getActiveNetworkInfo();
        if(info!=null && info.isConnectedOrConnecting()){
            return true;
        }
        else {
            return false;
        }
    }
}
