package com.example.shobojit.somepractise;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkActivity extends AppCompatActivity {
    TextView tt ;
        private static String link= "http://www.mocky.io/v2/58c17182110000451263efd5";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        tt= (TextView) findViewById(R.id.tt);
    }

   public  void Asyn (View v){
        new AsyncTask<String,String,String>(){
            @Override
            protected String doInBackground(String... params) {
                String s = "";
                String k = null;
                try {
                    URL url = new URL(link);
                    HttpURLConnection htp = (HttpURLConnection) url.openConnection();
                    htp.setRequestMethod("GET");
                    htp.connect();
                    BufferedReader br = new BufferedReader(new InputStreamReader(htp.getInputStream()));
                    //s=br.readLine().toString();
                    StringBuffer buf = new StringBuffer();
                    while ((s= br.readLine())!=null ){
                        buf.append(s);
                    }
                    k = buf.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return k ;
            }

            @Override
            protected void onPostExecute(String s) {
                    tt.setText(s);
            }
        }.execute();
  /*AsyncTask as= new AsyncTask<Void, Void, Void>() {
       @Override
       protected Void doInBackground(Void... params) {
           return null;
       }

      @Override
      protected void onPreExecute() {
          super.onPreExecute();
      }

      @Override
      protected void onPostExecute(Void aVoid) {
          super.onPostExecute(aVoid);
      }
  };
   as.execute();*/
   }
}
