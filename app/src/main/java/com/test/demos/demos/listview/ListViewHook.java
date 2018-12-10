package com.test.demos.demos.listview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
public class ListViewHook {
        /**
         * 反射获取WindowManagerGlobal中的view的list列表实例，顶层view即为当前获取焦点的view
         */
        public static void hookListView(ListView listView){
            Log.v("verf","hookListView a");
            try {
                Class ListviewClass = Class.forName("android.widget.AbsListView");
                Field mRecyclerField = ListviewClass.getDeclaredField("mRecycler");
                mRecyclerField.setAccessible(true);
                Object recycleBinObject = mRecyclerField.get(listView);

                Class ReclebinClass = Class.forName("android.widget.AbsListView.RecycleBin");
                Field mFirstActivePositionField = ReclebinClass.getDeclaredField("mFirstActivePosition");
                Field mActiveViewsField = ReclebinClass.getDeclaredField("mActiveViews");
                Field mScrapViewsField = ReclebinClass.getDeclaredField("mScrapViews");
                Field mCurrentScrapField = ReclebinClass.getDeclaredField("mCurrentScrap");
                Field mSkippedScrapField = ReclebinClass.getDeclaredField("mSkippedScrap");

                mRecyclerField.setAccessible(true);
                mFirstActivePositionField.setAccessible(true);
                mActiveViewsField.setAccessible(true);
                mScrapViewsField.setAccessible(true);
                mCurrentScrapField.setAccessible(true);
                mSkippedScrapField.setAccessible(true);

                int mFirstActivePosition = (int) mFirstActivePositionField.get(recycleBinObject);
                ArrayList<View> mCurrentScrap = (ArrayList<View>) mCurrentScrapField.get(recycleBinObject);
                ArrayList<View> mSkippedScrap = (ArrayList<View>) mScrapViewsField.get(recycleBinObject);
                View[] mActiveViews = (View[]) mActiveViewsField.get(recycleBinObject);
                Log.v("verf","hookListView b " + mFirstActivePosition + " " + mCurrentScrap + " " + mSkippedScrap + " " + mActiveViews);

                if(mFirstActivePosition >= 0){
                    Log.v("verf","mFirstActivePosition = ");
                }
                if(mCurrentScrap != null){
                    Log.v("verf","mCurrentScrap = " );
                    for(View view : mCurrentScrap){
                        Log.v("verf","   mCurrentScrap = " + view);
                    }
                }

                if(mSkippedScrap != null){
                    Log.v("verf","mSkippedScrap = " );
                    for(View view : mSkippedScrap){
                        Log.v("verf","   mSkippedScrap = " + view);
                    }
                }

                if(mActiveViews != null){
                    Log.v("verf","mActiveViews = ");
                    for(int i = 0; i < mActiveViews.length; i ++){
                        Log.v("verf","   mActiveViews = " + mActiveViews[i]);
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
}
