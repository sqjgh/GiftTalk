package com.example.dllo.gifttalk.category.singlecategory;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by dllo on 16/10/24.
 */
public class SingleFragment extends BaseFragment{

    private ListView leftLv;
    private StickyListHeadersListView rightLv;
    private ArrayList<String> headArrayList;
    private ArrayList<String> rightArrayList;

    @Override
    protected void initData() {
        RightLVAdapter rightLVAdapter = new RightLVAdapter();
        LeftLVAdapter leftLVAdapter = new LeftLVAdapter();

        headArrayList = new ArrayList<>();
        rightArrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            headArrayList.add("头" + i);
            rightArrayList.add("内容" + i);
        }
        leftLVAdapter.setList(headArrayList);

        rightLVAdapter.setHeadList(headArrayList);
        rightLVAdapter.setRightList(rightArrayList);

        leftLv.setAdapter(leftLVAdapter);
        rightLv.setAdapter(rightLVAdapter);

        leftLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                rightLv.setSelection(i);
            }
        });

        rightLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                Log.d("SingleFragment", "onScrollStateChanged--i:" + i);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                leftLv.smoothScrollToPositionFromTop(i - 1, 0);
            }
        });

    }

    @Override
    protected void initView() {
        leftLv = bindView(R.id.lv_left_single_category);
        rightLv = bindView(R.id.lv_right_single_category);


    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_single_category;

    }
}
