package com.example.dllo.gifttalk.secondlevel;

import android.content.Intent;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;

/**
 * Created by dllo on 16/11/3.
 */
public class WebViewClass extends BaseActivity {


    private WebView wv;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        wv.getSettings().
                setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(intent.getStringExtra("url"));
        Log.d("F111", intent.getStringExtra("url"));
    }


    @Override
    protected void initViews() {
        wv = (WebView) findViewById(R.id.webview_secondlevel);
    }

    @Override
    protected int getLayout() {
        return R.layout.webview;
    }


}
