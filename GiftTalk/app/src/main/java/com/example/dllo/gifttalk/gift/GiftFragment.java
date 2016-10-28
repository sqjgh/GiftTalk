package com.example.dllo.gifttalk.gift;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.gift.fragments.EveryDayFragment;
import com.example.dllo.gifttalk.gift.fragments.NewStarFragment;
import com.example.dllo.gifttalk.gift.fragments.OriginalFragment;
import com.example.dllo.gifttalk.gift.fragments.TopOneHundredFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class GiftFragment extends BaseFragment{

    private ViewPager vp;
    private TabLayout tbl;

    @Override
    protected void initData() {
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new EveryDayFragment());
        arrayList.add(new TopOneHundredFragment());
        arrayList.add(new OriginalFragment());
        arrayList.add(new NewStarFragment());
        GiftViewPagerAdapter adapter = new GiftViewPagerAdapter(getChildFragmentManager());
        adapter.setFragmentArrayList(arrayList);
        vp.setAdapter(adapter);
        tbl.setupWithViewPager(vp);
        tbl.setTabTextColors(Color.DKGRAY, Color.RED);
        tbl.setSelectedTabIndicatorColor(Color.RED);
    }

    @Override
    protected void initView() {
        vp = (ViewPager) getActivity().findViewById(R.id.viewpager_gift);
        tbl = (TabLayout) getActivity().findViewById(R.id.tbl_gift);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_gift;
    }
}
