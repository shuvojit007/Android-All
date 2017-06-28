package com.example.shobojit.photopractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;

public class Rating extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rating);
        SmileRating smileRating = (SmileRating) findViewById(R.id.smile_rating);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley) {
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(getApplicationContext(), "BAD", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(getApplicationContext(), "GOOD", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(getApplicationContext(), "Great", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(getApplicationContext(), "OKAY", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(getApplicationContext(), "TERRIBLE", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
