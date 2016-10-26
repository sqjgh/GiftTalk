package com.example.dllo.gifttalk.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/26.
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>{
    private ArrayList<HomeBeans> arrayList;
    private Context context;

    public HomeRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<HomeBeans> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rv_vp_home,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.title2.setText(arrayList.get(position).getTitle2());
        holder.column.setText(arrayList.get(position).getColumn());
        holder.column2.setText(arrayList.get(position).getColumn2());
        holder.follow.setText(arrayList.get(position).getFollow());
        holder.pic.setImageResource(arrayList.get(position).getPic());
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView pic;
        private final TextView title;
        private final TextView title2;
        private final TextView column;
        private final TextView column2;
        private final TextView follow;

        public ViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.iv_item_home);
            title = (TextView) itemView.findViewById(R.id.title_item_home);
            title2 = (TextView) itemView.findViewById(R.id.title2_item_home);
            column = (TextView) itemView.findViewById(R.id.column_item_home);
            column2 = (TextView) itemView.findViewById(R.id.column2_item_home);
            follow = (TextView) itemView.findViewById(R.id.follow_item_home);
        }
    }
}
