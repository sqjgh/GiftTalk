package com.example.dllo.gifttalk.gift;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.beantools.Values;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.beantools.GsonRequest;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.gift.giftbeans.TabLayoutItemBeansGift;

/**
 * Created by dllo on 16/10/24.
 */
public class ForViewPagerGiftFragment extends BaseFragment {

    private RecyclerView rv;
    private GiftRecyclerViewAdapter giftRecyclerViewAdapter;
    private static final String GIFT_KEY = "pos";
    private int type;
    private RecyclerViewHeader header;
    private ImageView headImage;


    public static ForViewPagerGiftFragment getInstance(int pos) {
        ForViewPagerGiftFragment forViewPagerFragmentGift = new ForViewPagerGiftFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(GIFT_KEY, pos);
        forViewPagerFragmentGift.setArguments(bundle);
        return forViewPagerFragmentGift;
    }

    @Override
    protected void initData() {
        initFragmentChose();
    }

    @Override
    protected void initView() {
        rv = bindView(R.id.recyclerview_gift);
        header = bindView(R.id.header);
        giftRecyclerViewAdapter = new GiftRecyclerViewAdapter(getActivity());
        headImage = bindView(R.id.head_imageview_gift);
         //TODO rv 的点击跳转事件
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_everyday_fragment_gift;
    }

    public void initFragmentChose() {
        if (getArguments() != null) {
            type = getArguments().getInt(GIFT_KEY);
        }
        netData(type);

    }

    private void netData(final int whatPage) {
        // 请求"精选"正常数据
        String url1 = Values.TABLAYOUT_ITEMSFRONT_GIFT + Values.TABLAYOUT_ID_GIFT.get(whatPage) + Values.TABLAYOUT_ITEMSBACK_GIFT;
        Log.d("榜单网址", url1);
        GsonRequest<TabLayoutItemBeansGift> gsonRequest1 = new GsonRequest<>(TabLayoutItemBeansGift.class, url1, new Response.Listener<TabLayoutItemBeansGift>() {
            @Override
            public void onResponse(TabLayoutItemBeansGift response) {
                // 请求成功的方法
                VolleySingleton.getInstance().getImage(response.getData().getCover_image(), headImage);
                giftRecyclerViewAdapter.setTabLayoutItemBeansGift(response);
                rv.setAdapter(giftRecyclerViewAdapter);
                GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                rv.setLayoutManager(manager);
                header.attachTo(rv, true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest1);

    }



}
