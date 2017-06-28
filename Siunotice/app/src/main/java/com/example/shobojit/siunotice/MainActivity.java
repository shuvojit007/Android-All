package com.example.shobojit.siunotice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView lv;
Button bt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lv);
        new siuDO().execute();
    }
    public class siuDO extends AsyncTask<Void,Void,Void>{
        List<String> aList= new ArrayList<String>();
        List <String> alink= new ArrayList<String>();
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect("http://siu.edu.bd/").get();
                Elements pngs = document.select(".bxslider li a .notice_text");
                Elements link = document.select(".bxslider li a  ");
                for(Element t : pngs){
                    aList.add(t.text());
                }
                for(Element t : link){
                    alink.add(t.attr("href"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayAdapter ar = new ArrayAdapter(getApplicationContext(),R.layout.listlayout,R.id.text,aList);
            lv.setAdapter(ar);
        }
    }
}
