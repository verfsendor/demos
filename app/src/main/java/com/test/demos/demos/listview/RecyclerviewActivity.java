package com.test.demos.demos.listview;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.test.demos.demos.R;
import java.util.ArrayList;

public class RecyclerviewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ArrayList<ListViewBean> beans = new ArrayList<>();
        for(int i = 0; i < 5; i ++){
            ListViewBean bean = new ListViewBean("5","3","4","5");
            beans.add(bean);
        }
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        MyAdatper myAdapter = new MyAdatper(this,beans);
        recyclerView.setAdapter(myAdapter);
    }

    public static class MyAdatper extends RecyclerView.Adapter<MyAdatper.MyViewHolder>{

        Context context;
        ArrayList<ListViewBean> data;
        public MyAdatper(Context context, ArrayList<ListViewBean> beans){
            Log.v("verf","myadapter " + beans.size());
            this.context = context;
            this.data = beans;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_listview,parent,false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
             ListViewBean bean = data.get(position);
             holder.date.setText(bean.getDate());
             holder.desc.setText(bean.getDesc());
             holder.name.setText(bean.getName());
             holder.value.setText(bean.getValue());
        }

        @Override
        public int getItemCount() {
            return data == null ? 0 : data.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
            public TextView name;
            public TextView date;
            public TextView desc;
            public TextView value;

            public MyViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                value = itemView.findViewById(R.id.value);
                desc = itemView.findViewById(R.id.desc);
                date = itemView.findViewById(R.id.date);
            }
        }
    }




}
