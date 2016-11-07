package com.example.dllo.gifttalk.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by dllo on 16/10/27.
 */
public abstract class BaseListViewAdapter<E> extends BaseAdapter{
    private List<E> data;
    private int itemLayout;

    public BaseListViewAdapter(int itemLayout) {
        this.itemLayout = itemLayout;
    }

    public BaseListViewAdapter(List<E> data, int itemLayout) {
        this.data = data;
        this.itemLayout = itemLayout;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public E getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommonViewHolder commonViewHolder = CommonViewHolder.getViewHolder(view,viewGroup,itemLayout);
        commonViewHolder.setPos(i);
        bindData(commonViewHolder,data.get(i));
        return commonViewHolder.getItemView();
    }

    protected abstract void bindData(CommonViewHolder holder,E e);
}
