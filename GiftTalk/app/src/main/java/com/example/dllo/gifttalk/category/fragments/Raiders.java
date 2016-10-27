package com.example.dllo.gifttalk.category.fragments;

import android.widget.ListView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;

/**
 * Created by dllo on 16/10/24.
 */
public class Raiders extends BaseFragment{

    private ListView listView;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        listView = bindView(R.id.listview_raiders_category);
        RaidersListViewAdapter adapter = new RaidersListViewAdapter(getActivity());
        listView.setAdapter(adapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_raiders_category;
    }
}
