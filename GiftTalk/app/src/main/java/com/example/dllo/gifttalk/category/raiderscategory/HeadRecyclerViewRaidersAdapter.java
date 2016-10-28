package com.example.dllo.gifttalk.category.raiderscategory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.gifttalk.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/27.
 */
public class HeadRecyclerViewRaidersAdapter extends RecyclerView.Adapter<HeadRecyclerViewRaidersAdapter.ViewHolder>{
    ArrayList<RaidersRecyclerViewBeans> beans;
    private Context context;
    public void setBeans(ArrayList<RaidersRecyclerViewBeans> beans) {
        this.beans = beans;
    }

    public HeadRecyclerViewRaidersAdapter(Context context) {

        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_head_raiders_category,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
