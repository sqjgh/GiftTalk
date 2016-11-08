package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dllo.gifttalk.beans.TabLayoutItemBeansGift;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/4.
 */
public class VPSecondGiftAdapter extends FragmentPagerAdapter{
    private static TabLayoutItemBeansGift tabLayoutItemBeansGift;
    private static int position;
    ArrayList<Fragment> fragments;

    String str[] = {"单品", "详情", "评论"};

    public static int getPosition() {
        return position;
    }

    public static TabLayoutItemBeansGift getTabLayoutItemBeansGift() {
        return tabLayoutItemBeansGift;
    }

    public static void setTabLayoutItemBeansGift(TabLayoutItemBeansGift tabLayoutItemBeansGift,int position) {
        VPSecondGiftAdapter.tabLayoutItemBeansGift = tabLayoutItemBeansGift;
        VPSecondGiftAdapter.position = position;
    }

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
