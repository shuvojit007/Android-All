package com.example.shobojit.routinepractise;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue req;
    private JsonObjectRequest jsr;
    SharedPreferences preferences;

    JsonFormat jsonFormat;
    String url ="http://www.mocky.io/v2/586fd2ee110000f2093b055c";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("JsonData",this.MODE_PRIVATE);
        req = Volley.newRequestQueue(this);
    }

    public void Hit(View v){
        jsr = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String result = response.toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("js",result);
                editor.commit();
                Log.e("Msg",response.toString());
                //Gson gson = new Gson();
                //jsonFormat = gson.fromJson(response.toString(),JsonFormat.class);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        req.add(jsr);
        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
    }

}
