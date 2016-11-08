package com.example.dllo.gifttalk.gift;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beantools.Values;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.beans.TabLayoutBeansGift;
import com.example.dllo.gifttalk.beantools.GsonRequest;
import com.example.dllo.gifttalk.beantools.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class GiftFragment extends BaseFragment{

    private ViewPager vp;
    private TabLayout tbl;

    @Override
    protected void initData() {
        // 第二步 创建请求
        GsonRequest<TabLayoutBeansGift> gsonRequest = new GsonRequest<>(TabLayoutBeansGift.class, Values.TABLAYOUT_URL_GIFT, new Response.Listener<TabLayoutBeansGift>() {
            @Override
            public void onResponse(TabLayoutBeansGift response) {
                // 请求成功的方法
                // 拿到 tabLayout 对应的ID
                ArrayList<String> arrayList1 = new ArrayList<>();
                for (int i = 0; i < response.getData().getRanks().size(); i++) {
                     arrayList1.add(String.valueOf(response.getData().getRanks().get(i).getId()));
                }
                Values.TABLAYOUT_ID_GIFT = arrayList1;

                ArrayList<Fragment> arrayList = new ArrayList<>();
                arrayList.add(new ForViewPagerGiftFragment());
                GiftViewPagerAdapter adapter = new GiftViewPagerAdapter(getChildFragmentManager());

                adapter.setTabLayoutBeansGift(response);
                vp.setAdapter(adapter);
                tbl.setupWithViewPager(vp);
                tbl.setTabTextColors(Color.DKGRAY, Color.RED);
                tbl.setSelectedTabIndicatorColor(Color.RED);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        // 加入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }

    @Override
    protected void initView() {

        vp = (ViewPager) getView().findViewById(R.id.viewpager_gift);
        tbl = (TabLayout) getView().findViewById(R.id.tbl_gift);


    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_gift;
    }
}
