package com.test.demos.demos.fragmenttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.demos.demos.Constants;
import com.test.demos.demos.R;

public class ContentFragment extends AppCompatDialogFragment {
    private String name = "没有名字";

    @Override
    public void onAttach(Context context) {
        if(getArguments() != null){
            name = getArguments().getString(Constants.FRAGMENT_NAME,"没有名字");
        }
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onActivityCreated");

        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onCreateView");
        View view = inflater.inflate(R.layout.fragment_content,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onViewCreated");
        TextView textView = (TextView)view.findViewById(R.id.content);
        textView.setText("content" + name);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onAttachFragment");
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onResume() {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onResume");
        super.onResume();
    }


    @Override
    public void onStart() {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onStart");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.v("verf",getClass().getSimpleName() + "-" + name + " fragment生命周期 " + "onHiddenChanged " + hidden);
    }
}
