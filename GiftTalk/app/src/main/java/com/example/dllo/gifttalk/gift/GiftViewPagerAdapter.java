package com.example.dllo.gifttalk.gift;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.example.dllo.gifttalk.beans.TabLayoutBeansGift;

/**
 * Created by dllo on 16/10/24.
 */
public class GiftViewPagerAdapter extends FragmentPagerAdapter{
    SparseArray<Fragment> fragmentArrayList;
    private TabLayoutBeansGift tabLayoutBeansGift;

    public void setTabLayoutBeansGift(TabLayoutBeansGift tabLayoutBeansGift) {
        this.tabLayoutBeansGift = tabLayoutBeansGift;
    }

    public GiftViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentArrayList = new SparseArray<>();
    }

    @Override
    public Fragment getItem(int position) {
        //更好的方法 有的页面用户可能不点 创建太多没意义
        // 用户滑到了才创建
        if (fragmentArrayList.get(position) == null){
            fragmentArrayList.put(position, ForViewPagerGiftFragment.getInstance(position));
        }
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return tabLayoutBeansGift == null ? 0 : tabLayoutBeansGift.getData().getRanks().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabLayoutBeansGift.getData().getRanks().get(position).getName();

    }
}
