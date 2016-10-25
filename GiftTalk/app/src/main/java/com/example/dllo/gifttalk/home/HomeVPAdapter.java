package com.example.dllo.gifttalk.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class HomeVPAdapter extends FragmentPagerAdapter{
    ArrayList<Fragment> arrayList;
    public static final String[] tabTitle = new String[]{"精选","关注","送女票","海淘","科技范","美食","送基友","送爸妈","送同事","送宝贝","设计感","创意生活","文艺风","奇葩搞怪","数码","萌萌哒"};
    public HomeVPAdapter(FragmentManager fm, ArrayList<Fragment> arrayList) {
        super(fm);
        this.arrayList = arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
