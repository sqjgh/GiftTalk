package com.example.dllo.gifttalk.profile;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.secondlevel.secondprofile.FollowActivity;
import com.example.dllo.gifttalk.secondlevel.secondprofile.LoginActivity;
import com.example.dllo.gifttalk.secondlevel.secondprofile.SettingActivity;
import com.example.dllo.gifttalk.tools.Values;

/**
 * Created by dllo on 16/10/21.
 */
public class ProfileFragment extends BaseFragment implements View.OnClickListener {

    private TabLayout tbl;
    private ImageView setting;
    private ImageView avatarBoy;
    private LinearLayout follow;
    private TextView id;

    @Override
    public void onResume() {
        super.onResume();
        if (Values.USER_SEX != null){
            if (Values.USER_SEX.equals("girl")){
                avatarBoy.setImageResource(R.mipmap.me_avatar_girl);
            }else {
                avatarBoy.setImageResource(R.mipmap.me_avatar_boy);
            }
        }
    }

    @Override
    protected void initData() {
        if (Values.USER_NAME != null){
            id.setText(Values.USER_NAME);
        }
    }


    @Override
    protected void initView() {
        setting = bindView(R.id.settings_profile);
        tbl = bindView(R.id.tbl_profile);
        avatarBoy = bindView(R.id.avatar_boy_profile);
        tbl.addTab(tbl.newTab().setText("单品"));
        tbl.addTab(tbl.newTab().setText("攻略"));
        tbl.setTabMode(TabLayout.MODE_FIXED);
        tbl.setTabTextColors(Color.DKGRAY, Color.RED);
        tbl.setSelectedTabIndicatorColor(Color.RED);
        setting.setOnClickListener(this);
        avatarBoy.setOnClickListener(this);
        follow = bindView(R.id.follow_profile);
        follow.setOnClickListener(this);
        id = bindView(R.id.id_profile);

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
            case R.id.avatar_boy_profile:
                Intent intent1 = new Intent(context, LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.follow_profile:
                Intent intent2 = new Intent(context,FollowActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
