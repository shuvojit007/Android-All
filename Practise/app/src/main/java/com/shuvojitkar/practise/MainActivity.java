package com.shuvojitkar.practise;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1 ,ed2,ed3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.phone);
        ed3 = (EditText) findViewById(R.id.addr);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().equals("") ||ed2.getText().equals("") || ed3.getText().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Insert Data", Toast.LENGTH_SHORT).show();
                }
                else{

                    Adapter a = new Adapter(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString());
                    startActivity(new Intent(MainActivity.this,Main2Activity.class).putExtra("Data",  a));
                    //Intent in = new Intent(MainActivity.this,Main2Activity.class);

                }
            }
        });
    }
}
