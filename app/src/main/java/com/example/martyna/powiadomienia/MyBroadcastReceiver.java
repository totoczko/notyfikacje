package com.example.martyna.powiadomienia;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

/**
 * Created by Martyna on 2017-11-25.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getExtras().getString("title");
        String message = intent.getExtras().getString("text");

        //opening activity on click
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("sms:"));
        smsIntent.putExtra("sms_body", message);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, smsIntent, FLAG_UPDATE_CURRENT);
//        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), FLAG_UPDATE_CURRENT);


        Notification.Builder mBuilder =
                new Notification.Builder(context)
                        .setSmallIcon(R.drawable.ic_action_name)
                        .setContentTitle(title)
                        .setContentText(message);

        mBuilder.setContentIntent(contentIntent);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(NotificationID.getID(), mBuilder.build());
    }

}
