package com.example.shobojit.loading;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mancj.slideup.SlideUp;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private RequestQueue requestQueue;
    private StringRequest st ;
    TextView txt;
    private SlideUp slideUp;

    private View slideView;
    private FloatingActionButton fab;

    String url = "http://www.mocky.io/v2/585e53050f00000106ff7a39";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slideView = findViewById(R.id.slideView);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        slideUp = new SlideUp(slideView);
        slideUp.hideImmediately();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideUp.animateIn();
                fab.hide();
            }
        });

        slideUp.setSlideListener(new SlideUp.SlideListener() {

            @Override
            public void onSlideDown(float v) {

            }

            @Override
            public void onVisibilityChanged(int visibility) {
                if (visibility == View.GONE)
                {
                    fab.show();
                }
            }
        });




        txt = (TextView) findViewById(R.id.txt);
    }
    public void volleY(View v){
        requestQueue= Volley.newRequestQueue(this);
          st =  new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
               txt.setText(response.toString());
                 Log.i(TAG,"Response :"+ response.toString());
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
            txt.setText(error.toString());
                 Log.i(TAG,"Error :"+ error.toString());
             }
         });
        requestQueue.add(st);


    }

}

