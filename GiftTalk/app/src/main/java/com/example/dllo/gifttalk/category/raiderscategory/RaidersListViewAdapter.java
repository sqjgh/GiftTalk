package com.example.dllo.gifttalk.category.raiderscategory;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.dllo.gifttalk.R;

/**
 * Created by dllo on 16/10/27.
 */
public class RaidersListViewAdapter extends BaseAdapter {
    private int[] arrayList = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private Context context;
    final int VIEW_TYPE = 2;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;


    public RaidersListViewAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_1;
        }
        return TYPE_2;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE;
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
        ViewHolder1 viewHolder1 = null;
        int type = getItemViewType(i);

        if (view == null) {
            switch (type) {
                case TYPE_1:
                    view = LayoutInflater.from(context).inflate(R.layout.head_raiders_category, viewGroup, false);
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_raiders_category);
                    HeadRecyclerViewRaidersAdapter adapter = new HeadRecyclerViewRaidersAdapter(context);
                    recyclerView.setAdapter(adapter);
                    GridLayoutManager manager = new GridLayoutManager(context, 3, LinearLayoutManager.HORIZONTAL, false);
                    recyclerView.setLayoutManager(manager);
                    viewHolder1 = new ViewHolder1(view);
                    view.setTag(viewHolder1);
                    break;
                case TYPE_2:
                    view = LayoutInflater.from(context).inflate(R.layout.item_lv_raiders_category, viewGroup, false);
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_1:
                    viewHolder1 = (ViewHolder1) view.getTag();
                    break;
                case TYPE_2:
                    viewHolder = (ViewHolder) view.getTag();
                    break;
            }
        }
        switch (type) {
            case TYPE_1:
                break;
            case TYPE_2:
                viewHolder.pic6.setImageResource(arrayList[0]);
                viewHolder.pic1.setImageResource(arrayList[1]);
                viewHolder.pic2.setImageResource(arrayList[2]);
                viewHolder.pic3.setImageResource(arrayList[3]);
                viewHolder.pic4.setImageResource(arrayList[4]);
                viewHolder.pic5.setImageResource(arrayList[5]);
        }


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

    private class ViewHolder1 {
        public ViewHolder1(View view) {

        }
    }
}
