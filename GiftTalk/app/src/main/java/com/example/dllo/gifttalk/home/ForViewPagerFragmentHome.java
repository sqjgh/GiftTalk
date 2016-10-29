package com.example.dllo.gifttalk.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.Values;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.home.beantools.GsonRequest;
import com.example.dllo.gifttalk.home.beantools.VolleySingleton;
import com.example.dllo.gifttalk.home.homebeans.RollViewBeans;
import com.example.dllo.gifttalk.home.homebeans.TabLayoutItemBeans;
import com.example.dllo.gifttalk.home.rollviewpager.RollViewPagerAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * Created by dllo on 16/10/25.
 */
class ForViewPagerFragmentHome extends BaseFragment {

    public static String HOME_KEY = "pos";
    private TextView txt;
    private int type;
    private FirstListViewAdapter firstListViewAdapter;
    private NormalListViewAdapter normalLVAdapter;
    private ListView listView;
    private View v;

    @Override
    protected void initData() {
        if (getArguments() != null) {
            type = getArguments().getInt(HOME_KEY);
        }
        // 判断进入的是哪个页面
        init();
    }

    @Override
    protected void initView() {
        txt = bindView(R.id.tab_txt);
        firstListViewAdapter = new FirstListViewAdapter(getActivity());
        normalLVAdapter = new NormalListViewAdapter(getActivity());
        listView = bindView(R.id.listview_vp_home);

    }

    @Override
    protected int getLayout() {
        return R.layout.listview_home;
    }

    public static ForViewPagerFragmentHome getInstance(int pos) {
        ForViewPagerFragmentHome fragment = new ForViewPagerFragmentHome();
        Bundle bundle = new Bundle();
        bundle.putInt(HOME_KEY, pos);
        fragment.setArguments(bundle);
        return fragment;
    }

    protected void init() {

        switch (type) {
            case 0:

                // 轮播图
                //创建请求
                GsonRequest<RollViewBeans> gsonRequest = new GsonRequest<>(RollViewBeans.class, Values.ROLLVIEW_URL, new Response.Listener<RollViewBeans>() {
                    @Override
                    public void onResponse(RollViewBeans response) {
                        // 请求成功的方法
                        // 添加头布局轮播图
                        // ViewGroup 不对
                        v = LayoutInflater.from(getActivity()).inflate(R.layout.rollviewpager_home, null);
                        RollPagerView rollPagerView = (RollPagerView) v.findViewById(R.id.rollvp_home);
                        rollPagerView.setHintView(new ColorPointHintView(getActivity(), Color.RED, Color.WHITE));
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
                break;
            case 1:
                netData(1);
                break;
            case 2:
                netData(2);
                break;
            case 3:
                netData(3);
                break;
            case 4:
                netData(4);
                break;
            case 5:
                netData(5);
                break;
            case 6:
                netData(6);
                break;
            case 7:
                netData(7);
                break;
            case 8:
                netData(8);
                break;
            case 9:
                netData(9);
                break;
            case 10:
                netData(10);
                break;
            case 11:
                netData(11);
                break;
            case 12:
                netData(12);
                break;
            case 13:
                netData(13);
                break;
            case 14:
                netData(14);
                break;
            case 15:
                netData(15);
                break;
            case 16:
                netData(16);
                break;
            case 17:
                netData(17);
                break;
            case 18:
                netData(18);
                break;
            case 19:
                netData(19);
                break;
            case 20:
                netData(20);
                break;
        }


    }
    public void firstNetData(){
        // 请求"精选"正常数据
        String url1 = Values.TABLAYOUT_ITEMSFRONT_HOME + Values.TABLAYOUT_ID_HOME.get(0) + Values.TABLAYOUT_ITEMSBACK_HOME;
        GsonRequest<TabLayoutItemBeans> gsonRequest1 = new GsonRequest<>(TabLayoutItemBeans.class, url1, new Response.Listener<TabLayoutItemBeans>() {
            @Override
            public void onResponse(TabLayoutItemBeans response) {
                // 请求成功的方法
                firstListViewAdapter.setTabLayoutItemBeans(response);
                listView.addHeaderView(v);
                listView.setAdapter(firstListViewAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest1);
    }
    public void netData(int whatType){
        // 请求正常数据
        String url1 = Values.TABLAYOUT_ITEMSFRONT_HOME + Values.TABLAYOUT_ID_HOME.get(whatType) + Values.TABLAYOUT_ITEMSBACK_HOME;
        GsonRequest<TabLayoutItemBeans> gsonRequest = new GsonRequest<>(TabLayoutItemBeans.class, url1, new Response.Listener<TabLayoutItemBeans>() {
            @Override
            public void onResponse(TabLayoutItemBeans response) {
                // 请求成功的方法
                firstListViewAdapter.setTabLayoutItemBeans(response);
                listView.setAdapter(firstListViewAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }

}