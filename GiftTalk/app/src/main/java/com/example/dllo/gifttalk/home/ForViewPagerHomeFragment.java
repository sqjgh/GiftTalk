package com.example.dllo.gifttalk.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.beans.RollViewBeans;
import com.example.dllo.gifttalk.beans.TabLayoutItemBeans;
import com.example.dllo.gifttalk.beantools.GsonRequest;
import com.example.dllo.gifttalk.beantools.Values;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.home.rollviewpager.RollViewPagerAdapter;
import com.example.dllo.gifttalk.secondlevel.WebViewActivity;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * Created by dllo on 16/10/25.
 */
class ForViewPagerHomeFragment extends BaseFragment implements ClickListViewHome {

    public static String HOME_KEY = "pos";
    public  int type;
    private FirstListViewAdapter firstListViewAdapter;
    private ListView listView;
    private View v;
    private ImageView imageView;
    private SwipeRefreshLayout refresh;
    private int a;

    @Override
    protected void initData() {
        a = 0;
        if (getArguments() != null) {
            type = getArguments().getInt(HOME_KEY);
        }
        firstListViewAdapter = new FirstListViewAdapter(getActivity());
        // 判断进入的是哪个页面
        initPage(type);
        // 下拉刷新 上拉加载监听
        initListener();
    }

    private void initListener() {
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (type == 0){
                    a = 1;
                    initPage(type);
                }else {
                    netData(type);
                }
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                Log.d("F123", "i:" + i);
            }
        });


    }

    @Override
    protected void initView() {
        listView = bindView(R.id.listview_vp_home);
        imageView = bindView(R.id.loading_anim_home);
        refresh = bindView(R.id.refresh_home);
    }

    @Override
    protected int getLayout() {
        return R.layout.lv_home;
    }

    public static ForViewPagerHomeFragment getInstance(int pos) {
        ForViewPagerHomeFragment fragment = new ForViewPagerHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(HOME_KEY, pos);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void initPage(int type) {
        if (type == 0){
            // 轮播图
            //创建请求
            GsonRequest<RollViewBeans> gsonRequest = new GsonRequest<>(RollViewBeans.class, Values.ROLLVIEW_URL, new Response.Listener<RollViewBeans>() {
                @Override
                public void onResponse(RollViewBeans response) {
                    // 请求成功的方法
                    // 添加头布局轮播图
                    v = LayoutInflater.from(context).inflate(R.layout.rollviewpager_home, null);
                    RollPagerView rollPagerView = (RollPagerView) v.findViewById(R.id.rollvp_home);
                    rollPagerView.setHintView(new ColorPointHintView(context, Color.RED, Color.WHITE));
                    RollViewPagerAdapter adapter = new RollViewPagerAdapter(rollPagerView);
                    adapter.setRollViewBeans(response);
                    rollPagerView.setAdapter(adapter);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            //请求放入请求队列
            VolleySingleton.getInstance().addRequest(gsonRequest);
            firstNetData();
        }else {
            netData(type);
        }
    }

    public void firstNetData() {
        // 请求"精选"正常数据
        String url1 = Values.TABLAYOUT_ITEMSFRONT_HOME + Values.TABLAYOUT_ID_HOME.get(0) + Values.TABLAYOUT_ITEMSBACK_HOME;
        GsonRequest<TabLayoutItemBeans> gsonRequest1 = new GsonRequest<>(TabLayoutItemBeans.class, url1, new Response.Listener<TabLayoutItemBeans>() {
            @Override
            public void onResponse(TabLayoutItemBeans response) {
                // 请求成功的方法
                imageView.setVisibility(View.GONE);
                firstListViewAdapter.setTabLayoutItemBeans(response);
                // 接口指针指向
                firstListViewAdapter.setClickListViewHome(ForViewPagerHomeFragment.this);
                if (a == 0){
                    listView.addHeaderView(v);
                }

                listView.setAdapter(firstListViewAdapter);  // TODO 空指针

                refresh.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest1);
    }

    public void netData(int whatType) {
        // 请求正常数据
        String url1 = Values.TABLAYOUT_ITEMSFRONT_HOME + Values.TABLAYOUT_ID_HOME.get(whatType) + Values.TABLAYOUT_ITEMSBACK_HOME;
        GsonRequest<TabLayoutItemBeans> gsonRequest = new GsonRequest<>(TabLayoutItemBeans.class, url1, new Response.Listener<TabLayoutItemBeans>() {
            @Override
            public void onResponse(TabLayoutItemBeans response) {
                // 请求成功的方法
                imageView.setVisibility(View.GONE);
                firstListViewAdapter.setTabLayoutItemBeans(response);
                firstListViewAdapter.setClickListViewHome(ForViewPagerHomeFragment.this);
                listView.setAdapter(firstListViewAdapter);
                refresh.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }
    // 点击item跳转到详情页面 接口实现方法
    @Override
    public void onClick(String url) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }


}