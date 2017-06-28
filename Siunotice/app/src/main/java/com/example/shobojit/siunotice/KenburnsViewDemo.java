package com.example.shobojit.siunotice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class KenburnsViewDemo extends AppCompatActivity {
    ListView lv2;
    TextView ttday,ttdate,ttmonth,tttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kenburns_view_demo);
        lv2 = (ListView) findViewById(R.id.lv2);
        ttday= (TextView) findViewById(R.id.ttday);
        ttdate= (TextView) findViewById(R.id.ttdate);
        ttmonth= (TextView) findViewById(R.id.ttmonth);
//        tttime= (TextView) findViewById(R.id.tttime);
        String []day = {"Sunday","Monday","Tuesday","Wednesday","Wednesday","Friday","Saturday"};
        Calendar c = Calendar.getInstance();
        ttday.setText(day[c.getTime().getDay()]);
        SimpleDateFormat df = new SimpleDateFormat("dd");
        ttdate.setText(df.format(c.getTime()));
        SimpleDateFormat d2 = new SimpleDateFormat("MMMMMM");
        ttmonth.setText( d2.format(c.getTime()));
       // tttime.setText();
        new siu().execute();
    }

 class siu extends AsyncTask<Void, Void, Void> {
        List<String> aList2 = new ArrayList<String>();
        List<String> alink2 = new ArrayList<String>();

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect("http://siu.edu.bd/").get();
                Elements pngs = document.select(".bxslider li a .notice_text");
                Elements link = document.select(".bxslider li a  ");
                for (Element t : pngs) {
                    aList2.add(t.text());
                }
                for (Element t : link) {
                    alink2.add(t.attr("href"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayAdapter arr = new ArrayAdapter(getApplicationContext(),R.layout.listlayout,R.id.text,aList2);
            lv2.setAdapter(arr);
        }


    }
}
