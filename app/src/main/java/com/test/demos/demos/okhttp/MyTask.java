package com.test.demos.demos.okhttp;

import android.util.Log;

public class MyTask implements Runnable {
    @Override
    public void run() {
        Log.v("verf","现在正在执行任务 " + Thread.currentThread().getId());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
