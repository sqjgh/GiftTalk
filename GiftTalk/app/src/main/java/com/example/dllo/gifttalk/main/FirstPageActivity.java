package com.example.dllo.gifttalk.main;

import android.content.Intent;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;

/**
 * Created by dllo on 16/11/14.
 */
public class FirstPageActivity extends BaseActivity{
    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    Intent intent = new Intent(FirstPageActivity.this,MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayout() {
        return R.layout.firstpage;
    }
}
