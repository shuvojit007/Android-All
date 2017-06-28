package com.shuvojitkar.alarmmanager.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class Service_Practise extends Service {
    public Service_Practise() {
    }

    @Override
    public IBinder onBind(Intent intent) {

       return null;
    }

    @Override
    public void onDestroy() {
        Log.i("ServiceDemo","Service Destroyed");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("ServiceDemo", "Service Thread  id :"+Thread.currentThread().getId());
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
}
