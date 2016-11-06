package com.example.dllo.gifttalk.home;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.Values;
import com.example.dllo.gifttalk.base.BaseFragment;
import com.example.dllo.gifttalk.beantools.GsonRequest;
import com.example.dllo.gifttalk.beantools.VolleySingleton;
import com.example.dllo.gifttalk.home.homebeans.TabLayoutBeans;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private TabLayout tbl;
    private ViewPager vp;
    private ViewPagerAdapter adapter;
    private ImageView three;
    private RelativeLayout search;
    private ImageView remind;
    private PopupWindow popupWindow;
    private LinearLayout ll;
    private RecyclerView rv;
    private PopupWindowRVAdapter popupWindowRVAdapter;


    // 各种findViewById
    @Override
    protected void initView() {
        tbl = bindView(R.id.tbl_home);
        vp = bindView(R.id.viewpager_home);
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        three = bindView(R.id.btn_three_tbl_home);
        search = bindView(R.id.search_btn_home);
        remind = bindView(R.id.giftremind_title_main);
        ll = bindView(R.id.ll_title_home);


    }

    @Override
    protected void initData() {
        initTablayout();
        popupWindowRVAdapter = new PopupWindowRVAdapter();
        initClickListener();

    }



    // 绑定进入布局
    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }
    public void initTablayout(){
        GsonRequest<TabLayoutBeans> gsonRequest = new GsonRequest<>(TabLayoutBeans.class, Values.TABLAYOUT_URL_HOME, new Response.Listener<TabLayoutBeans>() {
            @Override
            public void onResponse(TabLayoutBeans response) {
                // 请求成功的方法
                ArrayList<String> str = new ArrayList<>();
                for (int i = 0; i < response.getData().getChannels().size(); i++) {
                    str.add(String.valueOf(response.getData().getChannels().get(i).getId()));
                }
                popupWindowRVAdapter.setTabLayoutBeans(response);
                Values.TABLAYOUT_ID_HOME = str;
                adapter.setTabLayoutBeans(response);
                vp.setAdapter(adapter);
                tbl.setupWithViewPager(vp);
                tbl.setTabMode(TabLayout.MODE_SCROLLABLE);
                tbl.setTabTextColors(Color.DKGRAY, Color.RED);
                tbl.setSelectedTabIndicatorColor(Color.RED);
                // 小三角点击事件

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance().addRequest(gsonRequest);
    }


    void initClickListener(){
        three.setOnClickListener(this);
        search.setOnClickListener(this);
        remind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_three_tbl_home:
                Toast.makeText(context, "zou", Toast.LENGTH_SHORT).show();
                showPopUp();
                break;
            case R.id.search_btn_home:
                break;
            case R.id.giftremind_title_main:
                break;
        }
    }

    private void showPopUp() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,4, LinearLayoutManager.VERTICAL,false);

        // 利用layoutInflater获得View
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.popwindowlayout, null);
        rv = (RecyclerView) view.findViewById(R.id.rv_popupwindow);
        rv.setAdapter(popupWindowRVAdapter);
        rv.setLayoutManager(gridLayoutManager);
        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);


        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(dw);


        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        window.showAsDropDown(ll,0,0);

        // 这里检验popWindow里的button是否可以点击
        Button first = (Button) view.findViewById(R.id.first);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("HomeFragment", "diandiandain");
                ForViewPagerHomeFragment forViewPagerHomeFragment = new ForViewPagerHomeFragment();
                ForViewPagerHomeFragment.getInstance(5);
            }
        });

        //popWindow消失监听方法
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                System.out.println("popWindow消失");
            }
        });


    }
}
