package com.example.dllo.gifttalk.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.util.SparseArray;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class HomeVPAdapter extends FragmentPagerAdapter{
    SparseArray<Fragment> fragmentSparseArray;
    public static final String[] tabTitle = new String[]{"精选","关注","送女票","海淘","科技范","美食","送基友","送爸妈","送同事","送宝贝","设计感","创意生活","文艺风","奇葩搞怪","数码","萌萌哒"};
    public HomeVPAdapter(FragmentManager fm) {
        super(fm);
        fragmentSparseArray = new SparseArray<>();
        Log.d("HomeVPAdapter", "HomeVPAdapter");
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentSparseArray.get(position) == null){
            fragmentSparseArray.put(position, FragmentForVP.getInstance(position));
        }
        Log.d("HomeVPAdapter", "getItem");
        return fragmentSparseArray.get(position);
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("HomeVPAdapter", "getPageTitle");
        return tabTitle[position];
    }
}
