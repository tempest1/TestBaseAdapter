package com.example.zhoudi.testbaseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List arrylist = new ArrayList<itemBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i =0;i<20;i++){
            itemBean item = new itemBean();
            item.setImage(R.mipmap.ic_launcher);
            item.setTitle("Title");
            item.setContent("Content");
            arrylist.add(item);
        }

        MyAdapter myAdapter =new MyAdapter(this,arrylist);
        ListView listView = (ListView) findViewById(R.id.lv_list);
        listView.setAdapter(myAdapter);

    }
}
