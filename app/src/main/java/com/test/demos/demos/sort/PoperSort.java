package com.test.demos.demos.sort;

public class PoperSort extends Sort{

    @Override
    public void sort() {
        logSort("冒泡排序",true);
        for(int i = 0; i < data.size(); i ++){
            for(int j = 0; j< data.size() - 1 - i; j ++){
                if(j + 1 < data.size()){
                    if(data.get(j + 1) < data.get(j)){
                        int number = data.get(j);
                        data.set(j,data.get(j + 1) );
                        data.set(j +1, number);
                    }
                }
            }
        }
        logSort("冒泡排序",false);
    }
}
