package com.example.shobojit.networkingpractise.TeacherDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shobojit.networkingpractise.R;

public class TeacherData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_data);

        Button btn = (Button) findViewById(R.id.thit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Teacher_detail.class));
            }
        });
    }
}
