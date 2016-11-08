package com.example.dllo.gifttalk.category;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.category.raiderscategory.RaidersFragment;
import com.example.dllo.gifttalk.category.singlecategory.SingleFragment;
import com.example.dllo.gifttalk.secondlevel.secondhome.SearchSecondActivity;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class CategoryFragment extends BaseFragment{


    private TabLayout tbl;
    private ViewPager vp;
    private RelativeLayout rl;

    @Override
    protected void initData() {
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new RaidersFragment());
        arrayList.add(new SingleFragment());
        CategoryViewPagerAdapter adapter = new CategoryViewPagerAdapter(getChildFragmentManager());
        adapter.setArrayList(arrayList);
        vp.setAdapter(adapter);
        tbl.setupWithViewPager(vp);
        tbl.getTabAt(0).setText("攻略");
        tbl.getTabAt(1).setText("单品");
        tbl.setTabTextColors(Color.DKGRAY, Color.RED);
        tbl.setSelectedTabIndicatorColor(Color.RED);
    }

    @Override
    protected void initView() {
        tbl = bindView(R.id.tbl_title_category);
        vp = bindView(R.id.viewpager_category);
        rl = bindView(R.id.rl_search_second_category);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SearchSecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_category;
    }
}
