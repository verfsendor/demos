package com.test.demos.demos.handler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.test.demos.demos.R;

public class HandlerActivity extends AppCompatActivity {
    int i = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    Log.v("verf","测试-hah- " + i);
                    i ++ ;
                    if(i > 10){
                        return;
                    }
                    Log.v("verf","测试-handlerActivity- " + i);
                }
            }
        }).start();
    }
}
