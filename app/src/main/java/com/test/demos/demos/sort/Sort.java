package com.test.demos.demos.sort;

import android.util.Log;

import java.util.ArrayList;

public abstract class Sort {
    ArrayList<Integer> data = new ArrayList<>();
    long starttime;
    long endtime;


    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }

    public Sort setData(ArrayList<Integer> nums){
        this.data.clear();
        this.data.addAll(nums);
        return this;
    }
    public void logSort(boolean start){
        logSort("", start);
    }

    public void logSort(String title ,boolean start){
        String x = "";
        for(Integer n : data){
            x += (" " + n);
        }
        if(start) {
            Log.v("verf", title + " 排序前 " + " " + x);
            starttime = System.currentTimeMillis();
        }else {
            Log.v("verf", title + " 排序后 " + " " + x);
            endtime = System.currentTimeMillis();
            Log.v("verf", title + " 时间花费 " + (endtime - starttime));
        }
    }
    public abstract void sort();
}
