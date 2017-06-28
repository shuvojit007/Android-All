package com.example.shobojit.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shobojit.eventbus.adapter.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusPrac extends AppCompatActivity {
    EditText editText;
    Button btn;
    TextView ttv;
    EventBus eventBus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        editText = (EditText) findViewById(R.id.ed);
        btn = (Button) findViewById(R.id.btn);
        ttv = (TextView) findViewById(R.id.tv);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventBus.post(new MessageEvent(editText.getText().toString()));

            }
        });

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Showmethod (MessageEvent event){
    ttv.setText(event.getMesg());
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
}
