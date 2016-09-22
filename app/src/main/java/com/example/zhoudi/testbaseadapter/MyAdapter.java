package com.example.zhoudi.testbaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhoudi on 16/9/22.
 */
public class MyAdapter extends BaseAdapter {

    List<itemBean> list;


    LayoutInflater mlayout;
    MyAdapter(Context context,List<itemBean> list){
        this.list = list;
        mlayout = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    //数据项
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    //
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //普通
//        if (convertView == null) {
//            convertView = mlayout.inflate(
//                    R.layout.item, parent, false);
//        }
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.image); //耗费时间
//        TextView title = (TextView) convertView.findViewById(R.id.title);
//        TextView content = (TextView) convertView.findViewById(R.id.content);
//
//        imageView.setImageResource(list.get(position).getImage());
//        title.setText(list.get(position).getTitle());
//        content.setText(list.get(position).getContent());


        //高级方法
        //避免findViewById


        ViewHodlder viewHodlder;
        if (convertView == null) {
            convertView = mlayout.inflate(
                    R.layout.item, parent, false);
            viewHodlder = new ViewHodlder();
            viewHodlder.imageView = (ImageView) convertView.findViewById(R.id.image);
            viewHodlder.title = (TextView) convertView.findViewById(R.id.title);
            viewHodlder.content = (TextView) convertView.findViewById(R.id.content);

            convertView.setTag(viewHodlder);
        }else{
            viewHodlder =  (ViewHodlder)convertView.getTag();
        }
        viewHodlder.imageView.setImageResource(list.get(position).getImage());
        viewHodlder.title.setText(list.get(position).getTitle());
        viewHodlder. content.setText(list.get(position).getContent());


        return convertView;
    }

    class ViewHodlder{

        public ImageView imageView;
        public TextView title;
        public  TextView content;

    }

}
