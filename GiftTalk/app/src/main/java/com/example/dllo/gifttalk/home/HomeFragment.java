package com.example.dllo.gifttalk.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class HomeFragment extends BaseFragment{
    public static final String[] tabTitle = new String[]{"精选","关注","送女票","海淘","科技范","美食","送基友","送爸妈","送同事","送宝贝","设计感","创意生活","文艺风","奇葩搞怪","数码","萌萌哒"};
    private TabLayout tbl;
    private ViewPager vp;

    @Override
    protected void initData() {

    }

    // 各种findViewById
    @Override
    protected void initView() {
        tbl = bindView(R.id.tbl_home);
        vp = bindView(R.id.viewpager_home);
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < tabTitle.length; i++) {
            fragments.add(FragmentForVP.newInstance(i));
        }
        HomeVPAdapter adapter = new HomeVPAdapter(getChildFragmentManager(),fragments);
        vp.setAdapter(adapter);
        tbl.setupWithViewPager(vp);
        tbl.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    // 绑定进入布局
    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }
}
