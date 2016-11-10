package com.example.dllo.gifttalk.secondlevel.secondhome;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;

/**
 * Created by dllo on 16/11/3.
 */
public class WebViewActivity extends BaseActivity {


    private WebView wv;
    private ImageView imageView;

    @Override
    protected void initData() {
        Intent intent = getIntent();
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

        wv.loadUrl(intent.getStringExtra("url"));


    }


    @Override
    protected void initViews() {
        wv = (WebView) findViewById(R.id.webview_secondlevel);
        imageView = bindView(R.id.loading_anim_webview_home);
    }

    @Override
    protected int getLayout() {
        return R.layout.second_normal_home;
    }


}
