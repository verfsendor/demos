package com.test.demos.demos.sort;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.test.demos.demos.R;
import java.util.ArrayList;
import java.util.Random;
public class SortActivity  extends AppCompatActivity {
    ArrayList<Integer> floats = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
//        new ChooseSort().setData(getSortData(true)).sort();
//        new InsertSort().setData(getSortData(false)).sort();
//        new PoperSort().setData(getSortData(false)).sort();
        new QuickSort().setData(getSortData(true)).sort();
    }

    public ArrayList<Integer> getSortData(boolean newset){
        if(newset){
            floats.clear();
            Random random = new Random();
            for (int i = 0; i < 15; i++) {
                floats.add(random.nextInt(100));
            }
            return floats;
        }else {
            return floats;
        }
    }
}
