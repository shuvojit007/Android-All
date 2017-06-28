package com.example.shobojit.networkingpractise.Volley_tutorial_jakir_01;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shobojit.networkingpractise.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Volley_Tutorial_01 extends AppCompatActivity {
    private RequestQueue req;
    ListView lv;
    private StringRequest sreq;
    private String url = "http://jakir.me/files/user.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley__tutorial_01);
        lv = (ListView) findViewById(R.id.lv);
    }
   public  void VolleyTutorial (View v){
        sreq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

             Log.i("Response " , response);
                    ShowJson (response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Volley_Tutorial_01.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
       req = Volley.newRequestQueue(this);
       req.add(sreq);

    }
    void ShowJson(String json){
        new Model(json).ParseJson();
       lv.setAdapter(new CustomList(Volley_Tutorial_01.this,Model.id,Model.name,Model.email));
    }
}





class Model {
    public  static  String [] id;
    public static  String [] name;
    public static  String [] email;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    private String json ;


    public Model(String json) {
    this.json =json;
    }
    void ParseJson (){
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray jsr = obj.getJSONArray(JSON_ARRAY);
            id =new String[jsr.length()];
            name =new String[jsr.length()];
            email =new String[jsr.length()];
            for (int i = 0 ;i<jsr.length();i++){
                JSONObject obj2 = jsr.getJSONObject(i);
                id [i]=obj2.getString(KEY_ID);
                name [i] = obj2.getString(KEY_NAME);
                email [i] = obj2.getString(KEY_EMAIL);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}

class CustomList extends ArrayAdapter{
    String [] names ;
    String [] ids ;
    String [] emails;
    Activity context;
    LayoutInflater inflater;

    public CustomList(Activity context, String [] id , String []  name , String [] email) {
        super(context, R.layout.list_view_sample,id);
        this.context=context;
        this.ids = id;
        this.names= name;
        this.emails = email;
        inflater =context.getLayoutInflater();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(R.layout.list_view_sample,parent,false);
        }
        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView email = (TextView) convertView.findViewById(R.id.email);

        id.setText(ids[position]);
        name.setText(names[position]);
        email.setText(emails[position]);

        return convertView;
    }
}