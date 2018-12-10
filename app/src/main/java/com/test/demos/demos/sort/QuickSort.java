package com.test.demos.demos.sort;

import android.util.Log;

public class QuickSort extends Sort {
    int k = 0;
    @Override
    public void sort() {
        logSort("快速排序",true);
        sortNum(0,data.size()-1);
        logSort("快速排序",false);
    }


    public void sortNum(int start, int end){
        if(start == end){
            return;
        }
        int base = data.get(start);
        int left = start;
        int right = end;
        while (left < right){
            while (left < right && data.get(left) < base)
                left ++;
            data.set(left, data.get(right));
            while (left < right && data.get(right) > base)
                right --;
            data.set(right, data.get(left));

        }
        data.set(left, base);
        sortNum(start,left - 1);
        sortNum(left + 1, end);
    }


//    public void sortNum(int start, int end){
//        int center = (start + end)/2;
//        int dataCenter = data.get(center);
//        for(int i = start, j = end;i == j;){
//            if(data.get(i) <= dataCenter){
//                i ++;
//                continue;
//            }
//            if(data.get(j) >= dataCenter){
//                j --;
//                continue;
//            }
//
//
//        }
//    }

//    public void sortNum(int start,int end){
//        if(start == end){
//            return;
//        }
//        int center = (start + end)/2;
//        Log.v("verf", "start = " + start + " end =  " + end + " center = " + center);
//        int dataCenter = data.get(center);
//        for(int i = start, j = end; i < j;){
//            Log.v("verf", "i = " + i + " j =  " + j + " datacenter = " + dataCenter);
//            if(i < center && data.get(i) <= dataCenter){
//                i ++;
//                continue;
//            }
//            if(j > center && data.get(i) > dataCenter){
//                j --;
//                continue;
//            }
//            int n = data.get(i);
//            data.set(i, data.get(j));
//            data.set(j, n);
//            if(i == center){
//                center = j;
//            }
//            if(j == center){
//                center = i;
//            }
//            if(i < center){
//                i++;
//            }
//            if(j > center){
//                j--;
//            }
//            logSort(true);
//        }
//        Log.v("verf", "下一次递归 " + center);
//        if(end - start > 1) {
//            sortNum(start, center);
//            sortNum(center, end);
//        }
//    }
}
