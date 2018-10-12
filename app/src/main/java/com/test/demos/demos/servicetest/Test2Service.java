package com.test.demos.demos.servicetest;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class Test2Service extends IntentService {

    String tag = getClass().getSimpleName();
    MyBinder binder = new MyBinder();
    public Test2Service() {
        super("MyIntentService");
    }

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
        return binder;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.v("verf",tag + " onHandleIntent" );
        Log.v("verf", tag + " onHandleIntent " + Thread.currentThread().getId());
        for(int i = 0; i < 5; i ++){
            Log.v("verf",tag + " integer " + i );
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

    //MyBinder类，继承Binder：让里面的方法执行下载任务，并获取下载进度
    public class MyBinder extends Binder {
        public void startDownload() {
            Log.d("verf", "MyBinder startDownload() executed " + Thread.currentThread().getId());
            // 执行具体的下载任务
        }
        public int getProgress(){
            Log.d("verf", "MyBinder getProgress() executed");
            return 0;
        }
    }


}
