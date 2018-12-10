package com.test.demos.demos.sort;

import java.util.ArrayList;

/**
 * 插入排序，复杂度N2，稳定，但是不同的是插入过程的数据结构选择，否则会增加一层遍历操作，增加复杂度
 */

public class InsertSort extends Sort {
    @Override
    public void sort() {
        logSort("插入排序",true);
        for(int i = 0; i < data.size(); i ++){
            for(int j = 0;j < i; j ++){
                if(data.get(j) > data.get(i)){
                    int number = data.get(i);
                   for(int n = i; n > j; n--){
                       data.set(n, data.get(n -1));
                   }
                   data.set(j, number);
                }
            }
        }
        logSort("插入排序",false);
    }
}
