package com.example.shobojit.frescoimagelibrary.Initialization;
import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;
public class FrescoIntialization extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
