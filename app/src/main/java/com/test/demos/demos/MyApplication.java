package com.test.demos.demos;

import android.app.Application;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Writer result = new StringWriter();
                PrintWriter printWriter = new PrintWriter(result);
                Throwable cause = e;
                while (null != e){
                    e.printStackTrace();
                    cause = cause.getCause();
                }
                String string = result.toString();
                printWriter.close();
            }
        });
        Log.v("verf","当前进程 " + android.os.Process.myPid());
    }
}
