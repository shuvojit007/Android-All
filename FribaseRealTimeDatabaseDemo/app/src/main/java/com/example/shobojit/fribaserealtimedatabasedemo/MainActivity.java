package com.example.shobojit.fribaserealtimedatabasedemo;
import android.app.usage.NetworkStats;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {
    FirebaseAnalytics mFirebaseAnalytics;
    TextView tv;
    DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
    DatabaseReference cdr = dr.child("Name");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tv);

    }
    @Override
    protected void onStart() {
        super.onStart();
        cdr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                tv.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
