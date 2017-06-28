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

public class Mon extends AppCompatActivity {
    ListView mnlist;
    Context cn;
    JsonFormat jsonFormat2;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon);
        cn = this;
        mnlist = (ListView) findViewById(R.id.mnlist);
        preferences = getSharedPreferences("JsonData",this.MODE_PRIVATE);
        Gson gson = new Gson();

        String res = preferences.getString("js","null");
        Log.i("Sh",res);
        if(!res.equals("null")) {
            Log.e("Sh",res);
            jsonFormat2 = gson.fromJson(res, JsonFormat.class);
            mnlist.setAdapter(new MRoutine(cn, jsonFormat2.getCse11().getMON()));
        }
    }
}


class MRoutine extends BaseAdapter {
    List<JsonFormat.Cse11Bean.MONBean> mon;

    Context cn;
    public MRoutine(Context cn, List<JsonFormat.Cse11Bean.MONBean> mon) {
        this.cn =cn;
        this.mon=mon;


    }

    @Override
    public int getCount() {
        return mon.size();
    }

    @Override
    public Object getItem(int position) {
        return mon.get(position);
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
        JsonFormat.Cse11Bean.MONBean mn =  mon.get(position);
        tname.setText(mn.getName());
        Log.e("name",mn.getName());
        troom.setText(mn.getRoom());
        tename.setText(mn.getTname());
        ts.setText(mn.getStart());



        return convertView;
    }
}
