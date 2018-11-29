package com.test.demos.demos.listview;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.test.demos.demos.R;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = (ListView)findViewById(R.id.listview);
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        TabLayout.Tab tab1 = tabLayout.newTab();
        tab1.setText("分类1");
        TabLayout.Tab tab2 = tabLayout.newTab();
        tab2.setText("分类2");
        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        ArrayList<ListViewBean> list = new ArrayList<>();
        for(int i = 0; i < 225; i++){
            ListViewBean bean = new ListViewBean("名字","值", "2018-1127","备注");
            list.add(bean);
        }
        MyAdapter adapter = new MyAdapter(this,0,0,list);
        listView.setAdapter(adapter);
    }


    public static class MyAdapter extends ArrayAdapter<ListViewBean>{

        public MyAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<ListViewBean> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_listview,null);
                ViewHandler viewHandler = new ViewHandler();
                viewHandler.tvName = (TextView)convertView.findViewById(R.id.name);
                viewHandler.tvValue = (TextView)convertView.findViewById(R.id.value);
                viewHandler.tvDate = (TextView)convertView.findViewById(R.id.date);
                viewHandler.tvDesc = (TextView)convertView.findViewById(R.id.desc);
                convertView.setTag(viewHandler);
            }
            ViewHandler viewHandler = (ViewHandler) convertView.getTag();
            if(viewHandler != null){
                viewHandler.tvName.setText(getItem(position).getName());
                viewHandler.tvValue.setText(getItem(position).getValue());
                viewHandler.tvDate.setText(getItem(position).getDate());
                viewHandler.tvDesc.setText(getItem(position).getDesc());
            }
            return convertView;
        }
    }

    public static class ViewHandler{
        public TextView tvName;
        public TextView tvValue;
        public TextView tvDate;
        public TextView tvDesc;
    }
}
