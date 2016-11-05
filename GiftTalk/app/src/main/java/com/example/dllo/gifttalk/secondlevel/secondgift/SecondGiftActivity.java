package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;
import com.example.dllo.gifttalk.gift.giftbeans.TabLayoutItemBeansGift;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/4.
 */
public class SecondGiftActivity extends BaseActivity {

    private ViewPager vp;
    private TabLayout tbl;
    TabLayoutItemBeansGift tabLayoutItemBeansGift;
    private VPSecondGiftAdapter vpAdapterSecondGift;
    private String position;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        position = intent.getStringExtra("position");

        tabLayoutItemBeansGift = (TabLayoutItemBeansGift) intent.getSerializableExtra("tabLayoutItemBeansGift");
        // 进入三个Fragment加载
        initFragments();


    }


    @Override
    protected void initViews() {
        vp = bindView(R.id.vp_second_gift);
        tbl = bindView(R.id.tbl_second_gift);

    }

    @Override
    protected int getLayout() {
        return R.layout.second_gift;
    }

    private void initFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SingleSecondGiftFragment());
        fragments.add(new MoreSecondGiftFragment());
        fragments.add(new CommentSecondGiftFragment());
        vpAdapterSecondGift = new VPSecondGiftAdapter(getSupportFragmentManager());
        vpAdapterSecondGift.setFragments(fragments);

        vpAdapterSecondGift.setTabLayoutItemBeansGift(tabLayoutItemBeansGift,Integer.valueOf(position));
        vp.setAdapter(vpAdapterSecondGift);
        tbl.setTabTextColors(Color.DKGRAY, Color.WHITE);
        tbl.setSelectedTabIndicatorColor(Color.WHITE);
        tbl.setupWithViewPager(vp);
    }


}
