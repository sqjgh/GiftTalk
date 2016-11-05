package com.example.dllo.gifttalk.secondlevel.secondcategory;

import android.support.v7.widget.RecyclerView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;

/**
 * Created by dllo on 16/11/5.
 */
public class AllForHeadRaiders extends BaseActivity{

    private RecyclerView rv;

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {
        rv = bindView(R.id.rv_all_head_raiders);
    }

    @Override
    protected int getLayout() {
        return R.layout.second_all_head_raiders_category;
    }
}
