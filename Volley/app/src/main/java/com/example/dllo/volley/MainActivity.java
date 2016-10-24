package com.example.dllo.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private String url = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=all&pagingAction=up";
    private RequestQueue mRequestQueue;
    private ImageView mainIv;
    private String imgUrl = "http://img.hb.aicdn.com/d1dd8f9615e29498fc2c3be897a8bc0190185b7a1406c-CM6rWC_fw658";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainIv = (ImageView) findViewById(R.id.main_iv);


        // Volley 的使用分为三步 适合小而频发
        // 第一步 创建请求队列
//        RequestQueue requestQueue =
////                Volley.newRequestQueue(this);
//                    VolleySingleton.getInstance().getRequestQueue();
        // 第二步 创建请求
        GsonRequest<TestBean> gsonRequest = new GsonRequest<TestBean>(TestBean.class, url, new Response.Listener<TestBean>() {
            @Override
            public void onResponse(TestBean response) {
                // 请求成功的方法
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

//        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                //请求成功
//                Log.d("MainActivity", response);
//                Gson gson = new Gson();
//                TestBean bean = gson.fromJson(response,TestBean.class);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // 请求失败
//                Log.d("MainActivity", error.getMessage());
//
//            }
//        });

        // 第三行 请求放入请求队列
//        requestQueue.add(stringRequest);
        VolleySingleton.getInstance().addRequest(gsonRequest);

        // 请求图片 ImageLoader
        VolleySingleton.getInstance().getImage(imgUrl,mainIv);
//        ImageLoader imageLoader = new ImageLoader(VolleySingleton.getInstance().getRequestQueue(), new MemoryCache());
//
//        imageLoader.get(imgUrl,imageLoader.getImageListener(mainIv,R.mipmap.ic_launcher,R.mipmap.ic_launcher));

    }
}
