package com.test.demos.demos.binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import android.os.RemoteException;
import android.util.Log;

import com.test.demos.demos.IMyAidlInterface;
import com.test.demos.demos.Message;

import java.util.List;

public class PushManager {

    private static final String TAG = "GEBILAOLITOU";
    private int id = 1;

    //定义为单例模式
    private PushManager() {
    }

    private IMyAidlInterface iMyAidlInterface;

    private static PushManager instance = new PushManager();

    public static PushManager getInstance() {
        return instance;
    }


    public void init(Context context){
        //定义intent
        Intent intent = new Intent(context,PushService.class);
        //绑定服务
        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

//    public void connect(){
//        try {
//            //通过AIDL远程调用
//            Log.v("verf","pushManager ***************start Remote***************开始去连接啦");
//            iMyAidlInterface.connect();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//
//    }


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //成功连接
            Log.v("verf","pushManager ***************成功连接***************");
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            if(iMyAidlInterface != null){
                try {
                    List<Message> messages = iMyAidlInterface.getMessage();
                    for(Message message : messages){
                        Log.v("verf","收到服务端的信息啦： " + message.toString());
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //断开连接调用
            Log.d("verf","pushManager ***************连接已经断开***************");
        }
    };
}

