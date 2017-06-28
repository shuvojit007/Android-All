package com.example.shobojit.photopractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

public class Paranoma extends AppCompatActivity {
    private GyroscopeObserver gyroscopeObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paranoma);

        gyroscopeObserver = new GyroscopeObserver();
        // Set the maximum radian the device should rotate to show image's bounds.
        // It should be set between 0 and π/2.
        // The default value is π/9.
        gyroscopeObserver.setMaxRotateRadian(Math.PI/9);

        PanoramaImageView panoramaImageView = (PanoramaImageView) findViewById(R.id.panorama_image_view);
        // Set GyroscopeObserver for PanoramaImageView.
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);
        panoramaImageView.setOnPanoramaScrollListener(new PanoramaImageView.OnPanoramaScrollListener() {
            @Override
            public void onScrolled(PanoramaImageView view, float offsetProgress) {
                // Do something here.
                // The offsetProgress range from -1 to 1, indicating the image scrolls
                // from left(top) to right(bottom).
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register GyroscopeObserver.
        gyroscopeObserver.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister GyroscopeObserver.
        gyroscopeObserver.unregister();
    }
}

