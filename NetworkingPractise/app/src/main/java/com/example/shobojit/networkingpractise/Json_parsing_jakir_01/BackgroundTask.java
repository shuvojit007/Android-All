package com.example.shobojit.networkingpractise.Json_parsing_jakir_01;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shobojit.networkingpractise.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by SHOBOJIT on 12/29/2016.
 */

public class BackgroundTask extends AsyncTask<String,String,String> {
    Activity MainActivity;
    ProgressBar progressBar;
    List<Food>foodres;
    TextView result;
    public BackgroundTask(Activity activity) {
        MainActivity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        String data  = getData(params[0]);
        return data;
    }



    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressBar = (ProgressBar) MainActivity.findViewById(R.id.pgbar);
        progressBar.setVisibility(View.GONE);
        result = (TextView) MainActivity.findViewById(R.id.jstxt);
        foodres = Processing.System(s);
        if (foodres!=null){
            for (Food fooditem : foodres){
                result.append(fooditem.getName()+" " );
                result.append(fooditem.getPrice()+" \n");
                result.append(fooditem.getDescription()+" \n \n \n");
            }
        }

    }

    public String getData (String url){
        BufferedReader br;
        try {
            URL link =new URL(url);
            HttpURLConnection htp = (HttpURLConnection) link.openConnection();
            StringBuilder sb  = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(htp.getInputStream()));
            String res ;
            Log.i("Debug01 ",br+ " \n");
            while((res = br.readLine())!=null){
                sb.append(res +"\n");
                Log.i("Debug02 ",res+ " \n");
            }
            Log.i("Debug 03 ", sb.toString()+ " \n");
            return  sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }

    }
}
