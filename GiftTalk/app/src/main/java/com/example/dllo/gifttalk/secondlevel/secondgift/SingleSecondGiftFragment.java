package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.beans.TabLayoutItemBeansGift;
import com.example.dllo.gifttalk.tools.GsonRequest;
import com.example.dllo.gifttalk.tools.Values;
import com.example.dllo.gifttalk.tools.VolleySingleton;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * Created by dllo on 16/11/4.
 */
public class SingleSecondGiftFragment extends BaseFragment {

    private RollPagerView rollVp;
    private TextView title;
    private TextView num;
    private TextView title2;
    private TextView price;
    private TextView follow;
    private TextView text;
    private int position;
    private TabLayoutItemBeansGift beansGift;
    private RecyclerView horRV;
    private RecyclerView verRV;

    @Override
    protected void initData() {
        position = VPSecondGiftAdapter.getPosition();
        beansGift = VPSecondGiftAdapter.getTabLayoutItemBeansGift();
        // 文字显示
        initText();
        // 轮播图
        RollView();
        // 横向recyclerView
        initHorRV();
        // 纵向recyclerView
        initVerRV();


    }

    private void initVerRV() {

        // 请求正常数据
        String url1 = Values.SECOND_GIFT_FRONT + beansGift.getData().getItems().get(position).getId() + Values.SECOND_GIFT_BACK;
        GsonRequest<TabLayoutItemBeansGift> gsonRequest = new GsonRequest<>(TabLayoutItemBeansGift.class, url1, new Response.Listener<TabLayoutItemBeansGift>() {
            @Override
            public void onResponse(TabLayoutItemBeansGift response) {
                // 请求成功的方法
                VerRVAdapter verRVAdapter = new VerRVAdapter(getActivity());
                verRVAdapter.setNewBeans(response);
                verRV.setAdapter(verRVAdapter);
                GridLayoutManager manager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
                verRV.setLayoutManager(manager);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest);

    }

    private void initHorRV() {
        HorRVAdapter horRVAdapter = new HorRVAdapter();
        horRV.setAdapter(horRVAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        horRV.setLayoutManager(manager);
    }

    private void initText() {
        num.setText(String.valueOf(position + 1));
        Log.d("S1234", "position:" + position);

        Log.d("S1234", beansGift.getData().getItems().get(position).getShort_description());
        title.setText(beansGift.getData().getItems().get(position).getShort_description());
        title2.setText(beansGift.getData().getItems().get(position).getName());
        price.setText(beansGift.getData().getItems().get(position).getPrice());
        follow.setText(String.valueOf(beansGift.getData().getItems().get(position).getFavorites_count()));
        text.setText(beansGift.getData().getItems().get(position).getDescription());
    }

    @Override
    protected void initView() {
        num = bindView(R.id.num_second_everyday_gift);
        rollVp = bindView(R.id.rollvp_second_gift);
        title = bindView(R.id.title_second_gift);
        title2 = bindView(R.id.title2_second_gift);
        price = bindView(R.id.price_second_gift);
        follow = bindView(R.id.follow_second_gift);
        text = bindView(R.id.text_second_gift);
        horRV = bindView(R.id.rv_hor_second_gift);
        verRV = bindView(R.id.rv_ver_second_gift);
        ScrollView sv = bindView(R.id.sv_single_second);

    }

    @Override
    protected int getLayout() {
        return R.layout.second_single_gift;
    }

    private void RollView() {
        RollPagerView rollPagerView = bindView(R.id.rollvp_second_gift);
        rollPagerView.setHintView(new ColorPointHintView(context, Color.RED, Color.WHITE));
        RollVPSecondGiftAdapter adapter = new RollVPSecondGiftAdapter(rollPagerView);
        adapter.setBeans(beansGift);
        adapter.setPosition(position);
        rollPagerView.setAdapter(adapter);
    }
}
