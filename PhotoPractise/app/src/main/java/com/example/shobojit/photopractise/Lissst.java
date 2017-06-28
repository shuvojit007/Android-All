package com.example.shobojit.photopractise;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Lissst extends AppCompatActivity {
    ListView lv;
    ArrayAdapter ar;
    String [] a = {"Shuvojit Kar Manna","Angkita Bhattacharjee Pritha","Jyoti Kapali","Tanushree Kapali",
            "Shuvojit Kar Manna","Angkita Bhattacharjee Pritha","Jyoti Kapali","Tanushree Kapali",
            "Shuvojit Kar Manna","Angkita Bhattacharjee Pritha","Jyoti Kapali","Tanushree Kapali",
            "Shuvojit Kar Manna","Angkita Bhattacharjee Pritha","Jyoti Kapali","Tanushree Kapali"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lv = (ListView) findViewById(R.id.list);
         ar = new ArrayAdapter(this,android.R.layout.simple_list_item_1,a);
        if(lv!=null){
            TextView tt = new TextView(this);
            tt.setText("ListView Header");
            lv.addHeaderView(tt);
            TextView ft = new TextView(this);
            ft.setText("ListView Footer");
            lv.addFooterView(ft);
            lv.setAdapter(ar);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.search,menu);
        SearchManager sm = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView sv = (SearchView) menu.findItem(R.id.search).getActionView();
        sv.setSearchableInfo(sm.getSearchableInfo(getComponentName()));
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(), "You Have Submitted: "+query, Toast.LENGTH_SHORT).show();
                ar.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getApplicationContext(), "You are Searching for : "+newText, Toast.LENGTH_SHORT).show();
                ar.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
