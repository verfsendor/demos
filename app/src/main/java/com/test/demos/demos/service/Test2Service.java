package com.test.demos.demos.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class Test2Service extends Service {

    String tag = getClass().getSimpleName();
    @Override
    public void onCreate() {
        Log.v("verf",tag + " onCreate" );
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("verf",tag + " onStartCommand" );
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v("verf",tag + " onBind" );
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v("verf",tag + " onUnbind" );
        return super.onUnbind(intent);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("verf",tag + " onDestroy" );
    }
}
