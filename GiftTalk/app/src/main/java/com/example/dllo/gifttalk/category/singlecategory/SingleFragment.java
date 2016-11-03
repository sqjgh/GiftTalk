package com.example.dllo.gifttalk.category.singlecategory;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.beantools.GsonRequest;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.category.categorybeans.SingleBeans;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by dllo on 16/10/24.
 */
public class SingleFragment extends BaseFragment{

    private ListView leftLv;
    private StickyListHeadersListView rightLv;
    private RightLVAdapter rightLVAdapter;
    private LeftLVAdapter leftLVAdapter;

    @Override
    protected void initData() {
        rightLVAdapter = new RightLVAdapter();
        leftLVAdapter = new LeftLVAdapter();

        initNetData();
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
    private void initNetData() {
        // 请求数据
        String url = "http://api.liwushuo.com/v2/item_categories/tree";
        GsonRequest<SingleBeans> gsonRequest1 = new GsonRequest<>(SingleBeans.class, url, new Response.Listener<SingleBeans>() {
            @Override
            public void onResponse(SingleBeans response) {
                // 请求成功的方法
                leftLVAdapter.setSingleBeans(response);
                rightLVAdapter.setSingleBeans(response);
                initLayout();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest1);


    }
    private void initLayout() {

        leftLv.setAdapter(leftLVAdapter);
        rightLv.setAdapter(rightLVAdapter);

        leftLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                rightLv.setSelection(i);
                leftLVAdapter.setSelect(i);

            }
        });

        rightLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                leftLv.smoothScrollToPositionFromTop(i - 1, 0);
                leftLVAdapter.setSelect(i);

            }
        });
    }
}
