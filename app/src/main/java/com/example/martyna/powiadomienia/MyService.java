package com.example.martyna.powiadomienia;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Martyna on 2017-12-09.
 */

public class MyService extends Service {

    MyBroadcastReceiver mReceiver = new MyBroadcastReceiver();

    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction("com.example.martyna.wiadomosci.CUSTOM_INTENT");
        this.registerReceiver(mReceiver, filter, "com.example.martyna.wiadomosci.SENDING_MSG", null);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        unregisterReceiver(mReceiver);
    }
}
