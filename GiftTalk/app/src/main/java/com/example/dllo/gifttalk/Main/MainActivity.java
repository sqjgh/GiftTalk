package com.example.dllo.gifttalk.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.category.CategoryFragment;
import com.example.dllo.gifttalk.gift.GiftFragment;
import com.example.dllo.gifttalk.home.HomeFragment;
import com.example.dllo.gifttalk.profile.ProfileFragment;

import java.util.ArrayList;

import cn.bmob.v3.Bmob;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton homeBtn;
    private RadioButton giftBtn;
    private RadioButton categoryBtn;
    private RadioButton profileBtn;
    private MainFragmentAdapter adapter;
    private BaseFragment currentFragment;
    private FragmentManager manager;
    private boolean QUIT = false;

    // 进入初始数据
    @Override
    protected void initData() {
        Bmob.initialize(this, "c8c93d41a06406c0cb98e46605abfeb5");
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new HomeFragment());
        arrayList.add(new GiftFragment());
        arrayList.add(new CategoryFragment());
        arrayList.add(new ProfileFragment());
        adapter = new MainFragmentAdapter(getSupportFragmentManager());
        adapter.setFragmentArrayList(arrayList);
    }

    // 绑定布局   各种findViewById
    @Override
    protected void initViews() {
        homeBtn = (RadioButton) findViewById(R.id.home_main);
        giftBtn = (RadioButton) findViewById(R.id.gift_main);
        categoryBtn = (RadioButton) findViewById(R.id.category_main);
        profileBtn = (RadioButton) findViewById(R.id.profile_main);
        setClick(this, homeBtn, giftBtn, categoryBtn, profileBtn);
        // 进入显示首页 Fragment
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.linearlayout_main, new HomeFragment());
        transaction.commit();
    }

    // 进入绑定布局
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    // 点击切换界面
    @Override
    public void onClick(View view) {
//        manager = getSupportFragmentManager();
        switch (view.getId()) {
            case R.id.home_main:
                if(currentFragment != null && currentFragment instanceof HomeFragment){
                    return;
                }
                currentFragment = new HomeFragment();
//                transaction.replace(R.id.linearlayout_main, new HomeFragment());

                break;
            case R.id.gift_main:
                if(currentFragment != null && currentFragment instanceof GiftFragment){
                    return;
                }
                currentFragment = new GiftFragment();
//                transaction.replace(R.id.linearlayout_main, new GiftFragment());
                break;
            case R.id.category_main:
                if(currentFragment != null && currentFragment instanceof CategoryFragment){
                    return;
                }
                currentFragment = new CategoryFragment();
//                transaction.replace(R.id.linearlayout_main, new CategoryFragment());
                break;
            case R.id.profile_main:
                if(currentFragment != null && currentFragment instanceof ProfileFragment){
                    return;
                }
                currentFragment = new ProfileFragment();
                break;
        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.linearlayout_main, currentFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (QUIT == true){
            super.onBackPressed();
        }else {QUIT = true;
            Toast.makeText(MainActivity.this, " 再按一次退出 『 礼物说 』 ", Toast.LENGTH_SHORT).show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        QUIT = false;
                        Log.d("11111111111", "QUIT = false;");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();

        }

    }
}
