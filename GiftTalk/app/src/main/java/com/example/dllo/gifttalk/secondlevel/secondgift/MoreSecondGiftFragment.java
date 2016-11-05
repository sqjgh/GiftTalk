package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.gift.giftbeans.TabLayoutItemBeansGift;

/**
 * Created by dllo on 16/11/4.
 */
public class MoreSecondGiftFragment extends BaseFragment{

    private WebView wv;
    private TabLayoutItemBeansGift beansGift;
    private int position;

    @Override
    protected void initData() {
        beansGift = VPSecondGiftAdapter.getTabLayoutItemBeansGift();
        position = VPSecondGiftAdapter.getPosition();

        wv.getSettings().setJavaScriptEnabled(false);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        });

        wv.loadUrl(beansGift.getData().getItems().get(position).getUrl());
        Log.d("F111", beansGift.getData().getItems().get(position).getUrl());
    }

    @Override
    protected void initView() {
        wv = (WebView) getActivity().findViewById(R.id.wv_second_more_gift);

    }

    @Override
    protected int getLayout() {
        return R.layout.second_more_gift;
    }
}
