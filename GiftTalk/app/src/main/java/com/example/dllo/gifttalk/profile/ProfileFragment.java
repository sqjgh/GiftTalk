package com.example.dllo.gifttalk.profile;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.secondlevel.secondprofile.SettingActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class ProfileFragment extends BaseFragment implements View.OnClickListener {

    private TabLayout tbl;
    private ImageView setting;

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {
        setting = bindView(R.id.settings_profile);
        tbl = bindView(R.id.tbl_profile);
        tbl.addTab(tbl.newTab().setText("单品"));
        tbl.addTab(tbl.newTab().setText("攻略"));
        tbl.setTabMode(TabLayout.MODE_FIXED);
        tbl.setTabTextColors(Color.DKGRAY, Color.RED);
        tbl.setSelectedTabIndicatorColor(Color.RED);
        setting.setOnClickListener(this);
    }
    @Override
    protected int getLayout() {
        return R.layout.fragment_profile;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.settings_profile:
                Intent intent = new Intent(context, SettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
