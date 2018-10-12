package com.test.demos.demos.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.test.demos.demos.R;
import com.test.demos.demos.fragmenttest.FragmentTestActivity;

public class ServiceTestActivity extends AppCompatActivity {
    private Test2Service.MyBinder myBinder;

    boolean mBound = false; //一开始，并没有和Service绑定.这个参数是用来显示绑定状态

    //匿名内部类：服务连接对象
    private ServiceConnection connection = new ServiceConnection() {

        //当服务异常终止时会调用。注意，解除绑定服务时不会调用
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.v("verf","onServiceDisconnected");
            mBound = false; //服务异常终止时，状态为未绑定
            //解决了多次执行unbindService()方法引发的异常问题
        }

        //和服务绑定成功后，服务会回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.v("verf","onServiceConnected");
            myBinder = (Test2Service.MyBinder) service;
            //在Activity中调用Service里面的方法
            myBinder.startDownload();
            myBinder.getProgress();
            mBound = true; //true说明是绑定状态
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_test);
        Log.v("verf","ServiceTestActivity thread " + Thread.currentThread().getId()+"");
        findViewById(R.id.start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceTestActivity.this, TestService.class);
                startService(intent);
            }
        });
        findViewById(R.id.stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceTestActivity.this, TestService.class);
                stopService(intent);
            }
        });

        findViewById(R.id.start_intentservice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceTestActivity.this, Test2Service.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
//                startService(intent);
            }
        });
        findViewById(R.id.stop_intentservice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ServiceTestActivity.this, FragmentTestActivity.class));
                finish();
//                Intent intent = new Intent(ServiceTestActivity.this, Test2Service.class);
//                if(mBound){
//                    unbindService(connection);
//                    mBound=false;
//                }
            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ServiceTestActivity.this, FragmentTestActivity.class));
            }
        });

    }
}
