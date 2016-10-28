package com.example.dllo.gifttalk.gift.fragments;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.gift.GiftBeans;
import com.example.dllo.gifttalk.gift.GiftRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 */
public class EveryDayFragment extends BaseFragment{

    private RecyclerView rv;
    private ArrayList<GiftBeans> arrayList;
    private GiftRecyclerViewAdapter adapter;
    private RecyclerViewHeader header;

    @Override
    protected void initData() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            GiftBeans beans = new GiftBeans();
            beans.setPic(R.mipmap.ic_launcher);
            beans.setTitle("标题" + i);
            beans.setTitle2("小标题" + i);
            beans.setPrice("126元" + i);
            arrayList.add(beans);
        }
        adapter.setArrayList(arrayList);
        rv.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        header.attachTo(rv);

    }

    @Override
    protected void initView() {
        rv = bindView(R.id.recyclerview_gift);
        adapter = new GiftRecyclerViewAdapter(getActivity());
        header = (RecyclerViewHeader) getActivity().findViewById(R.id.header);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_everyday_fragment_gift;
    }

}
