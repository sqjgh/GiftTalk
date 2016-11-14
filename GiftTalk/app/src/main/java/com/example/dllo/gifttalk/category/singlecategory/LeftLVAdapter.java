package com.example.dllo.gifttalk.category.singlecategory;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beans.SingleBeans;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/31.
 */
public class LeftLVAdapter extends BaseAdapter {
    ArrayList<String> list;
    private SingleBeans singleBeans;
    private int select  = 0;

    public void setSelect(int select) {
        this.select = select;
        notifyDataSetChanged();
    }

    public void setSingleBeans(SingleBeans singleBeans) {
        this.singleBeans = singleBeans;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return singleBeans.getData().getCategories().size();
    }

    @Override
    public Object getItem(int i) {
        return singleBeans.getData().getCategories().get(i);
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
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(singleBeans.getData().getCategories().get(i).getName());


        if (select == i){
            viewHolder.textView.setTextColor(Color.RED);
            viewHolder.rl.setBackgroundColor(Color.WHITE);
            viewHolder.imageView.setVisibility(View.VISIBLE);
        }else {
            viewHolder.rl.setBackgroundColor(Color.GRAY);
            viewHolder.imageView.setVisibility(View.INVISIBLE);
            viewHolder.textView.setTextColor(Color.BLACK);
        }

        return view;
    }
    class ViewHolder{
        private TextView textView;
        private final RelativeLayout rl;
        private final ImageView imageView;

        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.tv_left_single_category);
            rl = (RelativeLayout) view.findViewById(R.id.rl_left_single);
            imageView = (ImageView) view.findViewById(R.id.red_item_single);
        }
    }
}
