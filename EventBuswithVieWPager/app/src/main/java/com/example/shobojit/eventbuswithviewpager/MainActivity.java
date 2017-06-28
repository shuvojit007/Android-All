package com.example.shobojit.eventbuswithviewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    EventBus eventBus = EventBus.getDefault();
    EditText ed;
    Button btn;
    TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed  = (EditText) findViewById(R.id.ed);
        btn = (Button) findViewById(R.id.btn);
        tt = (TextView) findViewById(R.id.tt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res = ed.getText().toString();
                eventBus.post(new Adapter(res));
            }
        });

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    void getmessage (Adapter adapter){
        tt.setText(adapter.getName());
    }

    @Override
    protected void onStart() {
        eventBus.register(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }

    public void Viewpa (View v){
    startActivity(new Intent(getApplicationContext(),Main2Activity.class));
    }
}
