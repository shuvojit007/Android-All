package com.example.shobojit.somepractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tuyenmonkey.mkloader.MKLoader;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
    Button btninfo,btnerror,btnwarnig,btnsuc;
    MKLoader mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btninfo = (Button) findViewById(R.id.btninfo);
        btnerror = (Button) findViewById(R.id.btnerror);
        mk = (MKLoader) findViewById(R.id.MKLoader);
        btnsuc = (Button) findViewById(R.id.btnsuc);
        btnwarnig = (Button) findViewById(R.id.btnwarning);

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.info(getApplicationContext(), "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
            }
        });
        btnerror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.error(getApplicationContext(), "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
            }
        });

        btnwarnig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mk.setVisibility(View.INVISIBLE);
                Toasty.warning(getApplicationContext(), "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
            }
        });

        btnsuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mk.setVisibility(View.VISIBLE);
                Toasty.success(getApplicationContext(), "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}
