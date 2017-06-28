package com.example.shobojit.alarmmanager_practise;

import android.app.Service;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by SHOBOJIT on 5/23/2017.
 */

public class RingtonePlayingService extends Service {

    private Ringtone ringtone;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        if(uri == null) {
            uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }

        ringtone = RingtoneManager.getRingtone(this, uri);

        ringtone.play();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ringtone.stop();
    }



}