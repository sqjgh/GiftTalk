package com.example.dllo.gifttalk.category.singlecategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by dllo on 16/10/31.
 */
public class RightLVAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private ArrayList<String> headList, rightList;


    public void setHeadList(ArrayList<String> headList) {
        this.headList = headList;
    }

    public void setRightList(ArrayList<String> rightList) {
        this.rightList = rightList;
    }

    @Override
    public long getHeaderId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return headList.size();
    }

    @Override
    public Object getItem(int i) {
        return rightList.get(i);
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
        } else bodyViewHolder = (BodyViewHolder) view.getTag();
        bodyViewHolder.tvBody.setText(rightList.get(i));
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
        headViewHolder.tvHead.setText(headList.get(position));
        return convertView;
    }

    class HeadViewHolder {
        private TextView tvHead;

        public HeadViewHolder(View view) {
            tvHead = (TextView) view.findViewById(R.id.tv_head_single_category);
        }
    }

    class BodyViewHolder {
        private TextView tvBody;

        public BodyViewHolder(View view) {
            tvBody = (TextView) view.findViewById(R.id.tv_right_single_category);
        }
    }
}