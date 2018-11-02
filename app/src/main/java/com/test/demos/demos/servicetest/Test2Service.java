package com.test.demos.demos.servicetest;

import android.app.IntentService;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.test.demos.demos.fragmenttest.FragmentTestActivity;
import com.test.demos.demos.fragmenttest.Test2fragment;

public class Test2Service extends IntentService {
    //匿名内部类：服务连接对象
    private ServiceConnection connection = new ServiceConnection() {

        //当服务异常终止时会调用。注意，解除绑定服务时不会调用
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.v("verf","onServiceDisconnected");
            //解决了多次执行unbindService()方法引发的异常问题
        }

        //和服务绑定成功后，服务会回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.v("verf","onServiceConnected");

        }
    };
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
    public void onStart(@Nullable Intent intent, int startId) {
        Log.v("verf",tag + " onStart " + intent.getStringExtra("aaa") );
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("verf",tag + " onStartCommand " + intent.getStringExtra("aaa"));
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
        Intent intent1 = new Intent(Test2Service.this, Test2Service.class);
        bindService(intent1, connection, BIND_AUTO_CREATE);
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
//            startActivity(new Intent(Test2Service.this,FragmentTestActivity.class));
            Log.d("verf", "MyBinder startDownload() executed " + Thread.currentThread().getId());
            // 执行具体的下载任务
        }
        public int getProgress(){
            Log.d("verf", "MyBinder getProgress() executed");
            return 0;
        }
    }


}
