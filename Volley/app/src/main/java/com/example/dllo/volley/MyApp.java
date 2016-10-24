package com.example.dllo.volley;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/10/24.
 * !!!!!写完   MyApp   一定要注册!!!!!!
 * 与界面无关都可使用  inflater不可用
 */
public class MyApp extends Application{
    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getContext(){
        return sContext;
    }
}
