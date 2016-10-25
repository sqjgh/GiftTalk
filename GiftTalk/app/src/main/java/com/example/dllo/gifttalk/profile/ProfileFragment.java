package com.example.dllo.gifttalk.profile;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TableLayout;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;

/**
 * Created by dllo on 16/10/21.
 */
public class ProfileFragment extends BaseFragment{

    private TabLayout tbl;

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {
        tbl = bindView(R.id.tbl_profile);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_profile;
    }
}
