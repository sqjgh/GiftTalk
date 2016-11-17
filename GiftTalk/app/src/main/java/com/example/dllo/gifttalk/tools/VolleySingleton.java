package com.example.dllo.gifttalk.tools;

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
        imageLoader.get(url,imageLoader.getImageListener(imageView, R.mipmap.abc_list_divider_holo_light,R.mipmap.abc_list_divider_holo_light));
    }


    // 获得  RequestQueue
    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
    public <T> void addRequest(Request<T> request){
        mRequestQueue.add(request);
    }
    // 取消所有tag相同的网络请求
    public void fun(Object tag){

        mRequestQueue.cancelAll(tag);
    }
}
