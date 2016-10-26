package com.example.dllo.gifttalk.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
class FragmentForVP extends BaseFragment {
    public static String KEY = "pos";
    private TextView txt;
    private int type;
    private HomeRecyclerViewAdapter adapterRV;
    private RecyclerView recyclerView;


    @Override
    protected void initData() {
        if (getArguments() != null) {
            type = getArguments().getInt(KEY);
        }


        // 判断进入的是哪个页面
        init();
    }

    @Override
    protected void initView() {
        txt = bindView(R.id.tab_txt);
        adapterRV = new HomeRecyclerViewAdapter(getActivity());
        recyclerView = bindView(R.id.recyclerview_vp_home);

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_tablayout;
    }

    public static FragmentForVP getInstance(int pos) {
        FragmentForVP fragment = new FragmentForVP();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY, pos);
        fragment.setArguments(bundle);
        Log.d("FragmentForVP", "getInstance");
        return fragment;
    }

    protected void init() {
        switch (type) {
            case 0:
                ArrayList<HomeBeans> arrayList = new ArrayList<>();
                for (int i = 0; i < 50; i++) {
                    HomeBeans beans = new HomeBeans();
                    beans.setPic(R.mipmap.ic_launcher);
                    beans.setTitle("0大标题" + i);
                    beans.setTitle2("0简介" + i);
                    beans.setColumn("栏目" + i);
                    beans.setColumn2("栏目来源" + i);
                    beans.setFollow("数量" + i);
                    arrayList.add(beans);
                }
                adapterRV.setArrayList(arrayList);
                recyclerView.setAdapter(adapterRV);
                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                break;
            case 1:
                ArrayList<HomeBeans> arrayList1 = new ArrayList<>();
                for (int i = 0; i < 50; i++) {
                    HomeBeans beans = new HomeBeans();
                    beans.setPic(R.mipmap.ic_launcher);
                    beans.setTitle("1大标题" + i);
                    beans.setTitle2("1简介" + i);
                    beans.setColumn("栏目" + i);
                    beans.setColumn2("栏目来源" + i);
                    beans.setFollow("数量" + i);
                    arrayList1.add(beans);
                }
                adapterRV.setArrayList(arrayList1);
                recyclerView.setAdapter(adapterRV);
                LinearLayoutManager manager1 = new LinearLayoutManager(getActivity());
                manager1.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager1);
                break;
            case 2:
                ArrayList<HomeBeans> arrayList2 = new ArrayList<>();
                for (int i = 0; i < 50; i++) {
                    HomeBeans beans = new HomeBeans();
                    beans.setPic(R.mipmap.ic_launcher);
                    beans.setTitle("2大标题" + i);
                    beans.setTitle2("2简介" + i);
                    beans.setColumn("栏目" + i);
                    beans.setColumn2("栏目来源" + i);
                    beans.setFollow("数量" + i);
                    arrayList2.add(beans);
                }
                adapterRV.setArrayList(arrayList2);
                recyclerView.setAdapter(adapterRV);
                LinearLayoutManager manager2 = new LinearLayoutManager(getActivity());
                manager2.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager2);
                break;
            case 3:
                ArrayList<HomeBeans> arrayList3 = new ArrayList<>();
                for (int i = 0; i < 50; i++) {
                    HomeBeans beans = new HomeBeans();
                    beans.setPic(R.mipmap.ic_launcher);
                    beans.setTitle("3大标题" + i);
                    beans.setTitle2("3简介" + i);
                    beans.setColumn("栏目" + i);
                    beans.setColumn2("栏目来源" + i);
                    beans.setFollow("数量" + i);
                    arrayList3.add(beans);
                }
                adapterRV.setArrayList(arrayList3);
                recyclerView.setAdapter(adapterRV);
                LinearLayoutManager manager3 = new LinearLayoutManager(getActivity());
                manager3.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager3);
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