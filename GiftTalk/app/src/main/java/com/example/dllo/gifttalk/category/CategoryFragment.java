package com.example.dllo.gifttalk.category;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TableLayout;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.category.fragment.Raiders;
import com.example.dllo.gifttalk.category.fragment.Single;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class CategoryFragment extends BaseFragment{


    private TabLayout tbl;
    private ViewPager vp;

    @Override
    protected void initData() {
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new Raiders());
        arrayList.add(new Single());
        CategoryViewPagerAdapter adapter = new CategoryViewPagerAdapter(getChildFragmentManager());
        adapter.setArrayList(arrayList);
        vp.setAdapter(adapter);
        tbl.setupWithViewPager(vp);
        tbl.getTabAt(0).setText("攻略");
        tbl.getTabAt(1).setText("单品");
    }

    @Override
    protected void initView() {
        tbl = bindView(R.id.tbl_title_category);
        vp = bindView(R.id.viewpager_category);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_category;
    }
}