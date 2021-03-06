package com.example.dllo.gifttalk.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by dllo on 16/10/21.
 */
public abstract class BaseActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // 1 绑定布局
        setContentView(getLayout());
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
//透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        //2 初始化组件 各种findViewById
        initViews();
        // 3 初始化数据
        initData();
    }

    protected abstract void initData();

    protected abstract void initViews();

    protected abstract int getLayout();

    protected <T extends View> T bindView(int id){
        return (T) findViewById(id);
    }

    // 设置监听事件 ... 可变数量的参数
    protected void setClick(View.OnClickListener clickListener,View ...views){
        for (View view :views){
            view.setOnClickListener(clickListener);
        }
    }
}
