package com.example.shobojit.networkingpractise.TeacherDetail;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.shobojit.networkingpractise.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Teacher_detail extends AppCompatActivity {
    RequestQueue treq;
    String Url = "http://www.mocky.io/v2/586a82cb1100004813261e8d";
    Detail detail;
    ListView tli;
    Context cn;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);
        tli = (ListView) findViewById(R.id.teacherlist);
        cn = this;
       preferences = getSharedPreferences("JsonData",cn.MODE_PRIVATE);

        if(haveNetworkConnection()){
            FetchJson();
        }else {
           String result = preferences.getString("result","null");
            if(!result.equals("null")){
                Gson gson = new Gson();
                detail = gson.fromJson(result.toString(),Detail.class);
                tli.setAdapter(new TList(cn,detail.getCse()));
            }else{
                Toast.makeText(cn,"No Data Found",Toast.LENGTH_SHORT).show();
            }


        }
    }

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

    public void FetchJson(){
        JsonObjectRequest jsr = new JsonObjectRequest(Request.Method.GET, Url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("Json Array",response.toString());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("result",response.toString());
                editor.commit();
                Gson gson = new Gson();
                detail = gson.fromJson(response.toString(),Detail.class);
                tli.setAdapter(new TList(cn,detail.getCse()));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error",error.getMessage());
            }
        });
        treq = Volley.newRequestQueue(this);
        treq.add(jsr);
    }


    class TList extends BaseAdapter{
        private Context cn;
        List<Detail.CseBean>cse;
        public TList(Context cn, List<Detail.CseBean> cse) {
            this.cn = cn;
            this.cse=cse;
        }

        @Override
        public int getCount() {
            return cse.size();
        }

        @Override
        public Object getItem(int position) {
            return cse.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) cn.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(convertView==null){
                convertView = inflater.inflate(R.layout.custom_teacher,parent,false);
            }
            TextView name = (TextView) convertView.findViewById(R.id.txtname);
            TextView designation = (TextView) convertView.findViewById(R.id.txtdesignation);
            TextView phone = (TextView) convertView.findViewById(R.id.txtphone);
            CircleImageView cr = (CircleImageView) convertView.findViewById(R.id.img);
            Detail.CseBean c = cse.get(position);
            Glide.with(cn).load(c.getImage()).placeholder(R.mipmap.ic_launcher).dontAnimate().into(cr);

            name.setText(c.getName());
            designation.setText(c.getDesignation());
            phone.setText(c.getMob());


            return convertView;
        }
    }
}
