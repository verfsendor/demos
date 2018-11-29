package com.test.demos.demos.okhttp;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.test.demos.demos.R;
import com.test.demos.demos.jni.NewJniTest;

public class OkHttpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        Button button = (Button)findViewById(R.id.btn);
        TextView textView = (TextView)findViewById(R.id.tv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        textView.setText(NewJniTest.getNewTxt());
    }
}
