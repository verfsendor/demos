package com.test.demos.demos.fragmenttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.demos.demos.R;

public class Test2fragment extends AppCompatDialogFragment {
    String tag = getClass().getSimpleName();

    @Override
    public void onAttach(Context context) {
        Log.v("verf",tag + " " + "onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v("verf",tag + " " + "onCreate");
        super.onCreate(savedInstanceState);
    }



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.v("verf",tag + " " + "onCreateView");
        View view = inflater.inflate(R.layout.fragment_test2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.v("verf",tag + " " + "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.v("verf",tag + " " + "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.v("verf",tag + " " + "onResume");
        super.onResume();
    }

    @Override
    public void onStop() {
        Log.v("verf",tag + " " + "onStop");
        super.onStop();
    }

    @Override
    public void onPause() {
        Log.v("verf",tag + " " + "onPause");
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Log.v("verf",tag + " " + "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.v("verf",tag + " " + "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.v("verf",tag + " " + "onDetach");
        super.onDetach();
    }
}
