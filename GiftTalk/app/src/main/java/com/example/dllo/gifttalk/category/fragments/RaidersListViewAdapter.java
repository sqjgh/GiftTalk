package com.example.dllo.gifttalk.category.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.dllo.gifttalk.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/27.
 */
public class RaidersListViewAdapter extends BaseAdapter{
    private int[] arrayList = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    private Context context;



    public RaidersListViewAdapter(Context context) {

        this.context = context;
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_raiders_category,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.pic6.setImageResource(arrayList[0]);
        viewHolder.pic1.setImageResource(arrayList[1]);
        viewHolder.pic2.setImageResource(arrayList[2]);
        viewHolder.pic3.setImageResource(arrayList[3]);
        viewHolder.pic4.setImageResource(arrayList[4]);
        viewHolder.pic5.setImageResource(arrayList[5]);

        return view;
    }

    private class ViewHolder {

        private final ImageView pic1;
        private final ImageView pic2;
        private final ImageView pic3;
        private final ImageView pic4;
        private final ImageView pic5;
        private final ImageView pic6;

        public ViewHolder(View view) {
            pic1 = (ImageView) view.findViewById(R.id.pic1_raiders_category);
            pic2 = (ImageView) view.findViewById(R.id.pic2_raiders_category);
            pic3 = (ImageView) view.findViewById(R.id.pic2_raiders_category);
            pic4 = (ImageView) view.findViewById(R.id.pic2_raiders_category);
            pic5 = (ImageView) view.findViewById(R.id.pic2_raiders_category);
            pic6 = (ImageView) view.findViewById(R.id.pic2_raiders_category);
        }
    }
}
