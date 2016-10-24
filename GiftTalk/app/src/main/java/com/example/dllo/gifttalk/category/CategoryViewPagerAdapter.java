package com.example.dllo.gifttalk.category;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 */
public class CategoryViewPagerAdapter extends FragmentPagerAdapter{
    ArrayList<Fragment> arrayList;

    public void setArrayList(ArrayList<Fragment> arrayList) {
        this.arrayList = arrayList;
    }

    public CategoryViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }
}
