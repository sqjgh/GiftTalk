package com.example.dllo.gifttalk.home;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.home.RollViewPager.RollVPLoopAdapter;
import com.example.dllo.gifttalk.home.beantools.HomeBeans;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/27.
 */
public class HomeFirstLVAdapter extends BaseAdapter {
    private Context context;
    ArrayList<HomeBeans> arrayList;
    final int VIEW_TYPE = 3;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;
    final int TYPE_3 = 2;

    public HomeFirstLVAdapter(Context context) {
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
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPE_1;
        }
        if (position == 2){
            return TYPE_2;
        }
        if (position == 7){
            return TYPE_3;
        }
        return TYPE_3;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE;
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
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        int type = getItemViewType(i);

        if (view == null) {
            switch (type){
                case TYPE_1:
                    view = LayoutInflater.from(context).inflate(R.layout.rollviewpager_home, null);
                    RollPagerView rollPagerView = (RollPagerView) view.findViewById(R.id.rollvp_home);
                    rollPagerView.setHintView(new ColorPointHintView(context, Color.RED, Color.WHITE));
                    rollPagerView.setAdapter(new RollVPLoopAdapter(rollPagerView));
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                    break;
                case TYPE_2:
                    view = LayoutInflater.from(context).inflate(R.layout.image_item_home, null);
                    viewHolder1 = new ViewHolder1(view);
                    view.setTag(viewHolder1);
                    break;
                case TYPE_3:
                    view = LayoutInflater.from(context).inflate(R.layout.item_rv_vp_home, null);
                    viewHolder2 = new ViewHolder2(view);
                    view.setTag(viewHolder2);
                    break;
            }
        } else {
            switch (type){
                case TYPE_1:
                    viewHolder = (ViewHolder) view.getTag();
                    break;
                case TYPE_2:
                    viewHolder1 = (ViewHolder1) view.getTag();
                    break;
                case TYPE_3:
                    viewHolder2 = (ViewHolder2) view.getTag();
                    break;
            }
        }
        switch (type){
            case TYPE_1:
//                viewHolder.title.setText(arrayList.get(i).getTitle());
//                viewHolder.title2.setText(arrayList.get(i).getTitle2());
//                viewHolder.column.setText(arrayList.get(i).getColumn());
//                viewHolder.column2.setText(arrayList.get(i).getColumn2());
//                viewHolder.follow.setText(arrayList.get(i).getFollow());
//                viewHolder.pic.setImageResource(arrayList.get(i).getPic());
                break;
            case TYPE_2:
                viewHolder1.imageView.setImageResource(arrayList.get(i).getPic());
                break;
            case TYPE_3:
//                viewHolder2.title.setText(arrayList.get(i).getTitle());
//                viewHolder2.title2.setText(arrayList.get(i).getTitle2());
//                viewHolder2.column.setText(arrayList.get(i).getColumn());
//                viewHolder2.column2.setText(arrayList.get(i).getColumn2());
                viewHolder2.follow.setText(arrayList.get(i).getFollow());
//                viewHolder2.pic.setImageResource(arrayList.get(i).getPic());
                break;
        }



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

    private class ViewHolder1 {

        private final ImageView imageView;

        public ViewHolder1(View itemView) {
            imageView = (ImageView) itemView.findViewById(R.id.imageview_item_home);

        }
    }

    private class ViewHolder2 {
        private final ImageView pic;
        private final TextView title;
        private final TextView title2;
        private final TextView column;
        private final TextView column2;
        private final TextView follow;

        public ViewHolder2(View itemView) {
            pic = (ImageView) itemView.findViewById(R.id.iv_item_home);
            title = (TextView) itemView.findViewById(R.id.title_item_home);
            title2 = (TextView) itemView.findViewById(R.id.title2_item_home);
            column = (TextView) itemView.findViewById(R.id.column_item_home);
            column2 = (TextView) itemView.findViewById(R.id.column2_item_home);
            follow = (TextView) itemView.findViewById(R.id.follow_item_home);
        }
    }
}