package com.example.dllo.gifttalk.category.singlecategory;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beans.SingleBeans;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by dllo on 16/10/31.
 */
public class RightLVAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private SingleBeans singleBeans;

    public void setSingleBeans(SingleBeans singleBeans) {
        this.singleBeans = singleBeans;
    }


    @Override
    public long getHeaderId(int position) {
        return position;
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
        BodyViewHolder bodyViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_right_single_category, viewGroup, false);
            bodyViewHolder = new BodyViewHolder(view);
            view.setTag(bodyViewHolder);
        } else {
            bodyViewHolder = (BodyViewHolder) view.getTag();
        }
        RightRVAdapter adapter = new RightRVAdapter();
        adapter.setItemPosition(i);
        adapter.setSingleBeans(singleBeans);
        bodyViewHolder.rv.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(viewGroup.getContext(),3, LinearLayoutManager.VERTICAL,false);
        bodyViewHolder.rv.setLayoutManager(manager);
        return view;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeadViewHolder headViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_head_single_category, null);
            headViewHolder = new HeadViewHolder(convertView);
            convertView.setTag(headViewHolder);
        } else {
            headViewHolder = (HeadViewHolder) convertView.getTag();
        }
        headViewHolder.tvHead.setText(singleBeans.getData().getCategories().get(position).getName());
        return convertView;
    }




    class HeadViewHolder {
        private TextView tvHead;

        public HeadViewHolder(View view) {
            tvHead = (TextView) view.findViewById(R.id.tv_head_single_category);
        }
    }

    class BodyViewHolder {

        private final RecyclerView rv;

        public BodyViewHolder(View view) {
            rv = (RecyclerView) view.findViewById(R.id.rv_right_single_category);
        }
    }




}