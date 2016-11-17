package com.example.dllo.gifttalk.secondlevel.secondhome;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;
import com.example.dllo.gifttalk.secondlevel.secondprofile.UserBean;
import com.example.dllo.gifttalk.tools.Values;

import java.util.ArrayList;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by dllo on 16/11/3.
 */
public class WebViewActivity extends BaseActivity {


    private WebView wv;
    private ImageView imageView;
    private ImageView follow;
    private Intent intent;
    private String url;
    @Override
    protected void initData() {
        // 收藏点击
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 更新收藏
                updateCollect();
            }
        });


        intent = getIntent();
        wv.getSettings().
                setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                imageView.setVisibility(View.GONE);
            }
        });
        url = intent.getStringExtra("url");
        wv.loadUrl(url);

//        //收藏
//        initFollow(){
//
//        }
    }


    @Override
    protected void initViews() {
        wv = (WebView) findViewById(R.id.webview_secondlevel);
        imageView = bindView(R.id.loading_anim_webview_home);
        follow = bindView(R.id.follow_webview);
    }

    @Override
    protected int getLayout() {
        return R.layout.second_normal_home;
    }


    private void updateCollect(){
        // 检测是否登录状态
        UserBean userBean = UserBean.getCurrentUser(UserBean.class);
        if (userBean != null) {
            if (Values.COLLECT_LIST == null){
                if (userBean.getCollect() == null){
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(url);
                    Values.COLLECT_LIST = arrayList;
                }else {
                    Values.COLLECT_LIST = userBean.getCollect();
                }
            }else {
                Values.COLLECT_LIST.add(url);
            }
            userBean.setCollect(Values.COLLECT_LIST);
            // 更新数据
            userBean.update(userBean.getObjectId(), new UpdateListener() {
                @Override
                public void done(BmobException e) {
                    if(e==null){
                        Log.d("F11111", intent.getStringExtra("url"));
                    }else{
//                    Toast.makeText(SettingActivity.this, "设置数据同步失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
