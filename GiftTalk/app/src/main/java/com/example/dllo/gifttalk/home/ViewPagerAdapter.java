package com.example.dllo.gifttalk.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.util.SparseArray;

/**
 * Created by dllo on 16/10/25.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{
    SparseArray<Fragment> fragmentSparseArray;
    public static final String[] tabTitle = new String[]{"精选","关注","送女票","海淘","科技范","美食","送基友","送爸妈","送同事","送宝贝","设计感","创意生活","文艺风","奇葩搞怪","数码","萌萌哒"};
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentSparseArray = new SparseArray<>();
        Log.d("GiftViewPagerAdapter", "GiftViewPagerAdapter");
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentSparseArray.get(position) == null){
            fragmentSparseArray.put(position, ForViewPagerFragment.getInstance(position));
        }
        Log.d("GiftViewPagerAdapter", "getItem");
        return fragmentSparseArray.get(position);
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("GiftViewPagerAdapter", "getPageTitle");
        return tabTitle[position];
    }
}
