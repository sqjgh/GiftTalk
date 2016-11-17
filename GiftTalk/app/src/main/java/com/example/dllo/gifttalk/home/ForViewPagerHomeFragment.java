package com.example.dllo.gifttalk.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.beans.RollViewBeans;
import com.example.dllo.gifttalk.beans.TabLayoutItemBeans;
import com.example.dllo.gifttalk.tools.GsonRequest;
import com.example.dllo.gifttalk.tools.Values;
import com.example.dllo.gifttalk.tools.VolleySingleton;
import com.example.dllo.gifttalk.home.rollviewpager.RollViewPagerAdapter;
import com.example.dllo.gifttalk.secondlevel.secondhome.WebViewActivity;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * Created by dllo on 16/10/25.
 */
class ForViewPagerHomeFragment extends BaseFragment implements ClickListViewHome {

    public static String HOME_KEY = "pos";
    public int type;
    private FirstListViewAdapter firstListViewAdapter;
    private ListView listView;
    private View v;
    private ImageView imageView;
    private SwipeRefreshLayout refresh;
    private boolean REFRESH = false;
    private boolean REFRESH_DATA = false;
    private TabLayoutItemBeans RefreshTabLayoutItemBeans;
    private String refreshUrl;
    private int perItemCount;
    private ImageView toTop;

    @Override
    protected void initData() {

        REFRESH = false;
        if (getArguments() != null) {
            type = getArguments().getInt(HOME_KEY);
        }

        // 判断进入的是哪个页面
        initPage(type);
        // 下拉刷新 上拉加载监听
        initListener();
    }

    private void initListener() {
        toTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setSelection(0);
                toTop.setVisibility(View.GONE);
            }
        });
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (type == 0) {
                    REFRESH = true;
                    initPage(type);
                } else {
                    netData(type);
                }
            }
        });


    }

    @Override
    protected void initView() {
        listView = bindView(R.id.listview_vp_home);
        firstListViewAdapter = new FirstListViewAdapter(context);
        imageView = bindView(R.id.loading_anim_home);
        refresh = bindView(R.id.refresh_home);
        toTop = bindView(R.id.to_top_home);
    }

    @Override
    protected int getLayout() {
        return R.layout.lv_home;
    }

    public static ForViewPagerHomeFragment getInstance(int pos) {
        ForViewPagerHomeFragment fragment = new ForViewPagerHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(HOME_KEY, pos);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void initPage(int type) {
        if (type == 0) {
            // 轮播图
            //创建请求
            GsonRequest<RollViewBeans> gsonRequest = new GsonRequest<>(RollViewBeans.class, Values.ROLLVIEW_URL, new Response.Listener<RollViewBeans>() {
                @Override
                public void onResponse(RollViewBeans response) {
                    // 请求成功的方法
                    // 添加头布局轮播图
                    v = LayoutInflater.from(context).inflate(R.layout.rollviewpager_home, null);
                    RollPagerView rollPagerView = (RollPagerView) v.findViewById(R.id.rollvp_home);
                    rollPagerView.setHintView(new ColorPointHintView(context, Color.RED, Color.WHITE));
                    RollViewPagerAdapter adapter = new RollViewPagerAdapter(rollPagerView);
                    adapter.setRollViewBeans(response);
                    rollPagerView.setAdapter(adapter);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            //请求放入请求队列
            VolleySingleton.getInstance().addRequest(gsonRequest);
            firstNetData();
        } else {
            netData(type);
        }
    }

    public void firstNetData() {
        // 请求"精选"正常数据
        String url1 = Values.TABLAYOUT_ITEMSFRONT_HOME + Values.TABLAYOUT_ID_HOME.get(0) + Values.TABLAYOUT_ITEMSBACK_HOME;
        GsonRequest<TabLayoutItemBeans> gsonRequest1 = new GsonRequest<>(TabLayoutItemBeans.class, url1, new Response.Listener<TabLayoutItemBeans>() {
            @Override
            public void onResponse(final TabLayoutItemBeans response) {
                // 请求成功的方法
                imageView.setVisibility(View.GONE);
                firstListViewAdapter.setTabLayoutItemBeans(response);
                // 接口指针指向
                firstListViewAdapter.setClickListViewHome(ForViewPagerHomeFragment.this);
                if (REFRESH == false) {
                    listView.addHeaderView(v);
                }

                listView.setAdapter(firstListViewAdapter);  // TODO 空指针
                refresh.setRefreshing(false);
                // 上拉加载监听
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView absListView, int i) {

                    }

                    @Override
                    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                        if (i < perItemCount) {
                            toTop.setVisibility(View.VISIBLE);
                        }
                        if (i > perItemCount || i < 5) {
                            toTop.setVisibility(View.GONE);
                        }
                        perItemCount = i;

                        if (4 <= (absListView.getCount() - i)) {
                            REFRESH_DATA = false;
                        }
                        if (((absListView.getCount() - i) < 4) && (REFRESH_DATA == false)) {
                            if (null == firstListViewAdapter.getRefreshNextUrl()) {
                                scrollNetData(response.getData().getPaging().getNext_url());
                            } else {
                                scrollNetData(firstListViewAdapter.getRefreshNextUrl());
                            }

                            REFRESH_DATA = true;
                        }
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest1);
    }

    public void netData(int whatType) {
        // 请求正常数据
        String url1 = Values.TABLAYOUT_ITEMSFRONT_HOME + Values.TABLAYOUT_ID_HOME.get(whatType) + Values.TABLAYOUT_ITEMSBACK_HOME;
        GsonRequest<TabLayoutItemBeans> gsonRequest = new GsonRequest<>(TabLayoutItemBeans.class, url1, new Response.Listener<TabLayoutItemBeans>() {
            @Override
            public void onResponse(final TabLayoutItemBeans response) {
                // 请求成功的方法
                imageView.setVisibility(View.GONE);
                firstListViewAdapter.setTabLayoutItemBeans(response);
                firstListViewAdapter.setClickListViewHome(ForViewPagerHomeFragment.this);
                listView.setAdapter(firstListViewAdapter);
                refresh.setRefreshing(false);
                // 上拉加载监听
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView absListView, int i) {

                    }

                    @Override
                    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                        if (i < perItemCount) {
                            toTop.setVisibility(View.VISIBLE);
                        }
                        if (i > perItemCount || i < 5) {
                            toTop.setVisibility(View.GONE);
                        }
                        perItemCount = i;


                        if (4 <= (absListView.getCount() - i)) {
                            REFRESH_DATA = false;
                        }
                        if (((absListView.getCount() - i) < 4) && (REFRESH_DATA == false)) {
                            if (null == firstListViewAdapter.getRefreshNextUrl()) {
                                scrollNetData(response.getData().getPaging().getNext_url());
                            } else {
                                scrollNetData(firstListViewAdapter.getRefreshNextUrl());
                            }

                            REFRESH_DATA = true;
                        }
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }

    public void scrollNetData(String url) {

        // 网络请求
        // 请求正常数据
        GsonRequest<TabLayoutItemBeans> gsonRequest1 = new GsonRequest<>(TabLayoutItemBeans.class, url, new Response.Listener<TabLayoutItemBeans>() {

            @Override
            public void onResponse(final TabLayoutItemBeans response) {
                // 设置全局的刷新过的数据类
                refreshUrl = response.getData().getPaging().getNext_url();
                // 请求成功的方法
                // 填充布局
                for (int i3 = 0; i3 < response.getData().getItems().size(); i3++) {
                    View v = LayoutInflater.from(context).inflate(R.layout.item_rv_vp_home, null);

                    ImageView pic = (ImageView) v.findViewById(R.id.iv_item_home);
                    TextView title = (TextView) v.findViewById(R.id.title_item_home);
                    TextView title2 = (TextView) v.findViewById(R.id.title2_item_home);
                    TextView column = (TextView) v.findViewById(R.id.column_item_home);
                    TextView column2 = (TextView) v.findViewById(R.id.column2_item_home);
                    TextView follow = (TextView) v.findViewById(R.id.follow_item_home);

                    VolleySingleton.getInstance().getImage(response.getData().getItems().get(i3).getCover_image_url(), pic);
                    title.setText(response.getData().getItems().get(i3).getTitle());
                    if (response.getData().getItems().get(i3).getColumn() == null) {
                        column.setVisibility(View.GONE);
                        column2.setVisibility(View.GONE);
                    } else {
                        column2.setText(response.getData().getItems().get(i3).getColumn().getTitle());
                    }
                    String str = response.getData().getItems().get(i3).getIntroduction();
                    if (str.length() > 46) {
                        String re = str.substring(0, 45);
                        title2.setText(re + "...");
                    } else {
                        title2.setText(response.getData().getItems().get(i3).getIntroduction());
                    }
                    follow.setText(String.valueOf(response.getData().getItems().get(i3).getLikes_count()));

                    final int ii = i3;
                    // 页面跳转
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), WebViewActivity.class);
                            intent.putExtra("url", response.getData().getItems().get(ii).getUrl());
                            startActivity(intent);
                        }
                    });


                    listView.addFooterView(v);
                }
                // 设置
                firstListViewAdapter.setRefreshNextUrl(response.getData().getPaging().getNext_url());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //请求放入请求队列
        VolleySingleton.getInstance().addRequest(gsonRequest1);
        // 成功添加布局
        // respons.size个

    }

    // 点击item跳转到详情页面 接口实现方法
    @Override
    public void onClick(String url) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }


}