package com.test.demos.demos.binder;

import android.os.RemoteException;
import android.util.Log;

import com.test.demos.demos.IMyAidlInterface;
import com.test.demos.demos.Message;

import java.util.ArrayList;
import java.util.List;

public class MyServer extends IMyAidlInterface.Stub {

    private static final String TAG = "GEBILAOLITOU";


    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public void connect() throws RemoteException {
        Log.v("verf","现在server连接上了");
    }

    @Override
    public List<Message> getMessage() {
        List<Message> messages = new ArrayList<>();
        Message message1 = new Message("第一个呀","111");
        Message message2 = new Message("第二个呀","222");
        Message message3 = new Message("第三个呀","333");
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        return messages;
    }

    @Override
    public void sendMessage(Message msg) throws RemoteException {
        Log.v("verf","MyServer端 ** 接到消息 ** "+ msg.toString());
    }
}

