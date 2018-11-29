package com.test.demos.demos.saveinstanceTest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.test.demos.demos.R;
import com.test.demos.demos.servicetest.ServiceTestActivity;

public class SaveTestActivity extends AppCompatActivity {
    private String tag = getClass().getSimpleName();
    private static final String SAVED_DIALOG_IDS_KEY = "android:savedDialogIds";

    EditText editText;
    String x = "skjgk";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("saveinstance",tag + " onCreate");
        getSupportActionBar().hide();
        setContentView(R.layout.activity_save_test);
        findViewById(R.id.third_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaveTestActivity.this, ServiceTestActivity.class);
                startActivity(intent);
            }
        });
        editText = (EditText)findViewById(R.id.edit);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Bundle windowState = savedInstanceState.getBundle("android:viewHierarchyState");
        final Bundle b = windowState.getBundle("android:savedDialogs");
        final int[] ids = b.getIntArray(SAVED_DIALOG_IDS_KEY);
        final int numDialogs = ids.length;
        Log.v("saveinstance","onRestoreInstanceState dialogs length " + numDialogs);

        if(savedInstanceState !=null) {
            Log.v("saveinstance",tag + " savedInstanceState not null");
            Log.v("saveinstance",tag +  " " + savedInstanceState.getString("edittext", "存储是空") + " 新的");
            x = savedInstanceState.getString("edittext", "存储是空") + " 新的";
            editText.setText(savedInstanceState.getString("edittext", "存储是空") + " 新的");
        }else {
            Log.v("saveinstance",tag + " savedInstanceState null");
        }
    }

    @Override
    protected void onResume() {
        Log.v("saveinstance",tag + " onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("saveinstance",tag + " onPause");
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.v("saveinstance",tag + " onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        String x = null;
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.v("saveinstance",tag + " onSaveInstanceState1");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("edittext",editText.getText().toString());
        Log.v("saveinstance",tag + " onSaveInstanceState2 " + outState.toString());
        super.onSaveInstanceState(outState);
    }
}
