package com.example.dllo.gifttalk.category.singlecategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/31.
 */
public class LeftLVAdapter extends BaseAdapter {
    ArrayList<String> list;

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_left_single_category,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else viewHolder = (ViewHolder) view.getTag();
        viewHolder.textView.setText(list.get(i));
        return view;
    }
    class ViewHolder{
        private TextView textView;
        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.tv_left_single_category);

        }
    }
}
