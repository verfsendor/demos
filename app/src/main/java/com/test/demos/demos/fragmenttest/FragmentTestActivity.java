package com.test.demos.demos.fragmenttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.test.demos.demos.R;
import com.test.demos.demos.saveinstanceTest.SaveTestActivity;
import com.test.demos.demos.servicetest.TestService;

public class FragmentTestActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fragment_test);
        findViewById(R.id.fragment_test_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentTestActivity.this, SaveTestActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.fragment_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                Intent intent = new Intent(FragmentTestActivity.this, TestService.class);
stopService(intent);
                FragmentUtils.replaceFragmentWithAnim(getSupportFragmentManager(), Testfragment.class, R.id.frame, null);

            }
        });
        findViewById(R.id.fragment_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtils.replaceFragmentWithAnim(getSupportFragmentManager(), Test2fragment.class, R.id.frame, null);

            }
        });
        findViewById(R.id.fragment_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FragmentTestActivity.this);
                builder.setTitle("title")
                        .setMessage("message")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                builder.create();
                builder.show();
            }
        });
        FragmentUtils.replaceFragmentWithAnim(getSupportFragmentManager(), Testfragment.class, R.id.frame, null);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    }

    @Override
    protected void onPause() {
        Log.v("verf","FragmentTestActivity onPause");
        super.onPause();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.v("saveinstance"," activity onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v("saveinstance"," activity onRestoreInstanceState");
    }
}
