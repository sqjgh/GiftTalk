package com.example.dllo.gifttalk.category.singlecategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.category.categorybeans.SingleBeans;

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
            GridLayout gridLayout = (GridLayout) view.findViewById(R.id.gl_item_right_category);
            for (int ii = 0; ii < singleBeans.getData().getCategories().get(i).getSubcategories().size(); ii++) {
                View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_right,null);
                ImageView imageView = (ImageView) v.findViewById(R.id.image_one);
                TextView textView = (TextView) v.findViewById(R.id.tv_one);
                VolleySingleton.getInstance().getImage(singleBeans.getData().getCategories().get(i).getSubcategories().get(ii).getIcon_url(),imageView);
                textView.setText(singleBeans.getData().getCategories().get(i).getSubcategories().get(ii).getName());
                gridLayout.addView(v);
            }

            bodyViewHolder = new BodyViewHolder(view);
            view.setTag(bodyViewHolder);


        } else {
            bodyViewHolder = (BodyViewHolder) view.getTag();
        }

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
        private TextView tvBody;

        public BodyViewHolder(View view) {

        }
    }




}