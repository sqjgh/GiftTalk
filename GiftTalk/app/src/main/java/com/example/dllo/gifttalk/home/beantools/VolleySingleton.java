package com.example.dllo.gifttalk.home.beantools;

import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.dllo.gifttalk.R;

/**
 * Created by dllo on 16/10/24.
 */

public class VolleySingleton {
    // 用来请求图片的
    private ImageLoader imageLoader;
    // static修饰对象可以类名调用
    private static VolleySingleton volleySingleton;
    private RequestQueue mRequestQueue;
    private VolleySingleton(){
        mRequestQueue = Volley.newRequestQueue(MyApp.getContext());
        // 初始化 ImageLoader
        imageLoader = new ImageLoader(mRequestQueue, new MemoryCache());
    }

    public static VolleySingleton getInstance(){
        if (volleySingleton == null){
            synchronized (VolleySingleton.class){
                if (volleySingleton == null){
                    volleySingleton = new VolleySingleton();
                }
            }
        }
        return volleySingleton;
    }

    // 请求图片
    public void getImage(String url, ImageView imageView){
        imageLoader.get(url,imageLoader.getImageListener(imageView, R.mipmap.ic_launcher,R.mipmap.ic_launcher));
    }
    // 获得  RequestQueue
    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
    public <T> void addRequest(Request<T> request){
        mRequestQueue.add(request);
    }
}
