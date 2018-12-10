package com.test.demos.demos.sort;

import android.util.Log;

import java.util.ArrayList;

/**
 * 选择排序,复杂性n方，由于每趟需要交换，破坏了最原始的顺序，所以不稳定
 */
public class ChooseSort  extends Sort{

    @Override
    public void sort() {
        logSort("选择排序",true);
        for(int i = 0; i < data.size(); i ++){
            int n = i;
            for(int j = i; j < data.size(); j ++){
                if(data.get(j) < data.get(n)){
                    n = j;
                }
            }
            int number = data.get(i);
            data.set(i,data.get(n));
            data.set(n,number);
        }
        logSort("选择排序",false);
    }
}
