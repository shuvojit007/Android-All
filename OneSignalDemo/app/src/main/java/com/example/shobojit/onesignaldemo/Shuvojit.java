package com.example.shobojit.onesignaldemo;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SHOBOJIT on 12/9/2016.
 */

public class Shuvojit extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new ShuvojitHandler())
                .autoPromptLocation(true)
                .init();

        Fresco.initialize(this);
    }
    private class ShuvojitHandler implements OneSignal.NotificationOpenedHandler{

        @Override
        public void notificationOpened(OSNotificationOpenResult result) {
            JSONObject data = result.notification.payload.additionalData;
            String value="info";
            String Image="img";



            if(data.has(value)){
                try {
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("info",data.getString(value));
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else if(data.has(Image)){
                try {
                    Intent intent2 = new Intent(getApplicationContext(), Main3Activity.class);
                    intent2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent2.putExtra("img",data.getString(Image));
                    startActivity(intent2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
