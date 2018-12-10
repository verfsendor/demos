package com.test.demos.demos.listview;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.test.demos.demos.Constants;
import com.test.demos.demos.R;
import com.test.demos.demos.fragmenttest.ContentFragment;

import java.util.ArrayList;

public class ViewpagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        Log.v("verf","ViewpagerActivity " + "onCreate");
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        ArrayList<Fragment> fragments = new ArrayList<>();
        for(int i = 0; i < 6; i ++){
            ContentFragment contentFragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.FRAGMENT_NAME,"" + (i + 1));
            contentFragment.setArguments(bundle);
            fragments.add(contentFragment);
        }
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("verf","ViewpagerActivity " + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("verf","ViewpagerActivity " + "onResume");
    }

    public static class MyAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> datas;
        public MyAdapter(FragmentManager fm, ArrayList<Fragment> datas) {
            super(fm);
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Fragment getItem(int position) {
            return datas.get(position);
        }
    }
}
