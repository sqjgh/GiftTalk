package com.example.dllo.gifttalk.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseFragment;

/**
 * Created by dllo on 16/10/25.
 */
class FragmentForVP extends BaseFragment {
    public static String TABLAYOUT_FRAGMENT = "tab_fragment";
    private TextView txt;
    private int type;

    @Override
    protected void initData() {
        if (getArguments() != null) {
            type = (int) getArguments().getSerializable(TABLAYOUT_FRAGMENT);
        }
    }

    @Override
    protected void initView() {
        txt = bindView(R.id.tab_txt);
        init();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_tablayout;
    }

    public static FragmentForVP newInstance(int type) {
        FragmentForVP fragment = new FragmentForVP();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TABLAYOUT_FRAGMENT, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    protected void init() {
        switch (type) {
            case 0:
                txt.setText("精选");
                break;
            case 1:
                txt.setText("关注");
                break;
            case 2:
                txt.setText("送女票");
                break;
            case 3:
                txt.setText("海淘");
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