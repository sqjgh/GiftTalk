package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/4.
 */
public class VPSecondGiftAdapter extends FragmentPagerAdapter{
    ArrayList<Fragment> fragments;
    String str[] = {"单品", "详情", "评论"};

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    public VPSecondGiftAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
