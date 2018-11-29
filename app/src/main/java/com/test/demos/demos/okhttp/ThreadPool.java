package com.test.demos.demos.okhttp;

import android.util.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void Executor(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask();
            executor.execute(myTask);
            Log.v("verf","线程池中线程数量：" + executor.getPoolSize() + ",线程池中等待执行的任务数量：" + executor.getQueue().size() + ",已执行完的任务数量：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
