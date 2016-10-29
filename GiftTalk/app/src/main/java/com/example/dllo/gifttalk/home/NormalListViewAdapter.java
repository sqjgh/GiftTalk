package com.example.dllo.gifttalk.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.home.homebeans.HomeBeans;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/27.
 */
public class NormalListViewAdapter extends BaseAdapter {
    private Context context;
    ArrayList<HomeBeans> arrayList;

    public NormalListViewAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<HomeBeans> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_rv_vp_home, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.title.setText(arrayList.get(i).getTitle());
        viewHolder.title2.setText(arrayList.get(i).getTitle2());
        viewHolder.column.setText(arrayList.get(i).getColumn());
        viewHolder.column2.setText(arrayList.get(i).getColumn2());
        viewHolder.follow.setText(arrayList.get(i).getFollow());
        viewHolder.pic.setImageResource(arrayList.get(i).getPic());


        return view;
    }


    private class ViewHolder {
        private final ImageView pic;
        private final TextView title;
        private final TextView title2;
        private final TextView column;
        private final TextView column2;
        private final TextView follow;

        public ViewHolder(View itemView) {
            pic = (ImageView) itemView.findViewById(R.id.iv_item_home);
            title = (TextView) itemView.findViewById(R.id.title_item_home);
            title2 = (TextView) itemView.findViewById(R.id.title2_item_home);
            column = (TextView) itemView.findViewById(R.id.column_item_home);
            column2 = (TextView) itemView.findViewById(R.id.column2_item_home);
            follow = (TextView) itemView.findViewById(R.id.follow_item_home);
        }
    }
}