package com.example.shobojit.someadvancetopicsonandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Butter_knife extends AppCompatActivity {
    @BindView (R.id.ed) EditText editText; @BindView(R.id.btn) Button btn;
    @BindView(R.id.tt) TextView textView; @BindView(R.id.btn1) Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

        @OnClick({R.id.btn ,R.id.btn1})
        void Showtext (Button btn){
        String text = editText.getText().toString();
        textView.setText(text);
        }
}
