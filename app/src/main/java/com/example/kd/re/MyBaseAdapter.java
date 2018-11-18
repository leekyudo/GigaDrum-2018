package com.example.kd.re;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdapter extends BaseAdapter{

    Context mContext;
    ArrayList<ItemDataBox> mItem = new ArrayList<ItemDataBox>();

    public MyBaseAdapter(Context context){
        mContext = context;
    }

    public void addItem(ItemDataBox item){
        mItem.add(item);
    }



    @Override
    public int getCount() {
        return mItem.size();
    } // ItemDataBox의 항목 갯수

    @Override
    public Object getItem(int position) {
        return mItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView dataView;
        if (convertView == null){
            dataView = new ItemView(mContext,mItem.get(position)); // converterView 스
        }
        else {
            dataView = (ItemView) convertView;
            dataView.setIcon(mItem.get(position).getImage());
            dataView.setText(0,mItem.get(position).getData(0));
            dataView.setText(1,mItem.get(position).getData(1));
            }
        return dataView;
    }
}
