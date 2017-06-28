package com.example.shobojit.networkingpractise;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private RequestQueue req;
    TextView txt;
    String url = "http://www.mocky.io/v2/58640b90100000730ab489dc";


    private JsonObjectRequest jsre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt= (TextView) findViewById(R.id.txt);
    }
    public void VolleyHit (View v){
        req = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsr =  response.getJSONArray("cse");
                        for (int i = 0 ; i<jsr.length();i++){
                          JSONObject jso = jsr.getJSONObject(i);
                            String name = jso.getString("name");
                            txt.append(name + " \n");
                        }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
        req.add(jsonObjectRequest);

    }
}