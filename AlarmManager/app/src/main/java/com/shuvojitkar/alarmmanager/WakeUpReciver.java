package com.shuvojitkar.alarmmanager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class WakeUpReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        if(uri == null) {
            uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent in = new Intent(context, MainActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,in,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.alert_dark_frame)
                .setContentTitle("Notificaiton Title")
                .setContentText("Notification Text")
                .setSound(uri)
                .setAutoCancel(true);


        notificationManager.notify(0,builder.build());
    }
}
