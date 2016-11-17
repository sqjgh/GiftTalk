package com.example.dllo.gifttalk.secondlevel.secondgift;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.tools.GsonRequest;
import com.example.dllo.gifttalk.tools.Values;
import com.example.dllo.gifttalk.tools.VolleySingleton;
import com.example.dllo.gifttalk.beans.TabLayoutItemBeansGift;
import com.example.dllo.gifttalk.secondlevel.secondgift.secondgiftbeans.CommentGiftBeans;

/**
 * Created by dllo on 16/11/4.
 */
public class CommentSecondGiftFragment extends BaseFragment{


    private ListView lv;
    private TabLayoutItemBeansGift beansGift;
    private int position;
    private LinearLayout noCommont;

    @Override
    protected void initData() {
        beansGift = VPSecondGiftAdapter.getTabLayoutItemBeansGift();
        position = VPSecondGiftAdapter.getPosition();
        // listView 网络数据
        initNetData();
    }



    @Override
    protected void initView() {
        lv = bindView(R.id.lv_comment_second_gift);
        noCommont = bindView(R.id.ll_no_comment_second);

    }

    @Override
    protected int getLayout() {
        return R.layout.second_comment_gift;
    }


    private void initNetData() {
        // 请求正常数据
        String url1 = Values.SECOND_COMMENTS_FRONT + beansGift.getData().getItems().get(position).getId() + Values.SECOND_COMMENTS_BACK;
        Log.d("C111", url1);
        GsonRequest<CommentGiftBeans> gsonRequest = new GsonRequest<>(CommentGiftBeans.class, url1, new Response.Listener<CommentGiftBeans>() {
            @Override
            public void onResponse(CommentGiftBeans response) {
                // 请求成功的方法
                CommentSecondLVAdapter adapter = new CommentSecondLVAdapter();
                adapter.setCommentGiftBeans(response);
                if (response.getData().getComments().size() == 0){
                    noCommont.setVisibility(View.VISIBLE);
                }
                lv.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }
}
