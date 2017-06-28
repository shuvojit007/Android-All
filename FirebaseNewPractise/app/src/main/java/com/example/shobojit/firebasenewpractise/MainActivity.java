package com.example.shobojit.firebasenewpractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shobojit.firebasenewpractise.Utils.FirebaseGetInstanceClass;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText name,phn,age,sex,address;
    DatabaseReference databaseReference = FirebaseGetInstanceClass.GetFirebaseDatabaseInstance().getReference("PersonList/person");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        phn = (EditText) findViewById(R.id.phone);
        age = (EditText) findViewById(R.id.age);
        sex = (EditText) findViewById(R.id.sex);
        address = (EditText) findViewById(R.id.address);
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().equals("")||phn.getText().equals("")||age.getText().equals("")||sex.getText().equals("")||address.getText().equals("")){
                    Toast.makeText(MainActivity.this,"Please Enter a value ", Toast.LENGTH_SHORT).show();
                }else {
                    Map data = new HashMap();
                    data.put("Name",name.getText().toString());
                    data.put("Phone",phn.getText().toString());
                    data.put("Age",age.getText().toString());
                    data.put("Sex",sex.getText().toString());
                    data.put("Address",address.getText().toString());
                    databaseReference.push().setValue(data);
                }
            }
        });

    }
}
