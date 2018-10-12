package com.test.demos.demos.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class TestService extends Service {

    String tag = getClass().getSimpleName();
    @Override
    public void onCreate() {
        Log.v("verf",tag + " onCreate" );
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("verf",tag + " onStartCommand" );
        Log.v("verf","now thread " + Thread.currentThread().getId()+"");
        new Thread(new Runnable() {
            public void run() {
                //在子线程中处理具体的逻辑
                //在这里我们只做打印子线程id的操作
                Log.v("verf","now thread " + Thread.currentThread().getId()+"");
                stopSelf();  //服务执行完毕后自动停止
            }
        }).start();

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
