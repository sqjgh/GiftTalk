package com.example.dllo.gifttalk.category;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.category.raiderscategory.RaidersFragment;
import com.example.dllo.gifttalk.category.singlecategory.SingleFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class CategoryFragment extends BaseFragment{


    private TabLayout tbl;
    private ViewPager vp;

    @Override
    protected void initData() {
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new RaidersFragment());
        arrayList.add(new SingleFragment());
        CategoryViewPagerAdapter adapter = new CategoryViewPagerAdapter(getChildFragmentManager());
        adapter.setArrayList(arrayList);
        vp.setAdapter(adapter);
        tbl.setupWithViewPager(vp);
        tbl.getTabAt(0).setText("攻略");
        tbl.getTabAt(1).setText("单品");
        tbl.setTabTextColors(Color.DKGRAY, Color.RED);
        tbl.setSelectedTabIndicatorColor(Color.RED);
    }

    @Override
    protected void initView() {
        tbl = bindView(R.id.tbl_title_category);
        vp = bindView(R.id.viewpager_category);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_category;
    }
}
