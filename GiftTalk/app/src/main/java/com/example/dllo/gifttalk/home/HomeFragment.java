package com.example.dllo.gifttalk.home;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.Values;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.beantools.GsonRequest;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.home.homebeans.TabLayoutBeans;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class HomeFragment extends BaseFragment{
    private TabLayout tbl;
    private ViewPager vp;
    private ViewPagerAdapter adapter;


    // 各种findViewById
    @Override
    protected void initView() {
        tbl = bindView(R.id.tbl_home);
        vp = bindView(R.id.viewpager_home);
        adapter = new ViewPagerAdapter(getChildFragmentManager());
    }

    @Override
    protected void initData() {
        initTablayout();
    }



    // 绑定进入布局
    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }
    public void initTablayout(){
        GsonRequest<TabLayoutBeans> gsonRequest = new GsonRequest<>(TabLayoutBeans.class, Values.TABLAYOUT_URL_HOME, new Response.Listener<TabLayoutBeans>() {
            @Override
            public void onResponse(TabLayoutBeans response) {
                // 请求成功的方法
                ArrayList<String> str = new ArrayList<>();
                for (int i = 0; i < response.getData().getChannels().size(); i++) {
                    str.add(String.valueOf(response.getData().getChannels().get(i).getId()));
                }
                Values.TABLAYOUT_ID_HOME = str;
                adapter.setTabLayoutBeans(response);
                vp.setAdapter(adapter);
                tbl.setupWithViewPager(vp);
                tbl.setTabMode(TabLayout.MODE_SCROLLABLE);
                tbl.setTabTextColors(Color.DKGRAY, Color.RED);
                tbl.setSelectedTabIndicatorColor(Color.RED);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance().addRequest(gsonRequest);
    };
}
