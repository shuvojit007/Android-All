package com.example.shobojit.networkingpractise.My_practise;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.shobojit.networkingpractise.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MyPractise extends AppCompatActivity {
    private ListView lv;
    JsonData jsdata;
    Gson gson;
    String [] cse;
    Cache cache;
    Network network;
    private  Context cont ;
    String [] ece;
    private RequestQueue precReq;
   public JsonObjectRequest jsobj;
    String url = "http://www.mocky.io/v2/5865f78c120000bb01b7cbeb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_practise);
        cont=this;
        lv = (ListView) findViewById(R.id.praclv);
        cache = new DiskBasedCache(getCacheDir(),1024*1024);
        network = new BasicNetwork(new HurlStack());
        precReq =new RequestQueue(cache,network);
        precReq.start();
    }

    public void Mypractise (View v){
        jsobj = new JsonObjectRequest(Request.Method.GET, url,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("Json", String.valueOf(response));
                gson = new Gson();
                jsdata =gson.fromJson(response.toString(),JsonData.class);
                lv.setAdapter(new CustomList(cont,jsdata.getCse(),jsdata.getEse()));
                precReq.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             /*   VolleyLog.d("Error",error);*/
                Log.i("Error",error.toString());
            }
        });

       /* precReq = Volley.newRequestQueue(getApplicationContext());*/
        precReq.add(jsobj);

    }
    void UtilizeData(JSONObject js){
        try {
            JSONArray jsonArray = js.getJSONArray("cse");
            JSONArray jsonArray2 = js.getJSONArray("ese");
            cse = new String[jsonArray.length()];
            ece = new String[jsonArray2.length()];
           /* JSONObject jcse = jsonArray.getJSONObject("name");*/
            for (int i = 0;i<jsonArray.length();i++){
                JSONObject jcse = jsonArray.getJSONObject(i);
                cse [i] = jcse.getString("name");
                JSONObject jece = jsonArray2.getJSONObject(i);
                ece [i] = jece.getString("name");

            }
            Log.i("CSE ", jsonArray.toString());

            for (String s : ece){
                Log.i("Ece ", s+" \n");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    void GetJsonData(List<JsonData.CseBean> csename, List<JsonData.EseBean> ecename){
        JsonData.CseBean data = csename.get(2);
      for (JsonData.CseBean s : csename){
          Log.i("CSEList : ",data.getName()+" \n");
      }
    }

}
class CustomList extends BaseAdapter{
    private Context con;
    List<JsonData.CseBean> csename;
    List<JsonData.EseBean> ecename;
    public CustomList(Context context, List<JsonData.CseBean> csename, List<JsonData.EseBean> ecename) {
    con=context;
        this.csename =csename;
        this.ecename =ecename;
    }

    @Override
    public int getCount() {
        return csename.size();
    }

    @Override
    public Object getItem(int position) {
        return csename.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            convertView = inflater.inflate(R.layout.customlist,parent,false);
        }
        TextView tt1 = (TextView) convertView.findViewById(R.id.tt1);
        TextView tt2 = (TextView) convertView.findViewById(R.id.tt2);
        JsonData.CseBean csedata = csename.get(position);
        JsonData.EseBean esedata = ecename.get(position);


        tt1.setText(csedata.getName());
        tt2.setText(esedata.getName());
        return convertView;
    }
}
