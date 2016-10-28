package com.example.dllo.gifttalk.home;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.home.beantools.GsonRequest;
import com.example.dllo.gifttalk.home.beantools.VolleySingleton;
import com.example.dllo.gifttalk.home.rollviewpager.RollViewBeans;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
class ForViewPagerFragment extends BaseFragment {
    public static final String[] tabTitle = new String[]{"精选","关注","送女票", "海淘",
            "科技范","美食","送基友","送爸妈","送同事","送宝贝","设计感","创意生活","文艺风",
            "奇葩搞怪","数码","萌萌哒"};
    public static String KEY = "pos";
    private TextView txt;
    private int type;
    private FirstListViewAdapter firstListViewAdapter;
    private NormalListViewAdapter normalLVAdapter;
    private ListView listView;
    private RollViewBeans rollViewBeans;


    @Override
    protected void initData() {
        if (getArguments() != null) {
            type = getArguments().getInt(KEY);
        }
        // 判断进入的是哪个页面
        init();
        rollViewBeans = new RollViewBeans();
    }

    @Override
    protected void initView() {
        txt = bindView(R.id.tab_txt);
        firstListViewAdapter = new FirstListViewAdapter(getActivity());
        normalLVAdapter = new NormalListViewAdapter(getActivity());
        listView = bindView(R.id.listview_vp_home);

    }

    @Override
    protected int getLayout() {
        return R.layout.listview_home;
    }

    public static ForViewPagerFragment getInstance(int pos) {
        ForViewPagerFragment fragment = new ForViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY, pos);
        fragment.setArguments(bundle);
        Log.d("ForViewPagerFragment", "getInstance");
        return fragment;
    }

    protected void init() {
        switch (type) {
            case 0:
                // 轮播图
                String url = "http://api.liwushuo.com/v2/banners";
                //创建请求
                GsonRequest<RollViewBeans> gsonRequest = new GsonRequest<>(RollViewBeans.class, url, new Response.Listener<RollViewBeans>() {
                    @Override
                    public void onResponse(RollViewBeans response) {
                        // 请求成功的方法
                        firstListViewAdapter.setRollView(response);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                //请求放入请求队列
                VolleySingleton.getInstance().addRequest(gsonRequest);

                break;

            case 1:
                ArrayList<HomeBeans> arrayList1 = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    HomeBeans beans = new HomeBeans();
                    beans.setPic(R.mipmap.ic_launcher);
                    beans.setTitle("1大标题" + i);
                    beans.setTitle2("1简介" + i);
                    beans.setColumn("栏目" + i);
                    beans.setColumn2("栏目来源" + i);
                    beans.setFollow("数量" + i);
                    arrayList1.add(beans);
                }
                normalLVAdapter.setArrayList(arrayList1);
                listView.setAdapter(normalLVAdapter);
                break;
            case 2:
                ArrayList<HomeBeans> arrayList2 = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    HomeBeans beans = new HomeBeans();
                    beans.setPic(R.mipmap.ic_launcher);
                    beans.setTitle("1大标题" + i);
                    beans.setTitle2("1简介" + i);
                    beans.setColumn("栏目" + i);
                    beans.setColumn2("栏目来源" + i);
                    beans.setFollow("数量" + i);
                    arrayList2.add(beans);
                }
                normalLVAdapter.setArrayList(arrayList2);
                listView.setAdapter(normalLVAdapter);
                break;
            case 3:
                ArrayList<HomeBeans> arrayList3 = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    HomeBeans beans = new HomeBeans();
                    beans.setPic(R.mipmap.ic_launcher);
                    beans.setTitle("1大标题" + i);
                    beans.setTitle2("1简介" + i);
                    beans.setColumn("栏目" + i);
                    beans.setColumn2("栏目来源" + i);
                    beans.setFollow("数量" + i);
                    arrayList3.add(beans);
                }
                normalLVAdapter.setArrayList(arrayList3);
                listView.setAdapter(normalLVAdapter);

                break;
            case 4:
                txt.setText("科技范");
                break;
            case 5:
                txt.setText("美食");
                break;
            case 6:
                txt.setText("送基友");
                break;
            case 7:
                txt.setText("送爸妈");
                break;
            case 8:
                txt.setText("送同事");
                break;
            case 9:
                txt.setText("送宝贝");
                break;
            case 10:
                txt.setText("设计感");
                break;
            case 11:
                txt.setText("创意生活");
                break;
            case 12:
                txt.setText("文艺风");
                break;
            case 13:
                txt.setText("奇葩搞怪");
                break;
            case 14:
                txt.setText("数码");
                break;
            case 15:
                txt.setText("萌萌哒");
                break;

        }


    }

}