package com.example.dllo.gifttalk.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.example.dllo.gifttalk.home.homebeans.TabLayoutBeans;

/**
 * Created by dllo on 16/10/25.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{
   private SparseArray<Fragment> fragmentSparseArray;
    private TabLayoutBeans tabLayoutBeans;


    public void setTabLayoutBeans(TabLayoutBeans tabLayoutBeans) {
        this.tabLayoutBeans = tabLayoutBeans;
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentSparseArray = new SparseArray<>();
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentSparseArray.get(position) == null){
            fragmentSparseArray.put(position, ForViewPagerHomeFragment.getInstance(position));
        }
        return fragmentSparseArray.get(position);
    }

    @Override
    public int getCount() {
        return tabLayoutBeans.getData().getChannels().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabLayoutBeans.getData().getChannels().get(position).getName();
    }
}
