package com.example.dllo.gifttalk.home;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;

/**
 * Created by dllo on 16/10/21.
 */
public class HomeFragment extends BaseFragment{
    private TabLayout tbl;
    private ViewPager vp;


    @Override
    protected void initData() {

    }

    // 各种findViewById
    @Override
    protected void initView() {

        tbl = bindView(R.id.tbl_home);
        vp = bindView(R.id.viewpager_home);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        vp.setAdapter(adapter);
        tbl.setupWithViewPager(vp);
        tbl.setTabMode(TabLayout.MODE_SCROLLABLE);
        tbl.setTabTextColors(Color.DKGRAY, Color.RED);
        tbl.setSelectedTabIndicatorColor(Color.RED);
    }

    // 绑定进入布局
    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }
}
