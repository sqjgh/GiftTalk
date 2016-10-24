package com.example.dllo.gifttalk.gift;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.gift.fragments.EveryDay;
import com.example.dllo.gifttalk.gift.fragments.NewStar;
import com.example.dllo.gifttalk.gift.fragments.Original;
import com.example.dllo.gifttalk.gift.fragments.TopOneHundred;

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
        arrayList.add(new EveryDay());
        arrayList.add(new TopOneHundred());
        arrayList.add(new Original());
        arrayList.add(new NewStar());
        GiftViewPagerAdapter adapter = new GiftViewPagerAdapter(getChildFragmentManager());
        adapter.setFragmentArrayList(arrayList);
        vp.setAdapter(adapter);
        tbl.setupWithViewPager(vp);
        tbl.getTabAt(0).setText("每日推荐");
        tbl.getTabAt(1).setText("TOP100");
        tbl.getTabAt(2).setText("独立原创");
        tbl.getTabAt(3).setText("新星榜");
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
