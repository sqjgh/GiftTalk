package com.example.dllo.gifttalk.secondlevel.secondprofile;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;

/**
 * Created by dllo on 16/11/10.
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back;

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {
        back = bindView(R.id.back_setting);
        onItemClickSetting();
    }

    private void onItemClickSetting() {
        back.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.setting;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.back_setting:
                finish();
                break;
        }
    }
}
