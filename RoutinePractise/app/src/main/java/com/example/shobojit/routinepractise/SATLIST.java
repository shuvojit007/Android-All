package com.example.shobojit.routinepractise;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class SATLIST extends AppCompatActivity {
    ListView stlist;
    Context cn;
    JsonFormat jsonFormat;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satlist);
        cn = this;
        stlist = (ListView) findViewById(R.id.stlist);
        preferences = getSharedPreferences("JsonData",this.MODE_PRIVATE);
        Gson gson = new Gson();

        String res = preferences.getString("js","null");
        Log.i("Sh",res);
        if(!res.equals("null")) {
            Log.i("Sh",res);
            jsonFormat = gson.fromJson(res, JsonFormat.class);
            stlist.setAdapter(new Routine(cn, jsonFormat.getCse11().getSAT()));
        }
        }


}
class Routine extends BaseAdapter{
    List<JsonFormat.Cse11Bean.SATBean> sat;

    Context cn;
    public Routine(Context cn, List<JsonFormat.Cse11Bean.SATBean> sat) {
        this.cn =cn;
        this.sat=sat;


    }

    @Override
    public int getCount() {
        return sat.size();
    }

    @Override
    public Object getItem(int position) {
        return sat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) cn.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView==null){

            convertView = inflater.inflate(R.layout.customlsit,parent,false);
        }
        TextView tname = (TextView) convertView.findViewById(R.id.tname);
        TextView troom = (TextView) convertView.findViewById(R.id.troom);
        TextView ts = (TextView) convertView.findViewById(R.id.ts);
        TextView tename = (TextView) convertView.findViewById(R.id.tename);
        JsonFormat.Cse11Bean.SATBean st = sat.get(position);
        tname.setText(st.getName());
        Log.e("name",st.getName());
        troom.setText(st.getRoom());
        tename.setText(st.getTname());
        ts.setText(st.getStart());



        return convertView;
    }
}